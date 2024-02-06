package ModeloBD_DTO;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class mensaje_DTO {
	
        int idMensaje;
        int idEmpleado;
        String texto;
        String fechahora;
        
        
        public String toString() {
        	return ("idMensaje:" + idMensaje + "idEmpleado:" + idEmpleado + "texto" + texto + "fechahora: " + fechahora);
        }
        
        
        public static List<mensaje_DTO> deJsonAMensajes(String jsonString) {
    	    Gson gson = new Gson();

    	    // Define el tipo de la lista
    	    java.lang.reflect.Type listType = new TypeToken<List<mensaje_DTO>>() {}.getType();

    	    // Convierte la cadena JSON en una lista de objetos Mensaje
    	    List<mensaje_DTO> mensajes = gson.fromJson(jsonString, listType);
    	    
    	    return mensajes;
    	}
    	
    
    }

