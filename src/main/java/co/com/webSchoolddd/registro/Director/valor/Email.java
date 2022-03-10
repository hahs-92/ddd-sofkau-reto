package co.com.webSchoolddd.registro.Director.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email implements ValueObject<String> {
    private final String email;
    //validaciones
    private Pattern pattern;
    private Matcher matcher;
    private String regx = "^[A-Za-z0-9+_.-]+@(.+)$";

    public Email(String email) {
        this.email = Objects.requireNonNull(email);
        this.pattern = Pattern.compile(regx);
        this.matcher = this.pattern.matcher(email);

        if(email.isBlank()) {
            throw new IllegalArgumentException("Este campo es obligatorio");
        }

        if(!this.matcher.matches()) {
            throw new IllegalArgumentException("El email ingresado no es valido");
        }
    }

    public Email actualizarEmail(String email) {
        return new Email(email);
    }

    @Override
    public String value() {
        return email;
    }
}
