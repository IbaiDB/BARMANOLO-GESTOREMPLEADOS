package ModeloBD_Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ModeloBD_DAO.empleado_DAO;
import ModeloBD_DAO.fichaje_DAO;
import ModeloBD_DTO.empleado_DTO;
import ModeloBD_DTO.fichaje_DTO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;



public class FichajeEmple extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tbHorarios;
	private fichaje_DAO fichaje = new fichaje_DAO();
	private ArrayList<fichaje_DTO> listaFich;
	private DefaultTableModel modelo;
	

	public FichajeEmple(int pk) {
		
		listaFich = fichaje.listarPorEmple(pk);
		
		getContentPane().setBackground(new Color(0, 206, 209));
		setBounds(100, 100, 782, 558);
		getContentPane().setLayout(null);
		contentPanel.setBounds(1024, 0, 1, 502);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblCodEmp = new JLabel("");
		lblCodEmp.setForeground(new Color(255, 255, 255));
		lblCodEmp.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblCodEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodEmp.setBounds(908, 67, 107, 60);
		getContentPane().add(lblCodEmp);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 794, 22);
		getContentPane().add(menuBar);
		
		JMenu mnReportes = new JMenu("REPORTES DE FICHAJES");
		menuBar.add(mnReportes);
		
		JMenu mnVolver = new JMenu("VOLVER");
		mnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ConsultaEmple c1 = new ConsultaEmple(pk);
				c1.setVisible(true);
				dispose();
				
			}
		});
		menuBar.add(mnVolver);
		
		JLabel lblNewLabel = new JLabel("BAR MANOLO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 22));
		lblNewLabel.setBounds(50, 21, 217, 48);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(50, 66, 666, 439);
		getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 642, 415);
		panel.add(scrollPane);
		
		tbHorarios = new JTable();
		tbHorarios.setBackground(new Color(255, 255, 255));
		tbHorarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Fecha Entrada", "Fecha Salida", "Hora Entrada", "Hora Salida"
			}
		));
		tbHorarios.getColumnModel().getColumn(0).setPreferredWidth(87);
		tbHorarios.getColumnModel().getColumn(2).setPreferredWidth(81);
		scrollPane.setViewportView(tbHorarios);
		
		JLabel lblReporteHorario = new JLabel("REPORTE HORARIO");
		lblReporteHorario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblReporteHorario.setForeground(Color.WHITE);
		lblReporteHorario.setFont(new Font("Montserrat", Font.PLAIN, 17));
		lblReporteHorario.setBounds(499, 23, 217, 48);
		getContentPane().add(lblReporteHorario);
		
		modelo = (DefaultTableModel) tbHorarios.getModel();
		
		mostrarHorarios(modelo, listaFich);
		
	}
	
	public void mostrarHorarios(DefaultTableModel modelo, ArrayList<fichaje_DTO> lista) {	
		while (modelo.getRowCount() > 0) modelo.removeRow(0); //vaciar el modelo
		int numCols = modelo.getColumnCount();
		Date da = null;
		Object [] fila = new Object[numCols];
		for (fichaje_DTO fich: lista) {
			
			if(fich.getfEntrada().equals(da)) {
				
				fila[0] = null;
				fila[1] = null;
				fila[2] = fich.getHoraEntrada();
				fila[3] = fich.getHoraSalida();
				
			}else{
				
				fila[0] = fich.getfEntrada();
				fila[1] = fich.getfSalida();
				fila[2] = fich.getHoraEntrada();
				fila[3] = fich.getHoraSalida();
				da = fich.getfEntrada();
					
			}
			
			modelo.addRow(fila);
		}
	}
}
