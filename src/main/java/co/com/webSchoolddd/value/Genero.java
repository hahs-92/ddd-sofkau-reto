package co.com.webSchoolddd.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Genero implements ValueObject<Genero.Genre> {
    private final Genre genero;

    public Genero(Genre genero) {
        this.genero = Objects.requireNonNull(genero);
    }

    @Override
    public Genre value() {
        return genero;
    }

    public Genero actualizarGenero(Genre genero) {
        return new Genero(genero);
    }

    public enum Genre  {
          M, F, N
    }

}


