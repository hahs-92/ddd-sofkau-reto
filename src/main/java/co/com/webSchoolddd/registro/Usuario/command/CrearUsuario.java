package co.com.webSchoolddd.registro.Usuario.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Cuenta.valor.CuentaId;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;
import co.com.webSchoolddd.registro.Usuario.value.UsuarioId;
import co.com.webSchoolddd.value.Apellido;
import co.com.webSchoolddd.value.Email;
import co.com.webSchoolddd.value.Nombre;

public class CrearUsuario extends Command {
    private final UsuarioId usuarioId;
    private final EscuelaId escuelaId;
    private final CuentaId cuentaId;
    private final Nombre nombre;
    private final Apellido apellido;
    private final Email email;

    public CrearUsuario(
            UsuarioId usuarioId,
            EscuelaId escuelaId,
            CuentaId cuentaId,
            Nombre nombre,
            Apellido apellido,
            Email email
    ) {
        this.usuarioId = usuarioId;
        this.escuelaId = escuelaId;
        this.cuentaId = cuentaId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public EscuelaId getEscuelaId() {
        return escuelaId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Apellido getApellido() {
        return apellido;
    }

    public Email getEmail() {
        return email;
    }
}
