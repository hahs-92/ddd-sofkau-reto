package co.com.webSchoolddd.registro.Escuela.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Escuela.valor.CursoId;

public class CursoRemovido extends DomainEvent {
    private final CursoId cursoId;

    public CursoRemovido(CursoId cursoId) {
        super("webSchoolddd.registro.escuela.cursoRemovido");
        this.cursoId = cursoId;
    }

    public CursoId getCursoId() {
        return cursoId;
    }
}
