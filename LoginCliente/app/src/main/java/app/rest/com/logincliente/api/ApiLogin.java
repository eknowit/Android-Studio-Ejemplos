package app.rest.com.logincliente.api;

import app.rest.com.logincliente.model.Mensaje;
import retrofit.Callback;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Willy on 07/07/2015.
 */
public interface ApiLogin {

    @POST("/login/{usuario}/{clave}")
    public void login(@Path("usuario") String usuario, @Path("clave") String clave, Callback<Mensaje> response);

}
