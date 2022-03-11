package co.com.webSchoolddd.registro.Escuela.valor;

import co.com.sofka.domain.generic.Identity;

public class EscuelaId extends Identity {

    private EscuelaId(String id) {
        super(id);
    }

    public EscuelaId() {}

    private static EscuelaId of(String id) {
        return new EscuelaId(id);
    }
}
