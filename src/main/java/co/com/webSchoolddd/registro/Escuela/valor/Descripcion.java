package co.com.webSchoolddd.registro.Escuela.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String descripcion;

    public Descripcion(String descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);

        if(this.descripcion.isBlank()) {
            throw new IllegalArgumentException("Esta propiedad es requerida");
        }

        if(this.descripcion.length() > 155) {
            throw new IllegalArgumentException("Esta propiedad no puede tener mas de 155 caracteres");
        }
    }

    public Descripcion actualizarDescripcion(String descripcion) {
        return new Descripcion(descripcion);
    }

    @Override
    public String value() {
        return descripcion;
    }
}
