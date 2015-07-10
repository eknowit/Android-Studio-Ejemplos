package app.rest.com.logincliente;

import android.app.Dialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.*;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.rest.com.logincliente.api.ApiLogin;
import app.rest.com.logincliente.model.Mensaje;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static retrofit.RestAdapter.*;


public class MainActivity extends ActionBarActivity {

    Button btnIngresar;
    TextView txtusuario;
    TextView txtcontrasena;
    String API = "{url}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                txtusuario = (TextView)findViewById(R.id.usuario);
                txtcontrasena = (TextView)findViewById(R.id.contrasena);

                //Retrofit section start from here...
                RestAdapter restAdapter = new Builder().setEndpoint(API).build();

                Log.i("INFO",""+restAdapter);

                ApiLogin apiLogin = restAdapter.create(ApiLogin.class);

                apiLogin.login(txtusuario.getText().toString(),txtcontrasena.getText().toString(),
                        new Callback<Mensaje>() {
                            @Override
                            public void success(Mensaje mensaje, Response response) {
                                Dialog dialog = new Dialog(MainActivity.this);
                                dialog.setContentView(R.layout.dialogbrand_layout);
                                dialog.setTitle("Respuesta del Servidor....");
                                TextView textViewUser = (TextView) dialog.findViewById(R.id.textBrand);
                                textViewUser.setText(mensaje.getMensaje() );
                                dialog.show();
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Log.w("ERROR..",""+error);
                                Dialog dialog = new Dialog(MainActivity.this);
                                dialog.setContentView(R.layout.dialogbrand_layout);
                                dialog.setTitle("Respuesta del Servidor....");
                                TextView textViewUser = (TextView) dialog.findViewById(R.id.textBrand);
                                textViewUser.setText( "ERROR!");
                                dialog.show();
                            }

                        });

                /*Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialogbrand_layout);
                dialog.setTitle("Mensaje");
                TextView textViewUser = (TextView) dialog.findViewById(R.id.textBrand);
                textViewUser.setText("Test....");
                dialog.show();*/


            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // Se retira los items del menu porque no son necesarios para
        // este ejemplo

        /*int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        return false;
    }
}
