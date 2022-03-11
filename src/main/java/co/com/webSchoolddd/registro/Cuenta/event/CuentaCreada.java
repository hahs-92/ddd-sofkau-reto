package co.com.webSchoolddd.registro.Cuenta.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Cuenta.valor.Suscripcion;


public class CuentaCreada extends DomainEvent {
    private final Suscripcion suscripcion;

    public CuentaCreada(Suscripcion suscripcion) {
        super("webSchoolddd.registro.cuenta.cuentaCreada");
        this.suscripcion = suscripcion;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }
}
