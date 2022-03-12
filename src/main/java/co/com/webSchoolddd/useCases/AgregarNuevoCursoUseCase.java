package co.com.webSchoolddd.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.webSchoolddd.registro.Director.command.AgregarNuevaFuncion;
import co.com.webSchoolddd.registro.Escuela.Escuela;
import co.com.webSchoolddd.registro.Escuela.command.AgregarNuevoCurso;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;

public class AgregarNuevoCursoUseCase extends UseCase<RequestCommand<AgregarNuevoCurso>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarNuevoCurso> input) {
        var command = input.getCommand();
        var escuela = Escuela.from(command.getEscuelaId(),retrieveEvents());

        escuela.agregarCurso(
                command.getCursoId(),
                command.getNombre(),
                command.getDescripcion(),
                command.getVideo(),
                command.getAuthor()
        );
        emit().onResponse(new ResponseEvents(escuela.getUncommittedChanges()));
    }

}
