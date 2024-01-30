package ModeloBD_DTO;

import java.sql.Date;
import java.util.Objects;

public class empleado_DTO {
	
	//----------------------------------------------ATRIBUTOS----------------------------------------------------

	private int id_emple;
	private String nombre;
	private boolean tipo;
	private String dni;
	private boolean permisoChat;
	private int telefono;
	private long numSegSoc;
	private String fNacimiento;
	private double salario;
	private String Email;
	
	//-------------------------------------------CONSTRUCTORES----------------------------------------------------
	
	public empleado_DTO(int id_emple, String nombre, boolean tipo, String dni, boolean permisoChat, int telefono,
			long numSegSooc, String fNacimiento, String email, double sal) {
		super();
		this.id_emple = id_emple;
		this.nombre = nombre;
		this.tipo = tipo;
		this.dni = dni;
		this.permisoChat = permisoChat;
		this.telefono = telefono;
		this.numSegSoc = numSegSooc;
		this.fNacimiento = fNacimiento;
		this.Email = email;
		this.salario = sal;
	}
	
	//------------------------------------------GETTERS & SETTERS-------------------------------------------------

	public int getId_emple() {
		return id_emple;
	}

	public void setId_emple(int id_emple) {
		this.id_emple = id_emple;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isPermisoChat() {
		return permisoChat;
	}

	public void setPermisoChat(boolean permisoChat) {
		this.permisoChat = permisoChat;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public long getNumSegSooc() {
		return numSegSoc;
	}

	public void setNumSegSooc(long numSegSooc) {
		numSegSoc = numSegSooc;
	}

	public String getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}
	public double getSalario() {
		return salario;
	}

	public void setSalario(double sal) {
		this.salario = sal;
	}
	
	//------------------------------------------TO STRING-------------------------------------------------

	@Override
	public String toString() {
		return "empleado_DTO [id_emple=" + id_emple + ", nombre=" + nombre + ", tipo=" + tipo + ", dni=" + dni
				+ ", permisoChat=" + permisoChat + ", telefono=" + telefono + ", NumSegSoc=" + numSegSoc
				+ ", fNacimiento=" + fNacimiento + ", Email= " + Email + "]";
	}
	
	//-----------------------------------------EQUALS & HASH-------------------------------------------------------
	
	@Override
	public int hashCode() {
		return Objects.hash(id_emple);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		empleado_DTO other = (empleado_DTO) obj;
		return id_emple == other.id_emple;
	}
	

}
