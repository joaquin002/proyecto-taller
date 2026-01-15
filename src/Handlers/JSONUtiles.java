package Handlers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

public class JSONUtiles {
    /// Aca serializamos y deserializamos nuestros datos
    /// Metodo que convierte el texto del archivo en un JSONObject
    public static JSONObject obtenerJSONObject(String contenidoJSON) throws JSONException {
        if (contenidoJSON == null || contenidoJSON.isEmpty()) {
            return new JSONObject(); //Se devuelve un new JSONObject para evitar manejar una NullPointerException en el llamado de Clases.Veterinaria
        }                            //Si el archivo está vacio, empieza con un conjuntos de datos vacío y no con un error
        JSONTokener tokener = new JSONTokener(contenidoJSON);
        return new JSONObject(tokener);
    }

    /// Metodo que nos sirve para agarrar nuestro JSONObject de veterinaria y pasarlo a un string para un posterior guardado en el archivo
    public static String serializar(JSONObject objeto) {
        return objeto.toString();
    }

}
