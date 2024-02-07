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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.SystemColor;

public class ModificarEmple extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField tfNom;
	private JTextField tfDni;
	private JTextField tfFnac;
	private JTextField tfTel;
	private JTextField tfEmail;
	private JTextField tfSal;
	private JTextField tfSegso;
	private final ButtonGroup btgrpCargo = new ButtonGroup();
	private JRadioButton rbtGerente;
	private JRadioButton rbtCamarero;
	private JToggleButton tgbtPermiso;
	private empleado_DAO emple = new empleado_DAO();
	private ArrayList<empleado_DTO> listaEmp;
	
	public ModificarEmple(int pk) {
		
		listaEmp = emple.listarTodos();
		
		empleado_DTO este = emple.buscar(pk);
		
		setBounds(100, 100, 844, 547);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel contentPanel = new JPanel();
			contentPanel.setLayout(null);
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.setBackground(new Color(0, 206, 209));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			{
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel.setBackground(new Color(255, 255, 255));
				panel.setBounds(22, 59, 784, 391);
				contentPanel.add(panel);
				{
					JLabel lblNombre = new JLabel("Nombre: ");
					lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
					lblNombre.setForeground(new Color(0, 0, 0));
					lblNombre.setFont(new Font("Montserrat", Font.BOLD, 14));
					lblNombre.setBounds(45, 94, 89, 22);
					panel.add(lblNombre);
				}
				{
					tfNom = new JTextField();
					tfNom.setColumns(10);
					tfNom.setBounds(152, 95, 170, 22);
					panel.add(tfNom);
				}
				{
					JLabel lblDni = new JLabel("Dni:");
					lblDni.setHorizontalAlignment(SwingConstants.TRAILING);
					lblDni.setForeground(new Color(0, 0, 0));
					lblDni.setFont(new Font("Montserrat", Font.BOLD, 14));
					lblDni.setBounds(76, 142, 58, 22);
					panel.add(lblDni);
				}
				{
					tfDni = new JTextField();
					tfDni.setColumns(10);
					tfDni.setBounds(152, 143, 146, 22);
					panel.add(tfDni);
				}
				{
					JLabel lblFnac = new JLabel("F.Nacimiento:");
					lblFnac.setHorizontalAlignment(SwingConstants.TRAILING);
					lblFnac.setForeground(new Color(0, 0, 0));
					lblFnac.setFont(new Font("Montserrat", Font.BOLD, 14));
					lblFnac.setBounds(12, 197, 122, 22);
					panel.add(lblFnac);
				}
				{
					tfFnac = new JTextField();
					tfFnac.setColumns(10);
					tfFnac.setBounds(152, 198, 170, 22);
					panel.add(tfFnac);
				}
				{
					JLabel lblTel = new JLabel("Teléfono:");
					lblTel.setHorizontalAlignment(SwingConstants.TRAILING);
					lblTel.setForeground(new Color(0, 0, 0));
					lblTel.setFont(new Font("Montserrat", Font.BOLD, 14));
					lblTel.setBounds(355, 94, 87, 22);
					panel.add(lblTel);
				}
				{
					tfTel = new JTextField();
					tfTel.setColumns(10);
					tfTel.setBounds(457, 95, 160, 22);
					panel.add(tfTel);
				}
				{
					JLabel lblEmail = new JLabel("Email:");
					lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
					lblEmail.setForeground(new Color(0, 0, 0));
					lblEmail.setFont(new Font("Montserrat", Font.BOLD, 14));
					lblEmail.setBounds(355, 141, 87, 22);
					panel.add(lblEmail);
				}
				{
					tfEmail = new JTextField();
					tfEmail.setColumns(10);
					tfEmail.setBounds(457, 142, 231, 22);
					panel.add(tfEmail);
				}
				{
					JLabel lblSal = new JLabel("Salario: ");
					lblSal.setHorizontalAlignment(SwingConstants.TRAILING);
					lblSal.setForeground(new Color(0, 0, 0));
					lblSal.setFont(new Font("Montserrat", Font.BOLD, 14));
					lblSal.setBounds(76, 260, 58, 22);
					panel.add(lblSal);
				}
				{
					tfSal = new JTextField();
					tfSal.setColumns(10);
					tfSal.setBounds(152, 261, 108, 22);
					panel.add(tfSal);
				}
				{
					JLabel lblCargo = new JLabel("Cargo:");
					lblCargo.setHorizontalAlignment(SwingConstants.TRAILING);
					lblCargo.setForeground(new Color(0, 0, 0));
					lblCargo.setFont(new Font("Montserrat", Font.BOLD, 14));
					lblCargo.setBounds(334, 26, 108, 28);
					panel.add(lblCargo);
				}
				{
					rbtGerente = new JRadioButton("Gerente");
					btgrpCargo.add(rbtGerente);
					rbtGerente.setForeground(new Color(0, 0, 0));
					rbtGerente.setFont(new Font("Tahoma", Font.PLAIN, 14));
					rbtGerente.setBackground(new Color(255, 255, 255));
					rbtGerente.setBounds(457, 29, 109, 23);
					panel.add(rbtGerente);
				}
				{
					rbtCamarero = new JRadioButton("Camarero");
					btgrpCargo.add(rbtCamarero);
					rbtCamarero.setForeground(new Color(0, 0, 0));
					rbtCamarero.setFont(new Font("Tahoma", Font.PLAIN, 14));
					rbtCamarero.setBackground(new Color(255, 255, 255));
					rbtCamarero.setBounds(570, 29, 109, 23);
					panel.add(rbtCamarero);
				}
				{
					JLabel lblChat = new JLabel("Acceso a chat:");
					lblChat.setHorizontalAlignment(SwingConstants.TRAILING);
					lblChat.setForeground(new Color(0, 0, 0));
					lblChat.setFont(new Font("Montserrat", Font.BOLD, 14));
					lblChat.setBounds(334, 257, 108, 28);
					panel.add(lblChat);
				}
				{
					tgbtPermiso = new JToggleButton("No permitido");
					tgbtPermiso.setBackground(new Color(255, 255, 255));
					tgbtPermiso.setFont(new Font("Tahoma", Font.PLAIN, 14));
					tgbtPermiso.setBounds(457, 260, 161, 23);
					panel.add(tgbtPermiso);
				}
				{
					JLabel lblSegsoc = new JLabel("NUSS:");
					lblSegsoc.setHorizontalAlignment(SwingConstants.TRAILING);
					lblSegsoc.setForeground(new Color(0, 0, 0));
					lblSegsoc.setFont(new Font("Montserrat", Font.BOLD, 14));
					lblSegsoc.setBounds(373, 194, 69, 28);
					panel.add(lblSegsoc);
				}
				{
					tfSegso = new JTextField();
					tfSegso.setColumns(10);
					tfSegso.setBounds(457, 198, 223, 22);
					panel.add(tfSegso);
				}
				{
					JLabel lblFnac2 = new JLabel("(YYYY-MM-DD)");
					lblFnac2.setHorizontalAlignment(SwingConstants.CENTER);
					lblFnac2.setForeground(new Color(0, 0, 0));
					lblFnac2.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblFnac2.setBounds(22, 215, 121, 22);
					panel.add(lblFnac2);
				}
				
			
			
			{
				JButton btnModificarEmpleado = new JButton("MODIFICAR EMPLEADO");
				btnModificarEmpleado.setBackground(new Color(255, 255, 255));
				btnModificarEmpleado.setBounds(225, 318, 265, 43);
				panel.add(btnModificarEmpleado);
				
				JLabel lblSal = new JLabel("€");
				lblSal.setForeground(Color.BLACK);
				lblSal.setFont(new Font("Montserrat", Font.ITALIC, 12));
				lblSal.setBounds(264, 260, 58, 22);
				panel.add(lblSal);
				btnModificarEmpleado.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(tfNom.getText().isEmpty() || tfTel.getText().isEmpty() || tfEmail.getText().isEmpty() || tfDni.getText().isEmpty() ||
								 tfFnac.getText().isEmpty() || tfSegso.getText().isEmpty() ||  (rbtGerente.isSelected() == false
											&& rbtCamarero.isSelected() == false)) {
							
							JOptionPane.showMessageDialog(null, "¡Debes rellenar todos los campos!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							
						}else {
							
							
							boolean haydni = false;
							int cod = este.getId_emple();
							String nom = tfNom.getText();
							boolean per;
							boolean tipo;
							String email = tfEmail.getText();
							String dni = tfDni.getText();	
							String fnac = tfFnac.getText();
							double sal = Double.parseDouble(tfSal.getText());
							int tel = Integer.parseInt(tfTel.getText());
							long segso = Long.parseLong(tfSegso.getText());
							if(tgbtPermiso.isSelected()) {per = true;}else {per = false;}
							if(rbtGerente.isSelected()) {
								tipo = true;
							}else {
								tipo = false;
							}

							
							empleado_DTO nuevo = new empleado_DTO(cod, nom, tipo, dni, per, tel, segso, fnac, email, sal);
							
							if(emple.actualizar(nuevo)) {
								
								JOptionPane.showMessageDialog(null, "Cliente " + este.getNombre() + " actualizado.", "MODIFICADO!", JOptionPane.INFORMATION_MESSAGE);
								
								tfNom.setText(nuevo.getNombre());
								tfEmail.setText(nuevo.getEmail());
								tfDni.setText(nuevo.getDni());
								tfTel.setText(Integer.toString(nuevo.getTelefono()));
								tfFnac.setText(nuevo.getfNacimiento());
								tfSal.setText(Double.toString(nuevo.getSalario()));
								tfSegso.setText(Long.toString(nuevo.getNumSegSooc()));
								if(nuevo.isTipo()) {
									rbtGerente.setSelected(true);
								}else {
									rbtCamarero.setSelected(true);
								}
								if(nuevo.isPermisoChat()) {
									
								}

							}else {
								
								JOptionPane.showMessageDialog(null, "No se ha podido actualizar", "ERROR!", JOptionPane.ERROR_MESSAGE);
								
							}
						
						}
						
					}
				});
			}
			}
			
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
				rbtGerente.setSelected(true);
			}else{
				rbtCamarero.setSelected(true);
			}
			{
				JButton btnVolver = new JButton("VOLVER");
				btnVolver.setForeground(new Color(255, 255, 255));
				btnVolver.setBackground(new Color(255, 0, 0));
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						GestorEmpleados g1 = new GestorEmpleados();
						g1.setVisible(true);
						dispose();
						
					}
				});
				btnVolver.setBounds(633, 461, 173, 44);
				contentPanel.add(btnVolver);
			}
			{
				JLabel lblNewLabel = new JLabel("BAR MANOLO");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 22));
				lblNewLabel.setBounds(22, 9, 217, 48);
				contentPanel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("MODIFICAR EMPLEADOS");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setFont(new Font("Montserrat", Font.PLAIN, 17));
				lblNewLabel_1.setBounds(412, 10, 394, 37);
				contentPanel.add(lblNewLabel_1);
			}
		}
	}
}
