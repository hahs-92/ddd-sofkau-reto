package co.com.webSchoolddd.registro.Escuela.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Video implements ValueObject<Video.Props> {

    private final String nombre;
    private final double duracion;

    public Video(String nombre, double duracion) {
        this.nombre = Objects.requireNonNull(nombre);
        this.duracion = Objects.requireNonNull(duracion);

        if(this.nombre.isBlank()) {
            throw  new IllegalArgumentException("El campo nombre es obligatorio");
        }

        if(this.duracion > 20) {
            throw new IllegalArgumentException("La duracion no puede ser mayor de 20 minutos");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public double duracion() {
                return duracion;
            }
        };
    }

    //comportamientos

    public Video actualizarVideo(String nombre, double duracion) {
        return new Video(nombre, duracion);
    }

    public interface Props {
        String nombre();
        double duracion();
    }


}
