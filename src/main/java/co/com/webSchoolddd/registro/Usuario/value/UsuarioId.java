package co.com.webSchoolddd.registro.Usuario.value;

import co.com.sofka.domain.generic.Identity;


public class UsuarioId extends Identity {
    private UsuarioId(String id) {
        super(id);
    }

    public UsuarioId() {}

    private static UsuarioId of(String id) {
        return new UsuarioId(id);
    }
}
