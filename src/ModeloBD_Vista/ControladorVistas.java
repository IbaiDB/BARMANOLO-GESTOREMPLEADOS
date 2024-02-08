package ModeloBD_Vista;

public class ControladorVistas {

	public static void abrirGestorEmpleados() {
		
		GestorEmpleados g1 = new GestorEmpleados();
		g1.setVisible(true);
		
	}
	
	public static void abrirBarManolo() {
		BARMANOLO frame = new BARMANOLO();
		frame.setVisible(true);
	}
	
	public static void 	abrirFichajeEmpleado(int pk) {
		FichajeEmple f1 = new FichajeEmple(pk);
		f1.setVisible(true);
	}		
	
	public static void abrirUsoChat(int pk) {
		UsoChat u1 = new UsoChat(pk);
		u1.setVisible(true);

	}
	
	public static void 	abrirConsultaEmpleado(int pk) {
		
		ConsultaEmple c1 = new ConsultaEmple(pk);
		c1.setVisible(true);
		
	}
	
	public static void abrirTiempo() {
		Tiempo c1 = new Tiempo();
		c1.setVisible(true);
		
	}

	


}
