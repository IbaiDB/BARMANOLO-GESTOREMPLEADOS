package ModeloBD_Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
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

import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestorEmpleados extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private empleado_DAO emple = new empleado_DAO();
	private ArrayList<empleado_DTO> listaEmp;
	private DefaultTableModel modelo;

	public GestorEmpleados() {
		
		listaEmp = emple.listarTodos();
		
		
		
		setBounds(100, 100, 1207, 616);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(117, 180, 249));
		contentPanel.setForeground(new Color(117, 180, 249));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTOR DE EMPLEADOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 46));
		lblNewLabel.setBounds(220, 11, 721, 83);
		contentPanel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 116, 1062, 340);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id_Empleado", "DNI", "Nombre", "Email", "Tel\u00E9fono", "Fecha de Nacimiento"
			}
		));
		table.getColumnModel().getColumn(5).setPreferredWidth(110);
		scrollPane.setViewportView(table);
		
		JMenuBar mbOpciones = new JMenuBar();
		mbOpciones.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mbOpciones.setBounds(0, 549, 1191, 28);
		contentPanel.add(mbOpciones);
		
		JMenu mnAlta = new JMenu("ALTA EMPLEADO");
		mnAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AltaEmple a1 = new AltaEmple();
				a1.setVisible(true);
				dispose();
				
			}
		});
		mnAlta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAlta.setHorizontalAlignment(SwingConstants.CENTER);
		mbOpciones.add(mnAlta);
		
		JMenu mnModificar = new JMenu("MODIFICAR EMPLEADO");
		mnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int filaselec = table.getSelectedRow();
				
				if(filaselec != -1) {
					
					Object codigoCliente = table.getValueAt(filaselec, 0);
					
					String pkStr = String.valueOf(codigoCliente);					
					
					int pk = Integer.parseInt(pkStr);
					
					empleado_DTO emp = emple.buscar(pk);
					
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
				
				listaEmp = emple.listarTodos();
				
				mostrarEmpleados(modelo, listaEmp);
				
			}
		});
		mnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnModificar.setHorizontalAlignment(SwingConstants.CENTER);
		mbOpciones.add(mnModificar);
		
		JMenu mnBaja = new JMenu("ELIMINAR EMPLEADO");
		mnBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int filaselec = table.getSelectedRow();
				
				if(filaselec != -1) {
					
					Object codigoCliente = table.getValueAt(filaselec, 0);
					
					String pkStr = String.valueOf(codigoCliente);					
					
					int pk = Integer.parseInt(pkStr);
					
					int confirmacion;
					
					empleado_DTO emp = emple.buscar(pk);
					
					if(emp != null) {
						
						confirmacion = JOptionPane.showConfirmDialog(null, "Está seguro que quiere eliminar el empleado: "+ emp.getNombre()+"?",
								"PRECAUCIÓN", JOptionPane.YES_NO_OPTION);
							if(confirmacion == 0) {
								
								boolean borradoexitoso = emple.borrar(pk);
								
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
				
				listaEmp = emple.listarTodos();
				
				mostrarEmpleados(modelo, listaEmp);
				
			}
		});

		mnBaja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mbOpciones.add(mnBaja);
		
		JMenu mnConsulta = new JMenu("REVISAR INFORMACIÓN DETALLADA");
		mnConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int filaselec = table.getSelectedRow();
				
				if(filaselec != -1) {
					
					Object codigoCliente = table.getValueAt(filaselec, 0);
					
					String pkStr = String.valueOf(codigoCliente);					
					
					int pk = Integer.parseInt(pkStr);
					
					empleado_DTO emp = emple.buscar(pk);
					
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
				
				listaEmp = emple.listarTodos();
				
				mostrarEmpleados(modelo, listaEmp);
				
			}
		});
		mnConsulta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mbOpciones.add(mnConsulta);
		
		JMenu mnVolver = new JMenu("VOLVER");
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
		modelo = (DefaultTableModel) table.getModel();
		
		mostrarEmpleados(modelo, listaEmp);
		
	}
	
	public void mostrarEmpleados(DefaultTableModel modelo, ArrayList<empleado_DTO> lista) {	
		while (modelo.getRowCount() > 0) modelo.removeRow(0); //vaciar el modelo
		int numCols = modelo.getColumnCount();		
		Object [] fila = new Object[numCols];
		for (empleado_DTO emp: lista) {
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
