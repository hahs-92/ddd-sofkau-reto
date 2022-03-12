package co.com.webSchoolddd.registro.Usuario;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Cuenta.valor.CuentaId;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;
import co.com.webSchoolddd.registro.Usuario.event.UsuarioCreado;
import co.com.webSchoolddd.registro.Usuario.value.UsuarioId;
import co.com.webSchoolddd.value.Apellido;
import co.com.webSchoolddd.value.Email;
import co.com.webSchoolddd.value.Genero;
import co.com.webSchoolddd.value.Nombre;

import java.util.List;

public class Usuario extends AggregateEvent<UsuarioId> {
    protected EscuelaId escuelaId;
    protected CuentaId cuentaId;
    protected Nombre nombre;
    protected Apellido apellido;
    protected Email email;
    protected Genero genero;

    public Usuario(
            UsuarioId entityId,
            EscuelaId escuelaId,
            CuentaId cuentaId,
            Nombre nombre,
            Apellido apellido,
            Email email,
            Genero genero
    ) {
        super(entityId);
        appendChange(new UsuarioCreado(
                escuelaId,
                cuentaId,
                nombre,
                apellido,
                email,
                genero
        ));
        subscribe(new UsuarioEventChange(this));
    }

    private Usuario(UsuarioId usuarioId) {
        super(usuarioId);
        subscribe(new UsuarioEventChange(this));
    }

    public static Usuario from(UsuarioId usuarioId, List<DomainEvent> events) {
        var usuario = new Usuario(usuarioId);
        events.forEach(usuario::applyEvent);
        return usuario;
    }

    //comportamientos


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

    public Genero genero() {
        return genero;
    }
}
