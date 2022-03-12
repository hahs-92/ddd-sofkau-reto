package co.com.webSchoolddd.registro.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.value.DirectorId;
import co.com.webSchoolddd.registro.Escuela.command.AgregarNuevoCurso;
import co.com.webSchoolddd.registro.Escuela.event.BlogAsignado;
import co.com.webSchoolddd.registro.Escuela.event.CursoAgregado;
import co.com.webSchoolddd.registro.Escuela.event.EscuelaCreada;
import co.com.webSchoolddd.registro.Escuela.event.ExamenAsignado;
import co.com.webSchoolddd.registro.Escuela.valor.*;
import co.com.webSchoolddd.useCases.AgregarNuevoCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AgregarNuevoCursoUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Testing AgregarCurso")
    void agregarCurso() {
        //arrange
        EscuelaId escuelaId = EscuelaId.of("xxx");

        CursoId cursoId = CursoId.of("xxz");
        Nombre nombre = new Nombre("Curso de React");
        Descripcion descripcion = new Descripcion("Aprenderas todo los fundamentos de React");
        Video video = new Video("Learn React", 20);
        Author author = new Author("Miguel", "miguel@mial.com");

        //act
        var command = new AgregarNuevoCurso(
                escuelaId,
                cursoId,
                nombre,
                descripcion,
                video,
                author
        );
        var usecase = new AgregarNuevoCursoUseCase();
        Mockito.when(repository.getEventsBy("xxx")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(escuelaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CursoAgregado)events.get(0);
        Assertions.assertEquals("webSchoolddd.registro.escuela.cursoAgregado",event.type);
        Assertions.assertEquals("xxz", event.getCursoId().value());
        Assertions.assertEquals("Curso de React", event.getNombre().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new EscuelaCreada(
                        new Nombre("Desarrollo Web"),
                        DirectorId.of("zzz")
                        ),
                new BlogAsignado(
                        BlogId.of("aaa"),
                        new Contenido("Como hacer un useHook", new Date()),
                        new Author("Maria", "maria@mail.com")
                ),
                new ExamenAsignado(
                        ExamenId.of("bbb"),
                        new Author("Lucas", "lucas@mail.com"),
                        new Contenido("Ques es React?", new Date())
                )
        );
    }
}
