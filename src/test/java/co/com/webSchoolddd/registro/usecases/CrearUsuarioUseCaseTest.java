package co.com.webSchoolddd.registro.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.webSchoolddd.registro.Cuenta.valor.CuentaId;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;
import co.com.webSchoolddd.registro.Usuario.command.CrearUsuario;
import co.com.webSchoolddd.registro.Usuario.event.UsuarioCreado;
import co.com.webSchoolddd.registro.Usuario.value.UsuarioId;
import co.com.webSchoolddd.useCases.CrearUsuarioUseCase;
import co.com.webSchoolddd.value.Apellido;
import co.com.webSchoolddd.value.Email;
import co.com.webSchoolddd.value.Genero;
import co.com.webSchoolddd.value.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrearUsuarioUseCaseTest {

    @Test
    @DisplayName("Testing crearUsuario")
    void crearUsuario() {
        //arrange
        UsuarioId usuarioId = new UsuarioId();
        EscuelaId escuelaId = new EscuelaId();
        CuentaId cuentaId = new CuentaId();
        Nombre nombre = new Nombre("Jess");
        Apellido apellido = new Apellido("Jhonson");
        Email email = new Email("jess@mail.com");
        Genero genero = new Genero(Genero.Genre.F);

        //act
        var command = new CrearUsuario(
                usuarioId,
                escuelaId,
                cuentaId,
                nombre,
                apellido,
                email,
                genero
        );
        var usecase = new CrearUsuarioUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (UsuarioCreado)events.get(0);
        Assertions.assertEquals("webSchoolddd.registro.usuario.usuarioCreado", event.type);
        Assertions.assertEquals("Jess", event.getNombre().value());
        Assertions.assertEquals("jess@mail.com", event.getEmail().value());
        Assertions.assertEquals(Genero.Genre.F, event.getGenero().value());

    }
}
