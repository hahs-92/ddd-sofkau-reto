package co.com.webSchoolddd.useCases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.webSchoolddd.registro.Escuela.Escuela;
import co.com.webSchoolddd.registro.Escuela.event.CursoAgregado;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;
import co.com.webSchoolddd.service.IJavaMail;

import java.util.List;


public class NotificarADirectorNuevoCursoUseCase extends UseCase<TriggeredEvent<CursoAgregado>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<CursoAgregado> input) {
        var event = input.getDomainEvent();
        var service = getService(IJavaMail.class).orElseThrow();

        var events = repository().getEventsBy("escuela",event.aggregateRootId());
        var escuela = Escuela.from(EscuelaId.of(event.aggregateRootId()),events);

        var isOk = service.enviarEmailADirector(
                escuela.directorId(),
                String.format("Se ha agregado el nuevo curso %s", event.getCursoId())
        );


        if(!isOk) {
            throw new BusinessException(event.aggregateRootId(), "No se pudo enviar el email");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
