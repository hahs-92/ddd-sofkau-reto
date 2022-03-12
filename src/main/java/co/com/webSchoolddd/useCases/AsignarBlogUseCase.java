package co.com.webSchoolddd.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.webSchoolddd.registro.Escuela.Escuela;
import co.com.webSchoolddd.registro.Escuela.command.AsignarBlog;

public class AsignarBlogUseCase extends UseCase<RequestCommand<AsignarBlog>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarBlog> input) {
        var command = input.getCommand();
        var escuela = Escuela.from(command.getEscuelaId(), retrieveEvents());

        escuela.asignarBlog(
                command.getBlogId(),
                command.getContenido(),
                command.getAuthor()
        );
        emit().onResponse(new ResponseEvents(escuela.getUncommittedChanges()));
    }
}
