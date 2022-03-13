package co.com.webSchoolddd.registro.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.value.DirectorId;
import co.com.webSchoolddd.registro.Escuela.event.CursoAgregado;
import co.com.webSchoolddd.registro.Escuela.event.EscuelaCreada;
import co.com.webSchoolddd.registro.Escuela.event.RetoAgregado;
import co.com.webSchoolddd.registro.Escuela.valor.*;
import co.com.webSchoolddd.service.IJavaMail;
import co.com.webSchoolddd.useCases.NotificarADirectorNuevoCursoUseCase;
import co.com.webSchoolddd.useCases.NotificarDirectorNuevoRetoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class NotificarDirectorNuevoRetoUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Mock
    private IJavaMail service;

    @Test
    @DisplayName("Testing enviar email to director")
    void enviarEmailDirector() {
        //
        var event = new RetoAgregado(
                RetoId.of("xxz"),
                new Author("Luis", "luis@mail.com"),
                new Contenido("Realizar una app con react", new Date()),
                new Descripcion("En este reto se desarrollara un app con react")
        );
        event.setAggregateRootId("yyy");

        //act
        var usecase = new NotificarDirectorNuevoRetoUseCase();
        Mockito.when(repository.getEventsBy("escuela","yyy")).thenReturn(history());
        Mockito.when(service.enviarEmailADirector(Mockito.any(DirectorId.class), Mockito.anyString())).thenReturn(true);

        usecase.addRepository(repository);
        usecase.addServiceBuilder(new ServiceBuilder().addService(service));

        //assert
        var isPresent = UseCaseHandler.getInstance()
                .setIdentifyExecutor("yyy")
                .syncExecutor(usecase, new TriggeredEvent<>(event)).isPresent();
        Assertions.assertTrue(isPresent);
    }

    @Test
    @DisplayName("Testing Fail enviarEmail")
    void falloAlenvioEmail() {
        //
        var event = new RetoAgregado(
                RetoId.of("xxz"),
                new Author("Luis", "luis@mail.com"),
                new Contenido("Realizar una app con react", new Date()),
                new Descripcion("En este reto se desarrollara un app con react")
        );
        event.setAggregateRootId("yyy");

        //act
        var usecase = new NotificarDirectorNuevoRetoUseCase();
        Mockito.when(repository.getEventsBy("escuela","yyy")).thenReturn(history());
        Mockito.when(service.enviarEmailADirector(Mockito.any(DirectorId.class), Mockito.anyString())).thenReturn(false);

        usecase.addRepository(repository);
        usecase.addServiceBuilder(new ServiceBuilder().addService(service));

        //act
        var mensaje = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor("yyy")
                    .syncExecutor(usecase, new TriggeredEvent<>(event));
        }).getMessage();

        Assertions.assertEquals("No se pudo enviar el email", mensaje);
    }

    private List<DomainEvent> history() {
        return List.of(
                new EscuelaCreada(
                        new Nombre("Desarrollo Web"),
                        DirectorId.of("aaa")
                )
        );
    }
}
