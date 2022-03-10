package co.com.webSchoolddd.registro.Director.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Apellido  implements ValueObject<String> {
    private final String apellido;

    public Apellido(String apellido) {
        this.apellido = Objects.requireNonNull(apellido);

        if(this.apellido.isBlank()) {
            throw new IllegalArgumentException("El Apellido no puede ser vacio");
        }

        if(this.apellido.length() > 20) {
            throw new IllegalArgumentException("El Apellido no puede tener mas de 20 caracteres");
        }
    }

    public Apellido actualizarApellido(String apellido) {
        return new Apellido(apellido);
    }

    @Override
    public String value() {
        return apellido;
    }
}
