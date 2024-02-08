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
import java.rmi.Naming;

public class Tiempo extends JDialog {

	private static final long serialVersionUID = 1L;

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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sestao", "Santander", "Vitoria-Gasteiz"}));
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
		lblMensajeDelServidor.setBounds(101, 48, 189, 38);
		panel.add(lblMensajeDelServidor);
		
		JLabel lblToldo = new JLabel("TOLDO");
		lblToldo.setForeground(Color.WHITE);
		lblToldo.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblToldo.setBounds(101, 118, 213, 38);
		panel.add(lblToldo);
		
        try {
            String nombreServidor = "TiempoServidor"; // El mismo nombre que usamos en el servidor
            interfazRMI tiempoRemoto = (interfazRMI) Naming.lookup(nombreServidor);
            tiempoRemoto.getTiempo(comboBox.getSelectedItem().toString()); // Llamada al método remoto
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
