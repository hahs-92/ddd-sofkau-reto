package co.com.webSchoolddd.registro.Director.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.value.Email;

public class ActualizarEmail extends Command {
    private final Email email;

    public ActualizarEmail(Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }
}
