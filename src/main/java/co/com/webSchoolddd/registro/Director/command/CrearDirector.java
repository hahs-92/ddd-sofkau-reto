package co.com.webSchoolddd.registro.Director.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Director.valor.*;

public class CrearDirector extends Command {
    private final DirectorId directorId;
    private final Nombre nombre;
    private final Apellido apellido;
    private final Email email;
    private final Genero genero;

    public CrearDirector(
            DirectorId directorId,
            Nombre nombre,
            Apellido apellido,
            Email email,
            Genero genero
    ) {
        this.directorId = directorId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
    }

    public DirectorId getDirectorId() {
        return directorId;
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
