package co.com.webSchoolddd.registro.Usuario.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Usuario.value.UsuarioId;
import co.com.webSchoolddd.value.Email;

public class ActualizarEmail extends Command {
    private final UsuarioId usuarioId;
    private final Email email;

    public ActualizarEmail( UsuarioId usuarioId,Email email) {
        this.usuarioId = usuarioId;
        this.email = email;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public Email getEmail() {
        return email;
    }
}
