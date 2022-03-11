package co.com.webSchoolddd.registro.Escuela.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String nombre;

    public Nombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);

        if(this.nombre.isBlank()) {
            throw new IllegalArgumentException("Esta propiedad es requerida");
        }

        if(this.nombre.length() > 25) {
            throw new IllegalArgumentException("El nombre no puede tener mas de 25 caracteres");
        }
    }

    //comportamientos
    public Nombre actualizarNombre(String nombre) {
        return new Nombre(nombre);
    }

    @Override
    public String value() {
        return nombre;
    }
}
