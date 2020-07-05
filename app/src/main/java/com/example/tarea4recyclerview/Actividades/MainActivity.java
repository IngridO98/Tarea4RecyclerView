package com.example.tarea4recyclerview.Actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tarea4recyclerview.Adaptadores.AdapterDatos;
import com.example.tarea4recyclerview.Modelos.Restaurantes;
import com.example.tarea4recyclerview.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private final String url="https://jsonbin.io/5efe7a287f16b71d48aa3b09";
   // private JsonArrayRequest request;
    private RequestQueue mirequest;
    private ArrayList<Restaurantes> listaRestaurantes;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaRestaurantes=new ArrayList<>();
        recyclerView=(RecyclerView) findViewById(R.id.recyViewRest);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mirequest=Volley.newRequestQueue(this);
       solicitudjson();

    }

    private void solicitudjson(){
        String url="https://api.jsonbin.io/b/5f01dcb87f16b71d48ab9d1c/1";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray myjsonArray=response.getJSONArray("Restaurantes");
                   // listaRestaurantes = new ArrayList<>();
                    for (int i=0;i<myjsonArray.length();i++){
                        JSONObject myjsonObject=myjsonArray.getJSONObject(i);
                        Restaurantes restaurantes=new Restaurantes();
                        restaurantes.setNombre(myjsonObject.getString("nombre"));
                        restaurantes.setDireccion(myjsonObject.getString("direccion"));
                        restaurantes.setTelefono(myjsonObject.getString("telefono"));
                        restaurantes.setHorarios(myjsonObject.getString("horarios"));
                        restaurantes.setCategoria(myjsonObject.getString("categoria"));
                        restaurantes.setFoto(myjsonObject.getString("foto"));
                        listaRestaurantes.add(restaurantes);
                        //String nombre=myjsonObject.getString("nombre");
                        //Toast.makeText(getApplicationContext(),"Nombre:"+nombre, Toast.LENGTH_LONG).show();
                    }
                    AdapterDatos adapter=new AdapterDatos(listaRestaurantes,MainActivity.this);
                    recyclerView.setAdapter(adapter);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"aQUI " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        mirequest.add(request);
    }
}