package co.com.webSchoolddd.registro.Usuario;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Cuenta.valor.CuentaId;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;
import co.com.webSchoolddd.registro.Usuario.value.UsuarioId;
import co.com.webSchoolddd.value.Apellido;
import co.com.webSchoolddd.value.Email;
import co.com.webSchoolddd.value.Nombre;

import java.util.List;

public class Usuario extends AggregateEvent<UsuarioId> {
    protected EscuelaId escuelaId;
    protected CuentaId cuentaId;
    protected Nombre nombre;
    protected Apellido apellido;
    protected Email email;

    public Usuario(
            UsuarioId entityId,
            EscuelaId escuelaId,
            CuentaId cuentaId,
            Nombre nombre,
            Apellido apellido,
            Email email
    ) {
        super(entityId);
        this.escuelaId = escuelaId;
        this.cuentaId = cuentaId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    private Usuario(UsuarioId usuarioId) {
        super(usuarioId);
    }

    public static Usuario from(UsuarioId usuarioId, List<DomainEvent> events) {
        var usuario = new Usuario(usuarioId);
        events.forEach(usuario::applyEvent);
        return usuario;
    }


    //accesos


    public EscuelaId escuelaId() {
        return escuelaId;
    }

    public CuentaId cuentaId() {
        return cuentaId;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Apellido apellido() {
        return apellido;
    }

    public Email email() {
        return email;
    }
}
