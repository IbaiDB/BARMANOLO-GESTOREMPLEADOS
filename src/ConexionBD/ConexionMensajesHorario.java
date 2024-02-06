package ConexionBD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ConexionMensajesHorario {
	
		public static String leerAPI(String urlAPI) {
	        StringBuilder content = new StringBuilder();

			try {
			   // Crear un objeto URL con la dirección de la API
	        URL url = new URL("https://barmanolo.onrender.com/api/leer/mensajes");

	        // Abrir una conexión a la URL
	        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

	        // Inicializar una cadena para almacenar el contenido de la respuesta
	        String line;

	        // Leer cada línea de la respuesta y agregarla al StringBuilder
	        while ((line = reader.readLine()) != null) {
	            content.append(line).append("\n");
	        }

	        // Cerrar el lector
	        reader.close();
	        }catch (Exception e) {
	        	e.printStackTrace();
			}

	        // Convertir el contenido a un String
	        return content.toString();

		}
     
}
