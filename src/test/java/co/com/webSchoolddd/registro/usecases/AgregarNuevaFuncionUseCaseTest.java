package co.com.webSchoolddd.registro.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.Director;
import co.com.webSchoolddd.registro.Director.command.AgregarNuevaFuncion;
import co.com.webSchoolddd.registro.Director.event.DirectorCreado;
import co.com.webSchoolddd.registro.Director.event.FuncionAgregada;
import co.com.webSchoolddd.registro.Director.value.*;
import co.com.webSchoolddd.useCases.AgregarNuevaFuncionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AgregarNuevaFuncionUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Testing AgregarNuevaFuncion")
    void agregarFuncion() {
        //arrange
        DirectorId directorId = DirectorId.of("xxx");

        FuncionId funcionId = FuncionId.of("xxz");
        Prioridad prioridad = new Prioridad(Prioridad.NivelPrioridad.ALTO);
        Caracteristica caracteristica = new Caracteristica("Realizar nuevos cursos");

        //act
        var command = new AgregarNuevaFuncion(
                directorId,
                funcionId,
                prioridad,
                caracteristica
        );
        var usecase = new AgregarNuevaFuncionUseCase();
        Mockito.when(repository.getEventsBy("xxx")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(directorId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var event = (FuncionAgregada)events.get(0);
        Assertions.assertEquals("webSchoolddd.registro.director.funcionAgregada", event.type);
        Assertions.assertEquals("xxz",event.getFuncionId().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new DirectorCreado(
                        new Nombre("Raul"),
                        new Apellido("Test"),
                        new Email("raul@email.com"),
                        new Genero(Genero.Genre.M)
                ),
                new FuncionAgregada(
                        FuncionId.of("xxz"),
                        new Prioridad(Prioridad.NivelPrioridad.ALTO),
                        new Caracteristica("Realizar nuevos cursos")
                )
        );
    }

}
