package co.com.webSchoolddd.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.webSchoolddd.registro.Escuela.Escuela;
import co.com.webSchoolddd.registro.Escuela.command.RemoverCurso;

public class RemoverCursoUseCase extends UseCase<RequestCommand<RemoverCurso>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<RemoverCurso> input) {
        var command = input.getCommand();
        var escuela = Escuela.from(command.getEscuelaId(), retrieveEvents());

        escuela.removerCurso(
                command.getCursoId()
        );

        emit().onResponse(new ResponseEvents(escuela.getUncommittedChanges()));
    }
}
