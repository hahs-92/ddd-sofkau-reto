package co.com.webSchoolddd.registro.Usuario.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.value.Genero;

public class CambiarGenero extends Command {
    private final Genero genero;

    public CambiarGenero(Genero genero) {
        this.genero = genero;
    }

    public Genero getGenero() {
        return genero;
    }
}
