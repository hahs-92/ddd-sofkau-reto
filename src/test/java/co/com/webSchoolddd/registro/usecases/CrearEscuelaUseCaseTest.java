package co.com.webSchoolddd.registro.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.webSchoolddd.registro.Director.valor.DirectorId;
import co.com.webSchoolddd.registro.Escuela.command.CrearEscuela;
import co.com.webSchoolddd.registro.Escuela.entity.Blog;
import co.com.webSchoolddd.registro.Escuela.entity.Examen;
import co.com.webSchoolddd.registro.Escuela.event.EscuelaCreada;
import co.com.webSchoolddd.registro.Escuela.valor.*;
import co.com.webSchoolddd.useCases.CrearEscuelaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CrearEscuelaUseCaseTest {

    @Test
    @DisplayName("Testing crearEscuela")
    void crearEscuela() {
        //arrange
        EscuelaId escuelaId =  new EscuelaId();
        DirectorId directorId = DirectorId.of("666XD");
        Nombre nombre = new Nombre("Desarrollo Web");
        BlogId blogId = new BlogId();
        Date fecha = new Date();
        Contenido contenido = new Contenido("Introduccion al desarrollo", fecha);
        Author author = new Author("miDudev","midudev@email.com");
        Blog blog = new Blog(
                blogId,
                contenido,
                author
        );
        ExamenId examenId = new ExamenId();
        author = new Author("Raul", "raul@mail.com");
        contenido = new Contenido("Que es Redux?", fecha);
        Examen examen = new Examen(
                examenId,
                author,
                contenido
        );

        //act
        var command = new CrearEscuela(
                escuelaId,
                nombre,
                directorId,
                examen,
                blog
        );
        var usecase = new CrearEscuelaUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EscuelaCreada)events.get(0);
        Assertions.assertEquals("webSchoolddd.registro.escuela.escuelaCreada", event.type);
        Assertions.assertEquals("666XD", event.getDirectorId().value());
        Assertions.assertEquals("Desarrollo Web", event.getNombre().value());
    }
}
