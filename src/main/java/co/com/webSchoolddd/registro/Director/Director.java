package co.com.webSchoolddd.registro.Director;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.entity.Funcion;
import co.com.webSchoolddd.registro.Director.event.DirectorCreado;
import co.com.webSchoolddd.registro.Director.valor.*;

import java.util.List;

public class Director extends AggregateEvent<DirectorId> {
    protected Nombre nombre;
    protected Apellido apellido;
    protected Email email;
    protected Genero genero;
    protected List<Funcion> funciones;

    public Director(
            DirectorId entityId,
            Nombre nombre,
            Apellido apellido,
            Email email,
            Genero genero
    ) {
        super(entityId);
        appendChange(new DirectorCreado(
                nombre,
                apellido,
                email,
                genero
        )).apply();
        subscribe(new DirectorEventChange(this));
    }

    private Director(DirectorId directorId) {
        super(directorId);
        subscribe(new DirectorEventChange(this));
    }

    public static Director from(DirectorId directorId, List<DomainEvent> events) {
        var director = new Director(directorId);
        events.forEach(director::applyEvent);
        return director;
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

    public List<Funcion> funciones() {
        return funciones;
    }
}
