package co.com.webSchoolddd.registro.Escuela.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Director.value.DirectorId;
import co.com.webSchoolddd.registro.Escuela.entity.Blog;
import co.com.webSchoolddd.registro.Escuela.entity.Examen;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;
import co.com.webSchoolddd.registro.Escuela.valor.Nombre;

public class CrearEscuela extends Command {
    private final EscuelaId escuelaId;
    private final Nombre nombre;
    private final DirectorId directorId;

    public CrearEscuela(EscuelaId escuelaId,
                        Nombre nombre,
                        DirectorId directorId
    ) {
        this.escuelaId = escuelaId;
        this.nombre = nombre;
        this.directorId = directorId;
    }

    public EscuelaId getEscuelaId() {
        return escuelaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public DirectorId getDirectorId() {
        return directorId;
    }

}
