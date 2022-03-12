package co.com.webSchoolddd.registro.Usuario.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.value.Genero;

public class GeneroCambiado extends DomainEvent {
    private Genero genero;

    public GeneroCambiado(Genero genero) {
        super("webSchoolddd.registro.usuario.generoCambiado");
        this.genero = genero;
    }

    public Genero getGenero() {
        return genero;
    }
}
