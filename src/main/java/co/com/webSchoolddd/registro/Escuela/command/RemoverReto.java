package co.com.webSchoolddd.registro.Escuela.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;
import co.com.webSchoolddd.registro.Escuela.valor.RetoId;

public class RemoverReto extends Command {
    private final EscuelaId escuelaId;
    private final RetoId retoId;

    public RemoverReto(EscuelaId escuelaId, RetoId retoId) {
        this.escuelaId = escuelaId;
        this.retoId = retoId;
    }

    public EscuelaId getEscuelaId() {
        return escuelaId;
    }

    public RetoId getRetoId() {
        return retoId;
    }
}
