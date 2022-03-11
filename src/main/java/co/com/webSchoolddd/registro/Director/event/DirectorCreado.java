package co.com.webSchoolddd.registro.Director.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.entity.Funcion;
import co.com.webSchoolddd.registro.Director.valor.Apellido;
import co.com.webSchoolddd.registro.Director.valor.Email;
import co.com.webSchoolddd.registro.Director.valor.Genero;
import co.com.webSchoolddd.registro.Director.valor.Nombre;



public class DirectorCreado extends DomainEvent {
    private final Nombre nombre;
    private final Apellido apellido;
    private final Email email;
    private Genero genero;


    public DirectorCreado(Nombre nombre, Apellido apellido, Email email, Genero genero) {
        super("webSchoolddd.registro.director.directorCreado");
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
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
