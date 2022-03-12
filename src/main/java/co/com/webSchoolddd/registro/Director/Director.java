package co.com.webSchoolddd.registro.Director;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.entity.Funcion;
import co.com.webSchoolddd.registro.Director.event.DirectorCreado;
import co.com.webSchoolddd.registro.Director.event.EmailActualizado;
import co.com.webSchoolddd.registro.Director.event.FuncionAgregada;
import co.com.webSchoolddd.registro.Director.event.FuncionRemovida;
import co.com.webSchoolddd.registro.Director.value.*;
import co.com.webSchoolddd.value.Apellido;
import co.com.webSchoolddd.value.Email;
import co.com.webSchoolddd.value.Genero;
import co.com.webSchoolddd.value.Nombre;

import java.util.List;
import java.util.Objects;

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


    //comportamientos

    public void agregarFuncion(FuncionId funcionId, Prioridad prioridad, Caracteristica caracteristica) {
        appendChange(new FuncionAgregada(funcionId, prioridad, caracteristica));
    }

    public void removerFuncion(FuncionId funcionId) {
        Objects.requireNonNull(funcionId, "El id de funcion no puuder ser nulllo");
        Objects.requireNonNull(getFuncionById(funcionId));
        appendChange(new FuncionRemovida(funcionId)).apply();
    }


    public Funcion getFuncionById(FuncionId funcionId) {
        return funciones.stream()
                .filter(f -> f.identity().equals(funcionId))
                .findFirst().orElseThrow();
    }


    public void cambiarEmail(Email email) {
        appendChange(new EmailActualizado(email)).apply();
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
