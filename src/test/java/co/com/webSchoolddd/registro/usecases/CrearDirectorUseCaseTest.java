package co.com.webSchoolddd.registro.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.webSchoolddd.registro.Director.command.CrearDirector;
import co.com.webSchoolddd.registro.Director.event.DirectorCreado;
import co.com.webSchoolddd.registro.Director.valor.*;
import co.com.webSchoolddd.useCases.CrearDirectorUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrearDirectorUseCaseTest {

    @Test
    @DisplayName("Testing crearDirector")
    void crearDirector() {
        //arrange
        DirectorId directorId = new DirectorId();
        Nombre nombre = new Nombre("Alex");
        Apellido apellido = new Apellido("Hernandez");
        Email email = new Email("alex@email.com");
        Genero genero = new Genero(Genero.Genre.M);

        //act
        var command = new CrearDirector(
                directorId,
                nombre,
                apellido,
                email,
                genero
        );
        var usecase = new CrearDirectorUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DirectorCreado)events.get(0);
        Assertions.assertEquals("webSchoolddd.registro.director.directorCreado", event.type);
        Assertions.assertEquals("Alex",event.getNombre().value());
        Assertions.assertEquals("Hernandez", event.getApellido().value());
        Assertions.assertEquals("alex@email.com", event.getEmail().value());
        Assertions.assertEquals(Genero.Genre.M, event.getGenero().value());
    }
}
