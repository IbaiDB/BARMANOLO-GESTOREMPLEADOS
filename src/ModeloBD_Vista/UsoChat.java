package ModeloBD_Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModeloBD_DTO.mensaje_DTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsoChat extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();


	public UsoChat(int pk) {
		setResizable(false);
		setAutoRequestFocus(false);
		setFont(new Font("Montserrat", Font.PLAIN, 14));
		
		setBounds(100, 100, 1019, 580);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 206, 209));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(39, 49, 950, 450);
		contentPanel.add(textArea);
		
		for (mensaje_DTO mensaje : BARMANOLO.listamensajes) {
		    if (mensaje.idEmpleado == (int)pk) {
		        textArea.append(mensaje.toString() + "\n"); // Agregar el mensaje al textArea
		    }
		}


		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorVistas.abrirGestorEmpleados();
				
				dispose();
				
			}
		});
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBackground(Color.RED);
		btnVolver.setBounds(818, 511, 173, 44);
		contentPanel.add(btnVolver);
		
	}
}
