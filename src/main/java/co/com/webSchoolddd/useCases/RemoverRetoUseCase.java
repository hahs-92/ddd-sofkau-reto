package co.com.webSchoolddd.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.webSchoolddd.registro.Escuela.Escuela;
import co.com.webSchoolddd.registro.Escuela.command.RemoverReto;

public class RemoverRetoUseCase extends UseCase<RequestCommand<RemoverReto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RemoverReto> input) {
        var command = input.getCommand();
        var escuela = Escuela.from(command.getEscuelaId(), retrieveEvents());

        escuela.removerReto(command.getRetoId());
        emit().onResponse(new ResponseEvents(escuela.getUncommittedChanges()));
    }
}
