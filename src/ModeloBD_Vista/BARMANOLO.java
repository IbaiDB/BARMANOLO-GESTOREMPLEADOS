package ModeloBD_Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;


import interfazRMI.interfazRMI;

import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;



public class BARMANOLO extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BARMANOLO frame = new BARMANOLO();
					frame.setVisible(true);
					
					try {
					    interfazRMI obj = (interfazRMI) Naming.lookup("//127.0.0.1/API");
						String mensajes = obj.getAPI("https://barmanolo.onrender.com/api/leer/mensajes");
						procesarJson(mensajes);
					} catch (java.rmi.ConnectException ce) {
					    ce.printStackTrace();
					    // Manejo específico de la excepción...
					} catch (Exception e) {
					    e.printStackTrace();
					}
			
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	  public static void procesarJson(String jsonString) {
	        // Elimina corchetes cuadrados para obtener solo el contenido del array JSON
	        jsonString = jsonString.substring(1, jsonString.length() - 1);

	        // Divide el string en objetos JSON separados
	        String[] objetosJson = jsonString.split("\\},\\s*\\{");

	        // Lista para almacenar los HashMaps resultantes
	        List<HashMap<String, String>> listaHashMaps = new ArrayList<>();

	        for (String objetoJson : objetosJson) {
	            // Elimina posibles corchetes restantes al principio o al final
	            objetoJson = objetoJson.trim().replaceAll("^\\{|\\}$", "");

	            // Divide el objeto JSON en pares clave-valor
	            String[] paresClaveValor = objetoJson.split(",\\s*");

	            // HashMap para almacenar el resultado
	            HashMap<String, String> hashMap = new HashMap<>();

	            // Itera sobre los pares clave-valor y los agrega al HashMap
	            for (String par : paresClaveValor) {
	                String[] partes = par.split(":");
	                String clave = partes[0].replaceAll("^\"|\"$", "").trim();
	                String valor = partes[1].replaceAll("^\"|\"$", "").trim();
	                hashMap.put(clave, valor);
	            }

	            // Agrega el HashMap a la lista
	            listaHashMaps.add(hashMap);

	            // Llama a la función con el HashMap recién creado
	            hacerAlgoConHashMap(hashMap);
	        }
	    }

	    public static void hacerAlgoConHashMap(HashMap<String, String> hashMap) {
	        // Aquí puedes realizar la operación que deseas con el HashMap
	        System.out.println("HashMap: " + hashMap);
	    }
	/**
	 * Create the frame.
	 */
	public BARMANOLO() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1210, 614);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(117, 180, 249));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 100));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 113, 1174, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ibi\\Desktop\\RETO1\\BarManoloReto\\RegistroEmpleadosReto\\lib\\src\\Imagenes\\bar-manolo.jpg"));
		lblNewLabel.setBounds(10, 11, 1154, 265);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DESCANSAR NO ES PERDER EL TIEMPO");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.ITALIC, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(98, 297, 986, 57);
		panel.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1194, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("MÓDULOS DE GESTIÓN");
		mnNewMenu.setBorder(new CompoundBorder());
		mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("GESTOR DE EMPLEADOS");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GestorEmpleados g1 = new GestorEmpleados();
				g1.setVisible(true);
				dispose();
				
			}
		});
		mntmNewMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu.add(mntmNewMenuItem);
		
		JButton btnNewButton = new JButton("CERRAR APLICACIÓN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(516, 521, 163, 31);
		contentPane.add(btnNewButton);
	}
}
