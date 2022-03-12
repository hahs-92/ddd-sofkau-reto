package co.com.webSchoolddd.registro.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.value.DirectorId;
import co.com.webSchoolddd.registro.Escuela.command.RemoverCurso;
import co.com.webSchoolddd.registro.Escuela.event.*;
import co.com.webSchoolddd.registro.Escuela.valor.*;
import co.com.webSchoolddd.useCases.RemoverCursoUseCase;
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
public class RemoverCursoUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Testing RemoverCurso")
    void removerCurso() {
        //arrange
        EscuelaId escuelaId = EscuelaId.of("xxx");
        CursoId cursoId = CursoId.of("xxz");

        //act
        var command = new RemoverCurso(escuelaId, cursoId);
        var usecase = new RemoverCursoUseCase();

        Mockito.when(repository.getEventsBy("xxx")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(escuelaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CursoRemovido)events.get(0);
        Assertions.assertEquals("webSchoolddd.registro.escuela.cursoRemovido", event.type);
        Assertions.assertEquals("xxz", event.getCursoId().value());
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
                ),
                new CursoAgregado(
                       CursoId.of("xxz"),
                        new Nombre("Curso de React"),
                        new Descripcion("En este curso aprenderas React desde Zero"),
                        new Video("How learn React", 20),
                        new Author("Miguel", "mig@mail.com")
                )
        );
    }
}
