package ModeloBD_Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaces.interfazRMI;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import javax.swing.JTextArea;

public class Tiempo extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private interfazRMI tiempoRemoto=null;

	/**
	 * Create the dialog.
	 */
	public Tiempo() {
		
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Montserrat", Font.BOLD, 12));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sestao", "Santander", "Vitoria-Gasteiz", "Bilbao"}));
		comboBox.setBounds(243, 12, 134, 24);
		panel.add(comboBox);
		
		JLabel lblRestaurante = new JLabel("RESTAURANTE:");
		lblRestaurante.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblRestaurante.setForeground(new Color(255, 255, 255));
		lblRestaurante.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRestaurante.setBounds(101, 17, 134, 15);
		panel.add(lblRestaurante);
		
		JLabel lblMensajeDelServidor = new JLabel("MENSAJE DEL SERVIDOR:");
		lblMensajeDelServidor.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblMensajeDelServidor.setForeground(new Color(255, 255, 255));
		lblMensajeDelServidor.setBounds(101, 46, 189, 38);
		panel.add(lblMensajeDelServidor);
		
		JTextArea txtMensaje = new JTextArea();
		txtMensaje.setFont(new Font("Montserrat", Font.PLAIN, 12));
		txtMensaje.setBounds(52, 93, 271, 153);
		panel.add(txtMensaje);
		
		
		
		// TODO Auto-generated method stub
		  try {
	            String nombreServidor = "TiempoServidor"; // El mismo nombre que usamos en el servidor
	            tiempoRemoto = (interfazRMI) Naming.lookup(nombreServidor);
	            if (tiempoRemoto != null) {
	                String tiempo = tiempoRemoto.getTiempo(comboBox.getSelectedItem().toString()); // Llamada al método remoto
	                System.out.println("tiempo" + tiempo);
	                txtMensaje.setText(tiempo);
	              
	            } else {
	                System.out.println("El objeto remoto es nulo.");
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  try {
			          
			            if (tiempoRemoto != null) {
			                tiempoRemoto.getTiempo(comboBox.getSelectedItem().toString());
			                System.out.println(comboBox.getSelectedItem().toString());
			            } else {
			                System.out.println("El objeto remoto es nulo.");
			            }
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			}
		});
		
		

		

	}
}
