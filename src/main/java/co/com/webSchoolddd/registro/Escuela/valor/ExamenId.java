package co.com.webSchoolddd.registro.Escuela.valor;

import co.com.sofka.domain.generic.Identity;

public class ExamenId extends Identity {
    private ExamenId(String id) {
        super(id);
    }

    public ExamenId() {}

    private static ExamenId of(String id) {
        return new ExamenId(id);
    }
}
