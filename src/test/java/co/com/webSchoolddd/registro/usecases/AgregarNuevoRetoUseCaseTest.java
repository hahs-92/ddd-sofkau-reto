package co.com.webSchoolddd.registro.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.value.DirectorId;
import co.com.webSchoolddd.registro.Escuela.command.AgregarNuevoReto;
import co.com.webSchoolddd.registro.Escuela.event.BlogAsignado;
import co.com.webSchoolddd.registro.Escuela.event.EscuelaCreada;
import co.com.webSchoolddd.registro.Escuela.event.ExamenAsignado;
import co.com.webSchoolddd.registro.Escuela.event.RetoAgregado;
import co.com.webSchoolddd.registro.Escuela.valor.*;
import co.com.webSchoolddd.useCases.AgregarNuevoRetoUseCase;
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
public class AgregarNuevoRetoUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Testing AgregarReto")
    void agregarReto() {
        //arrange
        EscuelaId escuelaId = EscuelaId.of("xxx");

        RetoId retoId = RetoId.of("xxz");
        Author author = new Author("Raul", "raul@mail.com");
        Contenido contenido = new Contenido("Crear una App with React", new Date());
        Descripcion descripcion = new Descripcion("En este reto se debe crear una App");

        //act
        var command = new AgregarNuevoReto(
                escuelaId,
                retoId,
                author,
                contenido,
                descripcion
        );
        var usecase = new AgregarNuevoRetoUseCase();
        Mockito.when(repository.getEventsBy("xxx")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(escuelaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (RetoAgregado)events.get(0);
        Assertions.assertEquals("webSchoolddd.registro.escuela.retoAgregado", event.type);
        Assertions.assertEquals("xxz", event.getRetoId().value());
        Assertions.assertEquals("En este reto se debe crear una App", event.getDescripcion().value());

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
                )
        );
    }
}
