package co.com.webSchoolddd.registro.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.command.EliminarFuncion;
import co.com.webSchoolddd.registro.Director.event.DirectorCreado;
import co.com.webSchoolddd.registro.Director.event.FuncionAgregada;
import co.com.webSchoolddd.registro.Director.event.FuncionRemovida;
import co.com.webSchoolddd.registro.Director.value.*;
import co.com.webSchoolddd.useCases.EliminarFuncionUseCase;
import co.com.webSchoolddd.value.Apellido;
import co.com.webSchoolddd.value.Email;
import co.com.webSchoolddd.value.Genero;
import co.com.webSchoolddd.value.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EliminarFuncionUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Testing EliminarFuncion")
    void eliminarFuncion() {
        //arrange
        DirectorId directorId = DirectorId.of("xxx");
        FuncionId funcionId = FuncionId.of("xxz");

        //act
        var command = new EliminarFuncion(
                funcionId,
                directorId
        );
        var usecase = new EliminarFuncionUseCase();

        Mockito.when(repository.getEventsBy("xxx")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(directorId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (FuncionRemovida)events.get(0);
        Assertions.assertEquals("webSchoolddd.registro.director.funcionRemovida", event.type);
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
                ),
                new FuncionAgregada(
                        FuncionId.of("xxy"),
                        new Prioridad(Prioridad.NivelPrioridad.ALTO),
                        new Caracteristica("Realizar nuevos cursos")
                ),
                new FuncionRemovida(
                        FuncionId.of("xxy")
                )
        );
    }
}
