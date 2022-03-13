package co.com.webSchoolddd.registro.Usuario.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Usuario.value.UsuarioId;
import co.com.webSchoolddd.value.Genero;

public class CambiarGenero extends Command {
    private final UsuarioId usuarioId;
    private final Genero genero;

    public CambiarGenero(UsuarioId usuarioId,Genero genero) {
        this.usuarioId = usuarioId;
        this.genero = genero;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public Genero getGenero() {
        return genero;
    }
}
