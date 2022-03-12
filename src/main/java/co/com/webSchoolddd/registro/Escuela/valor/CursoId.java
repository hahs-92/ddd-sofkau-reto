package co.com.webSchoolddd.registro.Escuela.valor;

import co.com.sofka.domain.generic.Identity;

public class CursoId  extends Identity {

    private CursoId(String id) {
        super(id);
    }

    public CursoId() {}

    public static CursoId of(String id) {
        return new CursoId(id);
    }
}
