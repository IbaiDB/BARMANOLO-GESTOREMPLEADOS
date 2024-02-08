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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ConexionBD.ConexionMensajesHorario;
import ModeloBD_DAO.empleado_DAO;
import ModeloBD_DAO.mensaje_DAO;
import ModeloBD_DTO.empleado_DTO;
import ModeloBD_DTO.mensaje_DTO;
import interfaces.interfazRMI;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;



public class BARMANOLO extends JFrame {
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfDni;
	
	public static List<mensaje_DTO> listamensajes = new ArrayList<mensaje_DTO>();

	//----------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					ControladorVistas.abrirBarManolo();
					
					//Cargamos los datos de la API al principio de la app, asi disponemos de las listas y ahorramos futuras esperas
					descargarTablaMensajes();
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	//----------------------------------------------------------------------------------------------------------------------------------------------------------


	/**
	 * Create the frame.
	 */
	public BARMANOLO() {
		
		//----------------------------------------------------------------------------------------------------------------------------------------------------------
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 566);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DESCANSAR NO ES PERDER EL TIEMPO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Montserrat", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(302, 8, 394, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("BAR MANOLO");
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 22));
		lblNewLabel.setBounds(30, 0, 217, 48);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(30, 51, 666, 462);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setFont(new Font("Montserrat", Font.BOLD, 12));
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setBackground(new Color(255, 255, 255));
		btnEntrar.setBounds(242, 344, 186, 52);
		panel.add(btnEntrar);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsuario.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblUsuario.setBounds(96, 163, 103, 15);
		panel.add(lblUsuario);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDni.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblDni.setBounds(96, 239, 103, 15);
		panel.add(lblDni);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Montserrat", Font.PLAIN, 12));
		tfUsuario.setBounds(217, 159, 283, 24);
		panel.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfDni = new JTextField();
		tfDni.setFont(new Font("Montserrat", Font.PLAIN, 12));
		tfDni.setColumns(10);
		tfDni.setBounds(217, 237, 283, 24);
		panel.add(tfDni);
		
		JLabel lblAcceso = new JLabel("ACCESO AL GESTOR");
		lblAcceso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcceso.setForeground(new Color(0, 206, 209));
		lblAcceso.setFont(new Font("Montserrat", Font.BOLD, 22));
		lblAcceso.setBounds(12, 38, 642, 67);
		panel.add(lblAcceso);
		
		JButton btnConsultaMeteorologica = new JButton("CONSULTA METEOROLOGICA");
		btnConsultaMeteorologica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorVistas.abrirTiempo();
			}
		});
		btnConsultaMeteorologica.setBackground(new Color(255, 255, 255));
		btnConsultaMeteorologica.setBounds(424, 12, 230, 25);
		panel.add(btnConsultaMeteorologica);
		
		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.setBounds(534, 525, 163, 31);
		contentPane.add(btnNewButton);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		
	//----------------------------------------------------------------------------------------------------------------------------------------------------------
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comprobarLogin()) {
					ControladorVistas.abrirGestorEmpleados();
					dispose();
				}
				else {
		            JOptionPane.showMessageDialog(null, "Datos de usuario no válidos, pruebe de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------

	public static List<mensaje_DTO> procesarJson(String jsonString) {
	    Gson gson = new Gson();

	    // Define el tipo de la lista
	    java.lang.reflect.Type listType = new TypeToken<List<mensaje_DTO>>() {}.getType();

	    // Convierte la cadena JSON en una lista de objetos Mensaje
	    List<mensaje_DTO> mensajes = gson.fromJson(jsonString, listType);
	    
	    return mensajes;
	}
	
	private boolean comprobarLogin() {
		
		empleado_DAO emp = new empleado_DAO();
		
		if(emp.buscarPorDNI(tfDni.getText())!=null) {
			
			empleado_DTO emple = emp.buscarPorDNI(tfDni.getText());
			
			if(emple.getNombre().equals(tfUsuario.getText())) {
				
				return true;
			}

		};
		
		return false;
	}
	
	public static void descargarTablaMensajes() {
        String mensajes = ConexionMensajesHorario.leerAPI("https://barmanolo.onrender.com/api/leer/mensajes"); 
        listamensajes = mensaje_DTO.deJsonAMensajes(mensajes);
        
    	mensaje_DAO m = new mensaje_DAO();
    	
    	m.vaciarTabla();
        
        for (mensaje_DTO mensa : listamensajes) {
        	
        	m.insertar(mensa);
			
		}

	}
}
