package ModeloBD_Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModeloBD_DAO.empleado_DAO;
import ModeloBD_DTO.empleado_DTO;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaEmple extends JDialog {
	
	//------------------------------------------------VARIABLES GLOBALES  --------------------------------------


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNom;
	private JTextField tfDni;
	private JTextField tfFnac;
	private JTextField tfTel;
	private JTextField tfEmail;
	private JTextField tfSal;
	private JTextField tfSegso;
	private JTextField tfCargo;
	private empleado_DAO emple =  new empleado_DAO();
	
	
	//-----------------------------------------------------------------------------------------------------------


	public ConsultaEmple(int pk) {
		
		empleado_DTO este = emple.buscar(pk);
		setBounds(100, 100, 885, 543);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 206, 209));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(50, 90, 784, 360);
		contentPanel.add(panel);
		
		tfNom = new JTextField();
		tfNom.setText((String) null);
		tfNom.setColumns(10);
		tfNom.setBounds(215, 94, 178, 22);
		panel.add(tfNom);
		
		tfDni = new JTextField();
		tfDni.setText((String) null);
		tfDni.setColumns(10);
		tfDni.setBounds(215, 143, 146, 22);
		panel.add(tfDni);
		
		tfFnac = new JTextField();
		tfFnac.setText((String) null);
		tfFnac.setColumns(10);
		tfFnac.setBounds(215, 198, 127, 22);
		panel.add(tfFnac);
		
		tfTel = new JTextField();
		tfTel.setText("0");
		tfTel.setColumns(10);
		tfTel.setBounds(519, 94, 146, 22);
		panel.add(tfTel);
		
		tfEmail = new JTextField();
		tfEmail.setText((String) null);
		tfEmail.setColumns(10);
		tfEmail.setBounds(519, 143, 235, 22);
		panel.add(tfEmail);
		
		tfSal = new JTextField();
		tfSal.setText("0.0");
		tfSal.setColumns(10);
		tfSal.setBounds(215, 266, 87, 22);
		panel.add(tfSal);
		
		JToggleButton tgbtPermiso = new JToggleButton("No permitido");
		tgbtPermiso.setBackground(new Color(255, 255, 255));
		tgbtPermiso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tgbtPermiso.setBounds(519, 260, 146, 23);
		panel.add(tgbtPermiso);
		
		tfSegso = new JTextField();
		tfSegso.setText("0");
		tfSegso.setColumns(10);
		tfSegso.setBounds(519, 198, 235, 22);
		panel.add(tfSegso);
		
		tfCargo = new JTextField();
		tfCargo.setHorizontalAlignment(SwingConstants.CENTER);
		tfCargo.setEnabled(false);
		tfCargo.setDisabledTextColor(Color.BLACK);
		tfCargo.setColumns(10);
		tfCargo.setBounds(519, 31, 170, 19);
		panel.add(tfCargo);
		
		tfNom.setText(este.getNombre());
		tfDni.setText(este.getDni());
		tfFnac.setText(este.getfNacimiento());
		tfEmail.setText(este.getEmail());
		tfSegso.setText(Long.toString(este.getNumSegSooc()));
		tfTel.setText(Integer.toString(este.getTelefono()));
		tfSal.setText(Double.toString(este.getSalario()));
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNombre.setBounds(108, 94, 89, 22);
		panel.add(lblNombre);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDni.setForeground(Color.BLACK);
		lblDni.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblDni.setBounds(139, 142, 58, 22);
		panel.add(lblDni);
		
		JLabel lblFnac_1 = new JLabel("F.Nacimiento:");
		lblFnac_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFnac_1.setForeground(Color.BLACK);
		lblFnac_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblFnac_1.setBounds(75, 197, 122, 22);
		panel.add(lblFnac_1);
		
		JLabel lblFnac2 = new JLabel("(YYYY-MM-DD)");
		lblFnac2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFnac2.setForeground(Color.BLACK);
		lblFnac2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblFnac2.setBounds(85, 215, 121, 22);
		panel.add(lblFnac2);
		
		JLabel lblSal_1 = new JLabel("Salario: ");
		lblSal_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSal_1.setForeground(Color.BLACK);
		lblSal_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblSal_1.setBounds(139, 260, 58, 22);
		panel.add(lblSal_1);
		
		JLabel lblChat_1 = new JLabel("Acceso a chat:");
		lblChat_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblChat_1.setForeground(Color.BLACK);
		lblChat_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblChat_1.setBounds(397, 257, 108, 28);
		panel.add(lblChat_1);
		
		JLabel lblSegsoc_1 = new JLabel("NUSS:");
		lblSegsoc_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSegsoc_1.setForeground(Color.BLACK);
		lblSegsoc_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblSegsoc_1.setBounds(436, 194, 69, 28);
		panel.add(lblSegsoc_1);
		
		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail_1.setForeground(Color.BLACK);
		lblEmail_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblEmail_1.setBounds(418, 141, 87, 22);
		panel.add(lblEmail_1);
		
		JLabel lblTel_1 = new JLabel("Teléfono:");
		lblTel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTel_1.setForeground(Color.BLACK);
		lblTel_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblTel_1.setBounds(418, 94, 87, 22);
		panel.add(lblTel_1);
		
		JLabel lblTel_1_1 = new JLabel("Cargo:");
		lblTel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTel_1_1.setForeground(Color.BLACK);
		lblTel_1_1.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblTel_1_1.setBounds(418, 29, 87, 22);
		panel.add(lblTel_1_1);
		if(este.isPermisoChat()){
			tgbtPermiso.setSelected(true);
		}
		if(este.isTipo()){
			tfCargo.setText("Gerente");
		}else{
			tfCargo.setText("Camarero");
		}
		
		JLabel lblNewLabel = new JLabel("BAR MANOLO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 22));
		lblNewLabel.setBounds(50, 33, 217, 48);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CONSULTA AVANZADA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Montserrat", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(440, 41, 394, 37);
		contentPanel.add(lblNewLabel_1);
					
						
						JMenuBar menuBar = new JMenuBar();
						menuBar.setBackground(new Color(255, 255, 255));
						menuBar.setBounds(0, 0, 909, 22);
						contentPanel.add(menuBar);
						
						JMenu mnUsoChat = new JMenu("USO DEL CHAT");
						JMenu mnReporteHorario = new JMenu("REPORTE HORARIO");
						
						
						
								//-----------------------------------------------------------------------------------------------------------
						
								
								mnUsoChat.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										
										ControladorVistas.abrirUsoChat(pk);
										dispose();
										
									}
								});
								menuBar.add(mnUsoChat);
								
								mnReporteHorario.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										
										ControladorVistas.abrirFichajeEmpleado(pk);
										dispose();
										
									}
								});
								
								menuBar.add(mnReporteHorario);
								
								JButton btnVolver = new JButton("VOLVER");
								btnVolver.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										ControladorVistas.abrirGestorEmpleados();
										dispose();
									}
								});
								btnVolver.setForeground(Color.WHITE);
								btnVolver.setBackground(Color.RED);
								btnVolver.setBounds(662, 462, 173, 44);
								contentPanel.add(btnVolver);
		
		//-----------------------------------------------------------------------------------------------------------

	}
}
