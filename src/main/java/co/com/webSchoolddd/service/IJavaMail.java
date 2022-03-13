package co.com.webSchoolddd.service;

import co.com.webSchoolddd.registro.Director.value.DirectorId;

public interface IJavaMail {
    boolean enviarEmailADirector(DirectorId directorId, String mensaje);

}
