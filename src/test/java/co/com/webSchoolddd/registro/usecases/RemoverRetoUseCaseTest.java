package co.com.webSchoolddd.registro.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.value.DirectorId;
import co.com.webSchoolddd.registro.Escuela.command.RemoverReto;
import co.com.webSchoolddd.registro.Escuela.event.*;
import co.com.webSchoolddd.registro.Escuela.valor.*;
import co.com.webSchoolddd.useCases.RemoverRetoUseCase;
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
public class RemoverRetoUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Testing removerReto")
    void removerReto() {
        //arrange
        EscuelaId escuelaId = EscuelaId.of("xxx");
        RetoId retoId = RetoId.of("xxz");

        //act
        var command = new RemoverReto(escuelaId, retoId);
        var usecase = new RemoverRetoUseCase();

        Mockito.when(repository.getEventsBy("xxx")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(escuelaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (RetoRemovido)events.get(0);
        Assertions.assertEquals("webSchoolddd.registro.escuela.retoRemovido", event.type);
        Assertions.assertEquals("xxz", event.getRetoId().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new EscuelaCreada(
                        new Nombre("Desarrollo Web"),
                        DirectorId.of("zzz")
                ),
                new BlogAsignado(
                        BlogId.of("aaa"),
                        new Contenido("Como hacer un useHook", new Date()),
                        new Author("Maria", "maria@mail.com")
                ),
                new ExamenAsignado(
                        ExamenId.of("bbb"),
                        new Author("Lucas", "lucas@mail.com"),
                        new Contenido("Ques es React?", new Date())
                ),
                new RetoAgregado(
                        RetoId.of("xxz"),
                        new Author("Raul", "raul@mail.com"),
                        new Contenido("Crear una App with React", new Date()),
                        new Descripcion("En este reto se debe crear una App")
                )
        );
    }
}

