package ModeloBD_Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class UsoChat extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();


	public UsoChat(int pk) {
		
		setBounds(100, 100, 1019, 596);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(117, 180, 249));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("USO DEL CHAT");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBackground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
			lblNewLabel.setBounds(85, 35, 831, 76);
			contentPanel.add(lblNewLabel);
		}
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(122, 122, 733, 314);
		contentPanel.add(textArea);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 535, 1003, 22);
		contentPanel.add(menuBar);
		
		JMenu mnVolver = new JMenu("VOVLER");
		
		
		mnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ConsultaEmple c1 = new ConsultaEmple(pk);
				c1.setVisible(true);
				dispose();
				
			}
		});
		menuBar.add(mnVolver);
	}
}
