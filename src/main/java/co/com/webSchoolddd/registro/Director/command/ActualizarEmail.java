package co.com.webSchoolddd.registro.Director.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Director.value.DirectorId;
import co.com.webSchoolddd.value.Email;

public class ActualizarEmail extends Command {
    private final DirectorId directorId;
    private final Email email;

    public ActualizarEmail(DirectorId directorId,Email email) {
        this.directorId = directorId;
        this.email = email;
    }

    public DirectorId getDirectorId() {
        return directorId;
    }

    public Email getEmail() {
        return email;
    }
}
