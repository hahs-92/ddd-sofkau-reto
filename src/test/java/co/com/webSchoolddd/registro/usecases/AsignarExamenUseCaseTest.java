package co.com.webSchoolddd.registro.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.value.DirectorId;
import co.com.webSchoolddd.registro.Escuela.command.AsignarExamen;
import co.com.webSchoolddd.registro.Escuela.event.EscuelaCreada;
import co.com.webSchoolddd.registro.Escuela.event.ExamenAsignado;
import co.com.webSchoolddd.registro.Escuela.valor.*;
import co.com.webSchoolddd.useCases.AsignarExamenUseCase;
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
public class AsignarExamenUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Testing asignarExamen")
    void asignarExamen() {
        //arrange
        EscuelaId escuelaId = EscuelaId.of("xxx");

        ExamenId examenId = ExamenId.of("xxz");
        Author author = new Author("Maicol","mailcom@mail.com");
        Contenido contenido = new Contenido("Que es Redux?", new Date());

        //act
        var command = new AsignarExamen(
                escuelaId,
                examenId,
                author,
                contenido
        );
        var usecase = new AsignarExamenUseCase();
        Mockito.when(repository.getEventsBy("xxx")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(escuelaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ExamenAsignado)events.get(0);
        Assertions.assertEquals("webSchoolddd.registro.escuela.examenAsignado", event.type);
        Assertions.assertEquals("xxz", event.getExamenId().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new EscuelaCreada(
                       new Nombre("Desarrollo Web"),
                        DirectorId.of("xxx")
                )
        );
    }
}
