package co.com.webSchoolddd.registro.Escuela.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.value.DirectorId;
import co.com.webSchoolddd.registro.Escuela.valor.Nombre;


public class EscuelaCreada extends DomainEvent {
    private final Nombre nombre;
    private final DirectorId directorId;


    public EscuelaCreada(Nombre nombre, DirectorId directorId) {
        super("webSchoolddd.registro.escuela.escuelaCreada");
        this.nombre = nombre;
        this.directorId = directorId;

    }

    public Nombre getNombre() {
        return nombre;
    }

    public DirectorId getDirectorId() {
        return directorId;
    }


}
