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
			contentPanel.setBackground(new Color(117, 180, 249));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			{
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel.setBackground(new Color(0, 0, 100));
				panel.setBounds(31, 157, 583, 336);
				contentPanel.add(panel);
				{
					JLabel lblNombre = new JLabel("Nombre: ");
					lblNombre.setForeground(Color.WHITE);
					lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblNombre.setBounds(43, 29, 58, 22);
					panel.add(lblNombre);
				}
				{
					tfNom = new JTextField();
					tfNom.setColumns(10);
					tfNom.setBounds(111, 31, 170, 22);
					panel.add(tfNom);
				}
				{
					JLabel lblDni = new JLabel("Dni:");
					lblDni.setForeground(Color.WHITE);
					lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblDni.setBounds(43, 78, 58, 22);
					panel.add(lblDni);
				}
				{
					tfDni = new JTextField();
					tfDni.setColumns(10);
					tfDni.setBounds(89, 80, 146, 22);
					panel.add(tfDni);
				}
				{
					JLabel lblFnac = new JLabel("F.Nacimiento:");
					lblFnac.setForeground(Color.WHITE);
					lblFnac.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblFnac.setBounds(43, 120, 121, 22);
					panel.add(lblFnac);
				}
				{
					tfFnac = new JTextField();
					tfFnac.setColumns(10);
					tfFnac.setBounds(150, 133, 170, 22);
					panel.add(tfFnac);
				}
				{
					JLabel lblTel = new JLabel("Teléfono:");
					lblTel.setForeground(Color.WHITE);
					lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblTel.setBounds(43, 178, 87, 22);
					panel.add(lblTel);
				}
				{
					tfTel = new JTextField();
					tfTel.setColumns(10);
					tfTel.setBounds(121, 180, 160, 22);
					panel.add(tfTel);
				}
				{
					JLabel lblEmail = new JLabel("Email:");
					lblEmail.setForeground(Color.WHITE);
					lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblEmail.setBounds(43, 228, 87, 22);
					panel.add(lblEmail);
				}
				{
					tfEmail = new JTextField();
					tfEmail.setColumns(10);
					tfEmail.setBounds(89, 230, 231, 22);
					panel.add(tfEmail);
				}
				{
					JLabel lblSal = new JLabel("Salario: ");
					lblSal.setForeground(Color.WHITE);
					lblSal.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblSal.setBounds(43, 278, 58, 22);
					panel.add(lblSal);
				}
				{
					tfSal = new JTextField();
					tfSal.setColumns(10);
					tfSal.setBounds(111, 280, 108, 22);
					panel.add(tfSal);
				}
				{
					JLabel lblCargo = new JLabel("Cargo:");
					lblCargo.setForeground(Color.WHITE);
					lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblCargo.setBounds(360, 26, 108, 28);
					panel.add(lblCargo);
				}
				{
					rbtGerente = new JRadioButton("Gerente");
					btgrpCargo.add(rbtGerente);
					rbtGerente.setForeground(Color.WHITE);
					rbtGerente.setFont(new Font("Tahoma", Font.PLAIN, 14));
					rbtGerente.setBackground(new Color(0, 0, 100));
					rbtGerente.setBounds(328, 78, 109, 23);
					panel.add(rbtGerente);
				}
				{
					rbtCamarero = new JRadioButton("Camarero");
					btgrpCargo.add(rbtCamarero);
					rbtCamarero.setForeground(Color.WHITE);
					rbtCamarero.setFont(new Font("Tahoma", Font.PLAIN, 14));
					rbtCamarero.setBackground(new Color(0, 0, 100));
					rbtCamarero.setBounds(457, 78, 109, 23);
					panel.add(rbtCamarero);
				}
				{
					JLabel lblChat = new JLabel("Acceso a chat:");
					lblChat.setForeground(Color.WHITE);
					lblChat.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblChat.setBounds(360, 128, 108, 28);
					panel.add(lblChat);
				}
				{
					tgbtPermiso = new JToggleButton("No permitido");
					tgbtPermiso.setFont(new Font("Tahoma", Font.PLAIN, 14));
					tgbtPermiso.setBounds(389, 180, 121, 23);
					panel.add(tgbtPermiso);
				}
				{
					JLabel lblSegsoc = new JLabel("Núm. Seguridad Social:");
					lblSegsoc.setForeground(Color.WHITE);
					lblSegsoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblSegsoc.setBounds(360, 228, 170, 28);
					panel.add(lblSegsoc);
				}
				{
					tfSegso = new JTextField();
					tfSegso.setColumns(10);
					tfSegso.setBounds(343, 281, 223, 22);
					panel.add(tfSegso);
				}
				{
					JLabel lblFnac2 = new JLabel("(YYYY-MM-DD)");
					lblFnac2.setForeground(Color.WHITE);
					lblFnac2.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblFnac2.setBounds(43, 140, 101, 22);
					panel.add(lblFnac2);
				}
			}
			{
				JLabel lblModificacinDeEmpleado = new JLabel("MODIFICACIÓN DE EMPLEADO");
				lblModificacinDeEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
				lblModificacinDeEmpleado.setForeground(Color.WHITE);
				lblModificacinDeEmpleado.setFont(new Font("Tahoma", Font.BOLD, 46));
				lblModificacinDeEmpleado.setBounds(31, 11, 717, 93);
				contentPanel.add(lblModificacinDeEmpleado);
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
				JButton btnModificarEmpleado = new JButton("MODIFICAR EMPLEADO");
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
				btnModificarEmpleado.setBounds(633, 224, 173, 66);
				contentPanel.add(btnModificarEmpleado);
			}
			{
				JButton btnVolver = new JButton("VOLVER");
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						GestorEmpleados g1 = new GestorEmpleados();
						g1.setVisible(true);
						dispose();
						
					}
				});
				btnVolver.setBounds(633, 365, 173, 44);
				contentPanel.add(btnVolver);
			}
		}
	}

}
