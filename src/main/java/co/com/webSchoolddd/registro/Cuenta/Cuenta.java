package co.com.webSchoolddd.registro.Cuenta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Cuenta.event.CuentaCreada;
import co.com.webSchoolddd.registro.Cuenta.valor.CuentaId;
import co.com.webSchoolddd.registro.Cuenta.valor.Suscripcion;


import java.util.List;

public class Cuenta extends AggregateEvent<CuentaId> {
    protected Suscripcion suscripcion;

    public Cuenta(CuentaId cuentaId, Suscripcion suscripcion) {
        super(cuentaId);
        appendChange(new CuentaCreada(suscripcion));
        subscribe(new CuentaEventChange(this));
    }

    private Cuenta(CuentaId cuentaId) {
        super(cuentaId);
        subscribe(new CuentaEventChange(this));
    }

    public static Cuenta from(CuentaId cuentaId, List<DomainEvent> events) {
        var cuenta = new Cuenta(cuentaId);
        events.forEach(cuenta::applyEvent);
        return cuenta;
    }

    //comportamientos
}
