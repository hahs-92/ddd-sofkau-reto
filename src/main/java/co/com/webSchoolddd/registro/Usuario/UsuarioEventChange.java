package co.com.webSchoolddd.registro.Usuario;

import co.com.sofka.domain.generic.EventChange;
import co.com.webSchoolddd.registro.Usuario.event.UsuarioCreado;


public class UsuarioEventChange extends EventChange {
    public UsuarioEventChange(Usuario usuario) {

        apply((UsuarioCreado event) -> {
            usuario.escuelaId = event.getEscuelaId();
            usuario.cuentaId = event.getCuentaId();
            usuario.nombre = event.getNombre();
            usuario.apellido = event.getApellido();
            usuario.email = event.getEmail();
            usuario.genero = event.getGenero();
        });
    }
}
