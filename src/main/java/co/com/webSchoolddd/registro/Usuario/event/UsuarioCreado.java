package co.com.webSchoolddd.registro.Usuario.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Cuenta.valor.CuentaId;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;
import co.com.webSchoolddd.value.Apellido;
import co.com.webSchoolddd.value.Email;
import co.com.webSchoolddd.value.Genero;
import co.com.webSchoolddd.value.Nombre;

public class UsuarioCreado extends DomainEvent {
    private final EscuelaId escuelaId;
    private final CuentaId cuentaId;
    private final Nombre nombre;
    private final Apellido apellido;
    private final Email email;
    private final Genero genero;

    public UsuarioCreado(
            EscuelaId escuelaId,
            CuentaId cuentaId,
            Nombre nombre,
            Apellido apellido,
            Email email,
            Genero genero
    ) {
        super("webSchoolddd.registro.usuario.usuarioCreado");
        this.escuelaId = escuelaId;
        this.cuentaId = cuentaId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero =genero;
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

    public Genero getGenero() {
        return genero;
    }
}
