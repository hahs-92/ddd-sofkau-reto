package co.com.webSchoolddd.registro.Cuenta.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Cuenta.valor.Suscripcion;

public class CambiarSuscripcion extends Command {
    private final Suscripcion.SuscripcionType suscripcion;

    public CambiarSuscripcion(Suscripcion.SuscripcionType suscripcion) {
        this.suscripcion = suscripcion;
    }

    public Suscripcion.SuscripcionType getSuscripcion() {
        return suscripcion;
    }
}
