package co.com.webSchoolddd.registro.Escuela.valor;

import co.com.sofka.domain.generic.Identity;

public class RetoId extends Identity {

    private RetoId(String id) {
        super(id);
    }

    public RetoId() {}

    public static RetoId of(String id) {
        return new RetoId(id);
    }
}
