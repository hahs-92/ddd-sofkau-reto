package co.com.webSchoolddd.registro.Escuela.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Escuela.valor.RetoId;

public class RetoRemovido extends DomainEvent {
    private final RetoId retoId;


    public RetoRemovido(RetoId retoId) {
        super("webSchoolddd.registro.escuela.retoRemovido");
        this.retoId = retoId;
    }

    public RetoId getRetoId() {
        return retoId;
    }
}
