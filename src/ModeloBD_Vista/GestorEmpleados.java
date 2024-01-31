package ModeloBD_Vista;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ModeloBD_DAO.empleado_DAO;
import ModeloBD_DTO.empleado_DTO;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Insets;
import javax.swing.BoxLayout;


public class GestorEmpleados extends JDialog {
	
	//------------------------------------------------VARIABLES GLOBALES  --------------------------------------
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablaEmpleados;
	
	private empleado_DAO empleDAO = new empleado_DAO();
	private ArrayList<empleado_DTO> listaEmp;
	
	private DefaultTableModel modelo;
	
	//-----------------------------------------------------------------------------------------------------------
	
	//--------------------------------------------------XML AUTOMATICO ------------------------------------------

	public GestorEmpleados() {
		
		setBounds(100, 100, 900, 495);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.desktop);
		contentPanel.setForeground(new Color(117, 180, 249));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTOR DE EMPLEADOS");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblNewLabel.setBounds(252, 12, 638, 50);
		contentPanel.add(lblNewLabel);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(252, 74, 638, 391);
		contentPanel.add(scrollPane);

		
		tablaEmpleados = new JTable();
		tablaEmpleados.setBackground(SystemColor.text);
		
	//-----------------------------------------------------------------------------------------------------------

	//-----------------------------------------------MODELO TABLA ----------------------------------------------
		
		modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id_Empleado", "DNI", "Nombre", "Email", "Tel\u00E9fono", "Fecha de Nacimiento"
				}
			);

		tablaEmpleados.setModel(modelo);
		tablaEmpleados.getColumnModel().getColumn(5).setPreferredWidth(110);
		scrollPane.setViewportView(tablaEmpleados);
		
	//-----------------------------------------------------------------------------------------------------------

	//--------------------------------------------------LISTENERS -----------------------------------------------
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 74, 253, 391);
		contentPanel.add(panelMenu);
		panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.X_AXIS));

		JMenuBar mbOpciones = new JMenuBar();
		panelMenu.add(mbOpciones);
		mbOpciones.setForeground(SystemColor.text);
		mbOpciones.setBackground(SystemColor.desktop);
		mbOpciones.setFont(new Font("Montserrat", Font.BOLD, 12));
		mbOpciones.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mbOpciones.setLayout(new BoxLayout(mbOpciones, BoxLayout.Y_AXIS)); // Cambiado a BoxLayout.Y_AXIS

		JMenu mnAlta = new JMenu("ALTA EMPLEADO");
		mbOpciones.add(mnAlta);

		mnAlta.setForeground(SystemColor.text);
		
		
		mnAlta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAlta.setHorizontalAlignment(SwingConstants.CENTER);
		mbOpciones.add(mnAlta);
		
		JMenu mnModificar = new JMenu("MODIFICAR EMPLEADO");
		mnModificar.setForeground(SystemColor.text);
		mnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnModificar.setHorizontalAlignment(SwingConstants.CENTER);
		mbOpciones.add(mnModificar);
		
		JMenu mnBaja = new JMenu("ELIMINAR EMPLEADO");
		mnBaja.setForeground(SystemColor.text);
		mnBaja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JMenu mnConsulta = new JMenu("REVISAR INFORMACIÓN DETALLADA");
		mnConsulta.setForeground(SystemColor.text);
		mnAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AltaEmple a1 = new AltaEmple();
				a1.setVisible(true);
				dispose();
				
			}
		});
		mnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int filaselec = tablaEmpleados.getSelectedRow();
				
				if(filaselec != -1) {
					
					Object codigoCliente = tablaEmpleados.getValueAt(filaselec, 0);
					
					String pkStr = String.valueOf(codigoCliente);					
					
					int pk = Integer.parseInt(pkStr);
					
					empleado_DTO emp = empleDAO.buscar(pk);
					
					if(emp != null) {
						
						ModificarEmple m1 = new ModificarEmple(emp.getId_emple());
						m1.setVisible(true);
						dispose();
						
					}else {
						
						JOptionPane.showMessageDialog(null, "Empleado inexistente", "ERROR!", JOptionPane.ERROR_MESSAGE);

					}
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado primero", "Atención!", JOptionPane.WARNING_MESSAGE);
					
				}
				
				listaEmp = empleDAO.listarTodos();
				
				mostrarEmpleados();
				
			}
		});
		mnBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int filaselec = tablaEmpleados.getSelectedRow();
				
				if(filaselec != -1) {
					
					Object codigoCliente = tablaEmpleados.getValueAt(filaselec, 0);
					
					String pkStr = String.valueOf(codigoCliente);					
					
					int pk = Integer.parseInt(pkStr);
					
					int confirmacion;
					
					empleado_DTO emp = empleDAO.buscar(pk);
					
					if(emp != null) {
						
						confirmacion = JOptionPane.showConfirmDialog(null, "Está seguro que quiere eliminar el empleado: "+ emp.getNombre()+"?",
								"PRECAUCIÓN", JOptionPane.YES_NO_OPTION);
							if(confirmacion == 0) {
								
								boolean borradoexitoso = empleDAO.borrar(pk);
								
								if(borradoexitoso == true) {
									
									JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente",
											"¡ELIMINADO!", JOptionPane.INFORMATION_MESSAGE);
									
								}else {
									
									JOptionPane.showMessageDialog(null, "Error intentando eliminar el empleado", "ERROR!", JOptionPane.ERROR_MESSAGE);

									
								}
							}			
						
					}else {
						
						JOptionPane.showMessageDialog(null, "Empleado inexistente", "ERROR!", JOptionPane.ERROR_MESSAGE);

					}
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado primero", "Atención!", JOptionPane.WARNING_MESSAGE);
					
				}
				
				listaEmp = empleDAO.listarTodos();
				
				mostrarEmpleados();
				
			}
		});
		
				mbOpciones.add(mnBaja);
				mnConsulta.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						int filaselec = tablaEmpleados.getSelectedRow();
						
						if(filaselec != -1) {
							
							Object codigoCliente = tablaEmpleados.getValueAt(filaselec, 0);
							
							String pkStr = String.valueOf(codigoCliente);					
							
							int pk = Integer.parseInt(pkStr);
							
							empleado_DTO emp = empleDAO.buscar(pk);
							
							if(emp != null) {
								
								ConsultaEmple c1 = new ConsultaEmple(emp.getId_emple());
								c1.setVisible(true);
								dispose();
								
							}else {
								
								JOptionPane.showMessageDialog(null, "Empleado inexistente", "ERROR!", JOptionPane.ERROR_MESSAGE);

							}
							
						}else {
							
							JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado primero", "Atención!", JOptionPane.WARNING_MESSAGE);
							
						}
						
						listaEmp = empleDAO.listarTodos();
						mostrarEmpleados();
						
					}
				});
				mnConsulta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				mbOpciones.add(mnConsulta);
				JMenu mnVolver = new JMenu("VOLVER");
				mnVolver.setForeground(SystemColor.text);
				mnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				mnVolver.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						BARMANOLO b1 = new BARMANOLO();
						b1.setVisible(true);
						dispose();
					}
				});
				mbOpciones.add(mnVolver);
		
	//----------------------------------------------- INICIALIZACION -----------------------------------------
		
		listaEmp = empleDAO.listarTodos();
		mostrarEmpleados();
		
	}
	//----------------------------------------------------------------------------------------------------------

	
	//----------------------------------------------- METODOS PARA MOSTRAR -------------------------------------
	
	/**
	 * Metodo que muestra nuestra lista de empleados en la tabla
	 */
	public void mostrarEmpleados() {	
		while (modelo.getRowCount() > 0) modelo.removeRow(0);
		int numCols = modelo.getColumnCount();		
		Object [] fila = new Object[numCols];
		for (empleado_DTO emp: listaEmp) {
			fila[0] = emp.getId_emple();
			fila[1] = emp.getDni();
			fila[2] = emp.getNombre();
			fila[3] = emp.getEmail();
			fila[4] = emp.getTelefono();
			fila[5] = emp.getfNacimiento();
			modelo.addRow(fila);
		}
	}
}
