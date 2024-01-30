package ModeloBD_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConexionBD.ConexionSGL;
import ModeloBD_DTO.empleado_DTO;
import ModeloBD_DTO.fichaje_DTO;

public class fichaje_DAO implements Patron_DAO<fichaje_DTO> {
	
	//----------------------------------------------------------SENTENCIAS DEFINIDAS-------------------------------------------------------------------
	
	private static final String SQL_INSERT = "INSERT INTO fichaje (fEntrada, fSalida, HoraEntrada, HoraSalida, id_emple) VALUES (? , ? , ? , ? , ? )";
	private static final String SQL_DELETE = "DELETE FROM fichaje WHERE codFichaje = ?";
	private static final String SQL_UPDATE = "UPDATE fichaje SET fEntrada = ?, fSalida = ?, HoraEntrada = ?, HoraSalida = ?, id_emple = ? WHERE codFichaje = ?";
	private static final String SQL_FIND = "SELECT * FROM fichaje WHERE codFichaje = ?";
	private static final String SQL_POREMPLE = "SELECT * FROM fichaje WHERE id_emple = ?";
	private static final String SQL_FINDALL = "SELECT * FROM fichaje";
				
	//-------------------------------------------------------------REALIZAR CONEXIÓN-------------------------------------------------------------------
			
	private ConexionSGL con = ConexionSGL.getInstancia();				
				
	//-------------------------------------------------INSERTAR DETALLE EMPLEADO-------------------------------------------------------------------------

	@Override
	public boolean insertar(fichaje_DTO t) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		
		try {
			
			ps = con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(5, t.getId_emple());
			ps.setDate(1, t.getfEntrada());
			ps.setDate(2, t.getfSalida());
			ps.setTime(3, t.getHoraEntrada());
			ps.setTime(4, t.getHoraSalida());


			
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
	
	@Override
	public boolean actualizar(fichaje_DTO t) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		
		try {
			ps = con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(5, t.getId_emple());
			ps.setDate(1, t.getfEntrada());
			ps.setDate(2, t.getfSalida());
			ps.setTime(3, t.getHoraEntrada());
			ps.setTime(4, t.getHoraSalida());
			
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
	public fichaje_DTO buscar(Object pk) {
		// TODO Auto-generated method stub
		fichaje_DTO f1 = null;
		try {
			PreparedStatement ps = con.getCon().prepareStatement(SQL_FIND);
			ps.setInt(1, (int)pk);
			
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()==true) {
				f1 = new fichaje_DTO(rs.getDate(1), rs.getDate(2), rs.getTime(3), rs.getTime(4), rs.getInt(5), rs.getInt(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return f1;
	}

	@Override
	public ArrayList<fichaje_DTO> listarTodos() {
		// TODO Auto-generated method stub
		ArrayList<fichaje_DTO> listaFich = new ArrayList<fichaje_DTO>();
		fichaje_DTO f1 = null;
		try {
			PreparedStatement ps = con.getCon().prepareStatement(SQL_FINDALL);
			
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()==true) {
				f1 = new fichaje_DTO(rs.getDate(1), rs.getDate(2), rs.getTime(3), rs.getTime(4), rs.getInt(5), rs.getInt(6));
				listaFich.add(f1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaFich;
	}
	
	public ArrayList<fichaje_DTO> listarPorEmple(int pk) {
		// TODO Auto-generated method stub
		ArrayList<fichaje_DTO> listaFich = new ArrayList<fichaje_DTO>();
		fichaje_DTO f1 = null;
		try {
			PreparedStatement ps = con.getCon().prepareStatement(SQL_POREMPLE);
			ps.setInt(1, (int)pk);
			
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()==true) {
				f1 = new fichaje_DTO(rs.getDate(1), rs.getDate(2), rs.getTime(3), rs.getTime(4), rs.getInt(5), rs.getInt(6));
				listaFich.add(f1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaFich;
	}

}
