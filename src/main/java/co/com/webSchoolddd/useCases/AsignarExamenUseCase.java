package co.com.webSchoolddd.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.webSchoolddd.registro.Escuela.Escuela;
import co.com.webSchoolddd.registro.Escuela.command.AsignarExamen;

public class AsignarExamenUseCase extends UseCase<RequestCommand<AsignarExamen>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AsignarExamen> input) {

        var command = input.getCommand();
        var escuela = Escuela.from(command.getEscuelaId(), retrieveEvents());

        escuela.asignarExamen(
                command.getExamenId(),
                command.getAuthor(),
                command.getContenido()
        );
        emit().onResponse(new ResponseEvents(escuela.getUncommittedChanges()));
    }
}
