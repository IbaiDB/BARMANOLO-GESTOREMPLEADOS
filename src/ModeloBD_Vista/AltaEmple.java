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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class AltaEmple extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNom;
	private JTextField tfDNI;
	private JTextField tfNaci;
	private JTextField tfTel;
	private JTextField tfMail;
	private JTextField tfSal;
	private JTextField tfNumSegso;
	private final ButtonGroup btgrpCargo = new ButtonGroup();
	private empleado_DAO emple = new empleado_DAO();
	private ArrayList<empleado_DTO> listaEmp;
	private JTextField tfCod;

	public AltaEmple() {
		
		listaEmp = emple.listarTodos();
		
		setBounds(100, 100, 822, 557);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(117, 180, 249));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 116, 583, 377);
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(0, 0, 100));
		contentPanel.add(panel);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(43, 29, 58, 22);
		panel.add(lblNombre);
		
		tfNom = new JTextField();
		tfNom.setColumns(10);
		tfNom.setBounds(116, 31, 180, 22);
		panel.add(tfNom);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(43, 78, 58, 22);
		panel.add(lblDni);
		
		tfDNI = new JTextField();
		tfDNI.setColumns(10);
		tfDNI.setBounds(86, 80, 146, 22);
		panel.add(tfDNI);
		
		JLabel lblFnac = new JLabel("F.Nacimiento:");
		lblFnac.setForeground(new Color(255, 255, 255));
		lblFnac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFnac.setBounds(43, 120, 121, 22);
		panel.add(lblFnac);
		
		tfNaci = new JTextField();
		tfNaci.setColumns(10);
		tfNaci.setBounds(150, 133, 146, 22);
		panel.add(tfNaci);
		
		JLabel lblTel = new JLabel("Teléfono:");
		lblTel.setForeground(new Color(255, 255, 255));
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTel.setBounds(43, 178, 87, 22);
		panel.add(lblTel);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(140, 180, 146, 22);
		panel.add(tfTel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(43, 228, 87, 22);
		panel.add(lblEmail);
		
		tfMail = new JTextField();
		tfMail.setColumns(10);
		tfMail.setBounds(104, 230, 212, 22);
		panel.add(tfMail);
		
		JLabel lblSal = new JLabel("Salario: ");
		lblSal.setForeground(new Color(255, 255, 255));
		lblSal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSal.setBounds(43, 278, 58, 22);
		panel.add(lblSal);
		
		tfSal = new JTextField();
		tfSal.setColumns(10);
		tfSal.setBounds(116, 280, 108, 22);
		panel.add(tfSal);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(new Color(255, 255, 255));
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(360, 26, 108, 28);
		panel.add(lblCargo);
		
		JRadioButton rbtGerente = new JRadioButton("Gerente");
		btgrpCargo.add(rbtGerente);
		rbtGerente.setForeground(new Color(255, 255, 255));
		rbtGerente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbtGerente.setBackground(new Color(0, 0, 100));
		rbtGerente.setBounds(328, 78, 109, 23);
		panel.add(rbtGerente);
		
		JRadioButton rbtCamarero = new JRadioButton("Camarero");
		btgrpCargo.add(rbtCamarero);
		rbtCamarero.setForeground(new Color(255, 255, 255));
		rbtCamarero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbtCamarero.setBackground(new Color(0, 0, 100));
		rbtCamarero.setBounds(457, 78, 109, 23);
		panel.add(rbtCamarero);
		
		JLabel lblChat = new JLabel("Acceso a chat:");
		lblChat.setForeground(new Color(255, 255, 255));
		lblChat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChat.setBounds(360, 128, 108, 28);
		panel.add(lblChat);
		
		JToggleButton tgbtPermiso = new JToggleButton("No permitido");
		ItemListener itemListener = new ItemListener() {
		    public void itemStateChanged(ItemEvent itemEvent)
		            {
		 
		                // event is generated in button
		                int state = itemEvent.getStateChange();
		 
		                // if selected print selected in console
		                if (state == ItemEvent.SELECTED) {
		                    tgbtPermiso.setText("Permitido");
		                }
		                else {
		                	tgbtPermiso.setText("No permitido");
		                }
		            }
		        };
		tgbtPermiso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tgbtPermiso.setBounds(389, 180, 121, 23);
		panel.add(tgbtPermiso);
		tgbtPermiso.addItemListener(itemListener);
		
		JLabel lblSegsoc = new JLabel("Núm. Seguridad Social:");
		lblSegsoc.setForeground(new Color(255, 255, 255));
		lblSegsoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSegsoc.setBounds(360, 228, 170, 28);
		panel.add(lblSegsoc);
		
		tfNumSegso = new JTextField();
		tfNumSegso.setColumns(10);
		tfNumSegso.setBounds(328, 281, 238, 22);
		panel.add(tfNumSegso);
		
		JLabel lblFnac2 = new JLabel("(YYYY-MM-DD)");
		lblFnac2.setForeground(new Color(255, 255, 255));
		lblFnac2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFnac2.setBounds(43, 140, 101, 22);
		panel.add(lblFnac2);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(43, 332, 58, 22);
		panel.add(lblCodigo);
		
		tfCod = new JTextField();
		tfCod.setColumns(10);
		tfCod.setBounds(116, 334, 78, 22);
		panel.add(tfCod);
		
		JLabel lblNewLabel = new JLabel("ALTA DE EMPLEADO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 46));
		lblNewLabel.setBounds(108, 11, 583, 93);
		contentPanel.add(lblNewLabel);
		
		JButton btnAlta = new JButton("GRABAR EMPLEADO");
		btnAlta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfCod.getText().isEmpty() || tfNom.getText().isEmpty() || tfDNI.getText().isEmpty() || tfNaci.getText().isEmpty() || tfTel.getText().isEmpty() || 
						tfSal.getText().isEmpty() || tfMail.getText().isEmpty() || tfNumSegso.getText().isEmpty() || (rbtGerente.isSelected() == false
						&& rbtCamarero.isSelected() == false)) {
					JOptionPane.showMessageDialog(null, "¡Debes rellenar todos los campos!", "¡Falta información!", JOptionPane.WARNING_MESSAGE);
				}else {
					
					
					boolean haydni = false;
					int cod = Integer.parseInt(tfCod.getText());
					String nom = tfNom.getText();
					boolean per;
					String email = tfMail.getText();
					String dni = tfDNI.getText();	
					String fnac = tfNaci.getText();
					double sal = Double.parseDouble(tfSal.getText());
					int tel = Integer.parseInt(tfTel.getText());
					long segso = Long.parseLong(tfNumSegso.getText());
					if(tgbtPermiso.isSelected()) {per = true;}else {per = false;}				
					
					for(empleado_DTO emp:listaEmp) {
						if(emp.getDni().equals(dni)) { haydni = true; }
					}
					
					if(haydni == false) {
						if(rbtGerente.isSelected()) {
							empleado_DTO emp = new empleado_DTO(cod, nom, true, dni, per, tel, segso, fnac, email, sal);
							emple.insertar(emp);
							tfNom.setText("");
							tfDNI.setText("");
							tfNaci.setText("");
							tfTel.setText("");
							tfSal.setText("");
							tfNumSegso.setText("");
							tfMail.setText("");
							tgbtPermiso.setSelected(false);
							btgrpCargo.clearSelection();
							JOptionPane.showMessageDialog(null, "Alta realizada correctamente",
									"¡GUARDADO!", JOptionPane.INFORMATION_MESSAGE);
						}
						if(rbtCamarero.isSelected()){
							empleado_DTO emp = new empleado_DTO(cod, nom, false, dni, per, tel, segso, fnac, email, sal);
							emple.insertar(emp);
								
							tfNom.setText("");
							tfDNI.setText("");
							tfNaci.setText("");
							tfTel.setText("");
							tfSal.setText("");
							tfNumSegso.setText("");
							tfMail.setText("");
							tgbtPermiso.setSelected(false);
								btgrpCargo.clearSelection();
								JOptionPane.showMessageDialog(null, "Alta realizada correctamente",
										"¡GUARDADO!", JOptionPane.INFORMATION_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Ya existe un empleado con ese Dni",
								"¡ERROR!", JOptionPane.ERROR_MESSAGE);
					}		
					
			}
			}
		});
		btnAlta.setBounds(633, 224, 150, 66);
		contentPanel.add(btnAlta);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GestorEmpleados g1 = new GestorEmpleados();
				g1.setVisible(true);
				dispose();
				
			}
		});
		btnVolver.setBounds(633, 365, 150, 44);
		contentPanel.add(btnVolver);
	}
}
