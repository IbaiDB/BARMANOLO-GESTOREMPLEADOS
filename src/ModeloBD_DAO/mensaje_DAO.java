package ModeloBD_DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ConexionBD.ConexionSGL;
import ModeloBD_DTO.fichaje_DTO;
import ModeloBD_DTO.mensaje_DTO;

public class mensaje_DAO implements Patron_DAO<mensaje_DTO> {
	
	private static final String SQL_INSERT = "INSERT INTO mensajes (cod_mensaje, texto, fechahora, cod_empleado) VALUES (? , ? , ? , ? )";
	private static final String SQL_DELETE = "DELETE FROM fichaje WHERE cod_mensaje = ?";
	private static final String SQL_FINDALL = "SELECT * FROM mensajes";
	private static final String SQL_DELETETABLE = "DELETE FROM mensajes";


	private ConexionSGL con = ConexionSGL.getInstancia();				



	@Override
	public boolean insertar(mensaje_DTO t) {
	
		PreparedStatement ps = null;
		
		try {
			
			ps = con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.idMensaje);
			ps.setString(2, t.texto);
			ps.setString(3, t.fechahora);
			ps.setInt(4, t.idEmpleado);

			
			if(ps.executeUpdate()>0) return true;
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null) ps.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean borrar(Object pk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(mensaje_DTO t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public mensaje_DTO buscar(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<mensaje_DTO> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean vaciarTabla() {
	    PreparedStatement ps = null;
	    try {
	        ps = con.getCon().prepareStatement(SQL_DELETETABLE);
	        int rowsAffected = ps.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}

}
