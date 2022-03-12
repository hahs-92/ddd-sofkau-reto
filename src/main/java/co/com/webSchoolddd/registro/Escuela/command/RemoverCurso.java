package co.com.webSchoolddd.registro.Escuela.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Escuela.valor.CursoId;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;

public class RemoverCurso extends Command {
    private final EscuelaId escuelaId;
    private final CursoId cursoId;

    public RemoverCurso(EscuelaId escuelaId, CursoId cursoId) {
        this.escuelaId = escuelaId;
        this.cursoId = cursoId;
    }

    public EscuelaId getEscuelaId() {
        return escuelaId;
    }

    public CursoId getCursoId() {
        return cursoId;
    }
}
