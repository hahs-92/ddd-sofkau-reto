package co.com.webSchoolddd.registro.Director.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.value.Email;

public class EmailActualizado extends DomainEvent {
    private final Email email;

    public EmailActualizado(Email email) {
        super("webSchoolddd.registro.director.emailActualizado");
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }
}
