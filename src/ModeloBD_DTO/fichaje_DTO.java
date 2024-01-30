package ModeloBD_DTO;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class fichaje_DTO {
	
	//----------------------------------------------ATRIBUTOS----------------------------------------------------

	private Date fEntrada, fSalida;
	private Time HoraEntrada, HoraSalida;
	private int id_emple, codFichaje;
	
	//-------------------------------------------CONSTRUCTORES----------------------------------------------------
	
	public fichaje_DTO(Date fEntrada, Date fSalida, Time horaEntrada, Time horaSalida, int id_emple , int codFi) {
		super();
		this.fEntrada = fEntrada;
		this.fSalida = fSalida;
		this.HoraEntrada = horaEntrada;
		this.HoraSalida = horaSalida;
		this.id_emple = id_emple;
		this.codFichaje = codFi;
	}
	
	//------------------------------------------GETTERS & SETTERS-------------------------------------------------

	public Date getfEntrada() {
		return fEntrada;
	}

	public void setfEntrada(Date fEntrada) {
		this.fEntrada = fEntrada;
	}

	public Date getfSalida() {
		return fSalida;
	}

	public void setfSalida(Date fSalida) {
		this.fSalida = fSalida;
	}

	public Time getHoraEntrada() {
		return HoraEntrada;
	}

	public void setHoraEntrada(Time horaEntrada) {
		HoraEntrada = horaEntrada;
	}

	public Time getHoraSalida() {
		return HoraSalida;
	}

	public void setHoraSalida(Time horaSalida) {
		HoraSalida = horaSalida;
	}

	public int getId_emple() {
		return id_emple;
	}

	public void setId_emple(int id_emple) {
		this.id_emple = id_emple;
	}
	
	//------------------------------------------TO STRING-------------------------------------------------

	@Override
	public String toString() {
		return "fichaje_DTO [fEntrada=" + fEntrada + ", fSalida=" + fSalida + ", HoraEntrada=" + HoraEntrada
				+ ", HoraSalida=" + HoraSalida + ", id_emple=" + id_emple + "]";
	}
	
	//-----------------------------------------EQUALS & HASH-------------------------------------------------------

	@Override
	public int hashCode() {
		return Objects.hash(HoraEntrada, HoraSalida, fEntrada, fSalida, id_emple);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		fichaje_DTO other = (fichaje_DTO) obj;
		return Objects.equals(HoraEntrada, other.HoraEntrada) && Objects.equals(HoraSalida, other.HoraSalida)
				&& Objects.equals(fEntrada, other.fEntrada) && Objects.equals(fSalida, other.fSalida)
				&& id_emple == other.id_emple;
	}
	
	
	
	

}
