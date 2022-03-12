package co.com.webSchoolddd.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.webSchoolddd.registro.Escuela.Escuela;
import co.com.webSchoolddd.registro.Escuela.command.AgregarNuevoReto;

public class AgregarNuevoRetoUseCase extends UseCase<RequestCommand<AgregarNuevoReto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarNuevoReto> input) {
        var command = input.getCommand();
        var escuela = Escuela.from(command.getEscuelaId(), retrieveEvents());

        escuela.agregarReto(
                command.getRetoId(),
                command.getAuthor(),
                command.getContenido(),
                command.getDescripcion()
        );
        emit().onResponse(new ResponseEvents(escuela.getUncommittedChanges()));
    }
}
