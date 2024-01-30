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

public class ConsultaEmple extends JDialog {

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

	public ConsultaEmple(int pk) {
		
		empleado_DTO este = emple.buscar(pk);
		setBounds(100, 100, 783, 608);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(117, 180, 249));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(0, 0, 100));
		panel.setBounds(61, 120, 627, 347);
		contentPanel.add(panel);
		
		JLabel lblNombre_1 = new JLabel("Nombre: ");
		lblNombre_1.setForeground(new Color(255, 255, 255));
		lblNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre_1.setBounds(29, 29, 58, 22);
		panel.add(lblNombre_1);
		
		tfNom = new JTextField();
		tfNom.setText((String) null);
		tfNom.setColumns(10);
		tfNom.setBounds(97, 31, 178, 22);
		panel.add(tfNom);
		
		JLabel lblDni_1 = new JLabel("Dni:");
		lblDni_1.setForeground(new Color(255, 255, 255));
		lblDni_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni_1.setBounds(29, 78, 58, 22);
		panel.add(lblDni_1);
		
		tfDni = new JTextField();
		tfDni.setText((String) null);
		tfDni.setColumns(10);
		tfDni.setBounds(75, 80, 146, 22);
		panel.add(tfDni);
		
		JLabel lblFnac = new JLabel("F.Nacimiento:");
		lblFnac.setForeground(new Color(255, 255, 255));
		lblFnac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFnac.setBounds(29, 128, 87, 22);
		panel.add(lblFnac);
		
		tfFnac = new JTextField();
		tfFnac.setText((String) null);
		tfFnac.setColumns(10);
		tfFnac.setBounds(129, 128, 127, 22);
		panel.add(tfFnac);
		
		JLabel lblTel = new JLabel("Teléfono:");
		lblTel.setForeground(new Color(255, 255, 255));
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTel.setBounds(29, 178, 87, 22);
		panel.add(lblTel);
		
		tfTel = new JTextField();
		tfTel.setText("0");
		tfTel.setColumns(10);
		tfTel.setBounds(107, 180, 146, 22);
		panel.add(tfTel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(29, 228, 87, 22);
		panel.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setText((String) null);
		tfEmail.setColumns(10);
		tfEmail.setBounds(85, 230, 235, 22);
		panel.add(tfEmail);
		
		JLabel lblSal = new JLabel("Salario: ");
		lblSal.setForeground(new Color(255, 255, 255));
		lblSal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSal.setBounds(29, 278, 58, 22);
		panel.add(lblSal);
		
		tfSal = new JTextField();
		tfSal.setText("0.0");
		tfSal.setColumns(10);
		tfSal.setBounds(97, 280, 87, 22);
		panel.add(tfSal);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(new Color(255, 255, 255));
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(419, 26, 108, 28);
		panel.add(lblCargo);
		
		JLabel lblChat = new JLabel("Acceso a chat:");
		lblChat.setForeground(new Color(255, 255, 255));
		lblChat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChat.setBounds(387, 125, 108, 28);
		panel.add(lblChat);
		
		JToggleButton tgbtPermiso = new JToggleButton("No permitido");
		tgbtPermiso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tgbtPermiso.setBounds(374, 178, 121, 23);
		panel.add(tgbtPermiso);
		
		JLabel lblSegsoc = new JLabel("Núm. Seguridad Social:");
		lblSegsoc.setForeground(new Color(255, 255, 255));
		lblSegsoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSegsoc.setBounds(357, 225, 170, 28);
		panel.add(lblSegsoc);
		
		tfSegso = new JTextField();
		tfSegso.setText("0");
		tfSegso.setColumns(10);
		tfSegso.setBounds(328, 280, 223, 22);
		panel.add(tfSegso);
		
		tfCargo = new JTextField();
		tfCargo.setHorizontalAlignment(SwingConstants.CENTER);
		tfCargo.setEnabled(false);
		tfCargo.setDisabledTextColor(Color.BLACK);
		tfCargo.setColumns(10);
		tfCargo.setBounds(355, 81, 170, 19);
		panel.add(tfCargo);
		
		JLabel lblInformacinDetallada = new JLabel("INFORMACIÓN DETALLADA");
		lblInformacinDetallada.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacinDetallada.setForeground(Color.WHITE);
		lblInformacinDetallada.setFont(new Font("Tahoma", Font.BOLD, 46));
		lblInformacinDetallada.setBounds(28, 16, 697, 93);
		contentPanel.add(lblInformacinDetallada);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 548, 862, 22);
		contentPanel.add(menuBar);
		
		JMenu mnUsoChat = new JMenu("USO DEL CHAT");
		mnUsoChat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				UsoChat u1 = new UsoChat(pk);
				u1.setVisible(true);
				dispose();
				
			}
		});
		menuBar.add(mnUsoChat);
		
		JMenu mnReporteHorario = new JMenu("REPORTE HORARIO");
		mnReporteHorario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				FichajeEmple f1 = new FichajeEmple(pk);
				f1.setVisible(true);
				dispose();
				
			}
		});
		menuBar.add(mnReporteHorario);
		
		JMenu mnVolver = new JMenu("VOLVER");
		mnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
							
				GestorEmpleados g1 = new GestorEmpleados();
				g1.setVisible(true);
				dispose();
				
			}
		});
		menuBar.add(mnVolver);
		
		tfNom.setText(este.getNombre());
		tfDni.setText(este.getDni());
		tfFnac.setText(este.getfNacimiento());
		tfEmail.setText(este.getEmail());
		tfSegso.setText(Long.toString(este.getNumSegSooc()));
		tfTel.setText(Integer.toString(este.getTelefono()));
		tfSal.setText(Double.toString(este.getSalario()));
		if(este.isPermisoChat()){
			tgbtPermiso.setSelected(true);
		}
		if(este.isTipo()){
			tfCargo.setText("Gerente");
		}else{
			tfCargo.setText("Camarero");
		}
	}
}
