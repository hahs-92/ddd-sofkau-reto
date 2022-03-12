package co.com.webSchoolddd.registro.Cuenta.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Cuenta.valor.Suscripcion;

public class SuscripcionCambiada extends DomainEvent {
    private final Suscripcion suscripcion;

    public SuscripcionCambiada(Suscripcion suscripcion) {
        super("webSchoolddd.registro.cuenta.suscripcionCambiada");
        this.suscripcion = suscripcion;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }
}
