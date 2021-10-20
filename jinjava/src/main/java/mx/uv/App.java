package mx.uv;

import static spark.Spark.*;

import spark.ModelAndView;
import spark.template.jinjava.JinjavaEngine;
//import spark.template.pebble.PebbleTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.gson.*;
import com.hubspot.jinjava.Jinjava;

import mx.uv.datos.Automovil;

/**
 * Hello world!
 *
 */
public class App {
    private static Gson gson = new Gson();
    private static Map<String, Automovil> automoviles = new HashMap<>();
    private static List<Automovil> listaAutomoviles = new ArrayList<>();
    public static void main( String[] args )
    {
        
        staticFiles.location("/");
        
        post("/registrar", (req, res) -> {
            String json = req.body();
            Automovil a = gson.fromJson(json, Automovil.class);
            String id = UUID.randomUUID().toString();
            a.setId(id);
           
            listaAutomoviles.add(a);

            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", "creado");
            respuesta.addProperty("id", id);
            return respuesta;
        });

        // do this
        get("/jinjava", (request, response) -> {
			Map<String, Object> modelo = new HashMap<>();
            for (Automovil automovil : listaAutomoviles) {
                automoviles.put(automovil.getId(), automovil);
                modelo.put(automovil.getId(), automoviles.values());
                automoviles.clear();
            }
            return new JinjavaEngine().render(
                new ModelAndView(modelo, "templates/jinjava.j2")
            );
		});
    }
}
