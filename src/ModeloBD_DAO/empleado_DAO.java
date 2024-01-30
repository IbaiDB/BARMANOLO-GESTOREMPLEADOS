package ModeloBD_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConexionBD.ConexionSGL;
import ModeloBD_DTO.empleado_DTO;


public class empleado_DAO implements Patron_DAO<empleado_DTO> {
	
	//----------------------------------------------------------SENTENCIAS DEFINIDAS-------------------------------------------------------------------
	
	private static final String SQL_INSERT = "INSERT INTO empleados (id_emple, nombre, tipo, dni, permisoChat, telefono, NumSegSoc, fNacimiento, Email, salario) VALUES (? , ? , ? , ? , ? , ? , ? , ? , ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM empleados WHERE id_emple = ?";
	private static final String SQL_UPDATE = "UPDATE empleados SET nombre = ?, tipo = ?, dni = ?, permisoChat = ?, telefono = ?, NumSegSoc = ?, fNacimiento = ?, Email = ?, salario = ? WHERE id_emple = ?";
	private static final String SQL_FIND = "SELECT * FROM empleados WHERE id_emple = ?";
	private static final String SQL_FINDALL = "SELECT * FROM empleados";
				
	//-------------------------------------------------------------REALIZAR CONEXIÓN-------------------------------------------------------------------
			
	private ConexionSGL con = ConexionSGL.getInstancia();				
				
	//-------------------------------------------------INSERTAR DETALLE EMPLEADO-------------------------------------------------------------------------

	@Override
	public boolean insertar(empleado_DTO t) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		
		try {
			
			ps = con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getId_emple());
			ps.setString(2, t.getNombre());
			ps.setBoolean(3, t.isTipo());
			ps.setString(4, t.getDni());
			ps.setBoolean(5, t.isPermisoChat());
			ps.setInt(6, t.getTelefono());
			ps.setLong(7, t.getNumSegSooc());
			ps.setString(8, t.getfNacimiento());
			ps.setString(9, t.getEmail());
			ps.setDouble(10, t.getSalario());

			
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
	
	//----------------------------------------------------------ELIMINAR POR CÓDIGO--------------------------------------------------------------------

	@Override
	public boolean borrar(Object pk) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		
		try {
			ps = con.getCon().prepareStatement(SQL_DELETE);
			ps.setInt(1, (int)pk);
			
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
	
	//-------------------------------------------------------------ACTUALIZAR EMPLEADO-------------------------------------------------------------


	@Override
	public boolean actualizar(empleado_DTO t) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		
		try {
			ps = con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(10, t.getId_emple());
			ps.setString(1, t.getNombre());
			ps.setBoolean(2, t.isTipo());
			ps.setString(3, t.getDni());
			ps.setBoolean(4, t.isPermisoChat());
			ps.setInt(5, t.getTelefono());
			ps.setLong(6, t.getNumSegSooc());
			ps.setString(7, t.getfNacimiento());
			ps.setString(8, t.getEmail());
			ps.setDouble(9, t.getSalario());
			
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
	
	//----------------------------------------BÚSQUEDA POR CÓDIGO-------------------------------------------------------

	@Override
	public empleado_DTO buscar(Object pk) {
		// TODO Auto-generated method stub
		empleado_DTO e1 = null;
		try {
			PreparedStatement ps = con.getCon().prepareStatement(SQL_FIND);
			ps.setInt(1, (int)pk);
			
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()==true) {
				e1 = new empleado_DTO(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getBoolean(5), rs.getInt(6), rs.getLong(7), rs.getString(8), rs.getString(9), rs.getDouble(10));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return e1;
	}
	
	//-----------------------------------------------------GENERAR ARRAYLIST DE SU DTO-----------------------------------------------------------------

	@Override
	public ArrayList<empleado_DTO> listarTodos() {
		// TODO Auto-generated method stub
		ArrayList<empleado_DTO> listaEmp = new ArrayList<empleado_DTO>();
		empleado_DTO e1 = null;
		try {
			PreparedStatement ps = con.getCon().prepareStatement(SQL_FINDALL);
			
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()==true) {
				e1 = new empleado_DTO(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getBoolean(5), rs.getInt(6), rs.getLong(7), rs.getString(8), rs.getString(9), rs.getDouble(10));
				listaEmp.add(e1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaEmp;
	}
	
	

}
