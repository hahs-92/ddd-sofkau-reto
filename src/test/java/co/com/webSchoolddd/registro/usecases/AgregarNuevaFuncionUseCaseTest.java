package co.com.webSchoolddd.registro.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.webSchoolddd.registro.Director.Director;
import co.com.webSchoolddd.registro.Director.command.AgregarNuevaFuncion;
import co.com.webSchoolddd.registro.Director.event.FuncionAgregada;
import co.com.webSchoolddd.registro.Director.valor.*;
import co.com.webSchoolddd.useCases.AgregarNuevaFuncionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class AgregarNuevaFuncionUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Testing AgregarNuevaFuncion")
    void agregarFuncion() {
        //arrange
        DirectorId directorId = DirectorId.of("xxx");
        Director director = new Director(
                directorId,
                new Nombre("Raul"),
                new Apellido("Test"),
                new Email("raul@email.com"),
                new Genero(Genero.Genre.M)
        );

        FuncionId funcionId = FuncionId.of("xxx");
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

        /*
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var event = (FuncionAgregada)events.get(0);

        Assertions.assertEquals("webSchoolddd.registro.director.funcionAgregada", event.type);*/
    }
}
