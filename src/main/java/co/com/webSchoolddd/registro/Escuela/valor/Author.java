package co.com.webSchoolddd.registro.Escuela.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Author implements ValueObject<Author.Props> {
    private final String nombre;
    private final String email;
    //validaciones
    private Pattern pattern;
    private Matcher matcher;
    private String regx = "^[A-Za-z0-9+_.-]+@(.+)$";

    public Author(String nombre, String email) {
        this.nombre = Objects.requireNonNull(nombre);
        this.email = Objects.requireNonNull(email);
        this.pattern = Pattern.compile(regx);
        this.matcher = this.pattern.matcher(email);

        if(this.nombre.isBlank()) {
            throw  new IllegalArgumentException("El campo nombre es obligatorio");
        }

        if(this.email.isBlank()) {
            throw  new IllegalArgumentException("El campo email es obligatorio");
        }

        if(!this.matcher.matches()) {
            throw new IllegalArgumentException("El email ingresado no es valido");
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
            public String email() {
                return email;
            }
        };
    }

    public interface  Props {
        String nombre();
        String email();
    }
}
