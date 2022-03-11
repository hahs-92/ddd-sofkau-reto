package co.com.webSchoolddd.registro.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.webSchoolddd.registro.Cuenta.command.CrearCuenta;
import co.com.webSchoolddd.registro.Cuenta.event.CuentaCreada;
import co.com.webSchoolddd.registro.Cuenta.valor.CuentaId;
import co.com.webSchoolddd.registro.Cuenta.valor.Suscripcion;
import co.com.webSchoolddd.useCases.CrearCuentaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrearCuentaUseCaseTest {

    @Test
    @DisplayName("Testing crear cuenta")
    void crearCuenta() {
        //arrange
        CuentaId cuentaId = CuentaId.of("XXX666");
        Suscripcion suscripcion = new Suscripcion(Suscripcion.SuscripcionType.BASIC);

        //act
        var command = new CrearCuenta(cuentaId, suscripcion);
        var usecase = new CrearCuentaUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CuentaCreada)events.get(0);
        Assertions.assertEquals("webSchoolddd.registro.cuenta.cuentaCreada", event.type);
        Assertions.assertEquals(Suscripcion.SuscripcionType.BASIC, event.getSuscripcion().value());
    }
}
