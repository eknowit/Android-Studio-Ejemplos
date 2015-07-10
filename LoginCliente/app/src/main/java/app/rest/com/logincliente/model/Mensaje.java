package app.rest.com.logincliente.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Willy on 07/07/2015.
 */
public class Mensaje {

    @Expose
    public String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
