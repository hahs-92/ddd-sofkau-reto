package co.com.webSchoolddd.registro.Escuela.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class Contenido implements ValueObject<Contenido.Props> {
    private final String publicacion;
    private final Date fecha;
    private final Author author;

    public Contenido(String publicacion, Date fecha, Author author) {
        this.publicacion = Objects.requireNonNull(publicacion);
        this.fecha = Objects.requireNonNull(fecha);
        this.author = Objects.requireNonNull(author);

        if(this.publicacion.isBlank()) {
            throw  new IllegalArgumentException("El campo publicacion es obligatorio");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String publicacion() {
                return publicacion;
            }

            @Override
            public Date fecha() {
                return fecha;
            }

            @Override
            public Author author() {
                return author;
            }
        };
    }


    public interface Props {
        String publicacion();
        Date fecha();
        Author author();
    }
}
