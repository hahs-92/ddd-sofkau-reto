package co.com.webSchoolddd.registro.Cuenta.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Cuenta.valor.Suscripcion;

public class CambiarSuscripcion extends Command {
    private final Suscripcion suscripcion;

    public CambiarSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }
}
