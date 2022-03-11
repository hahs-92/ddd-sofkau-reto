package co.com.webSchoolddd.registro.Escuela.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class Contenido implements ValueObject<Contenido.Props> {
    private final String desarrollo;
    private final Date fecha;


    public Contenido(String desarrollo, Date fecha) {
        this.desarrollo = Objects.requireNonNull(desarrollo);
        this.fecha = Objects.requireNonNull(fecha);

        if(this.desarrollo.isBlank()) {
            throw  new IllegalArgumentException("El campo desarrollo es obligatorio");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String desarrollo() {
                return desarrollo;
            }

            @Override
            public Date fecha() {
                return fecha;
            }

        };
    }


    public interface Props {
        String desarrollo();
        Date fecha();
    }
}
