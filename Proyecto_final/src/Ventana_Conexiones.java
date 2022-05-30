import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Ventana_Conexiones {

	private JFrame frmOrderManagingSoftware;
	private final static int PORT = 5008;
	private final static String SERVER = "localhost";
	private ServerSocket server;
	private Socket client;
	private BufferedReader input;
	private PrintStream output;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Conexiones window = new Ventana_Conexiones();
					window.frmOrderManagingSoftware.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana_Conexiones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmOrderManagingSoftware = new JFrame();
		frmOrderManagingSoftware.setTitle("Order Managing Software v1.0");
		frmOrderManagingSoftware.setBounds(100, 100, 600, 380);
		frmOrderManagingSoftware.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOrderManagingSoftware.getContentPane().setLayout(null);
		
		JButton btnConectar_oficina = new JButton("Conectar Oficina");
		btnConectar_oficina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				try {
					
					Oficina ofi=new Oficina();
					ofi.setVisible(true);
					
					ofi.server = new ServerSocket(PORT);
					ofi.client = server.accept();
					// setSoLinger closes the socket giving 10mS to receive the remaining data
					ofi.client.setSoLinger(true, 10);
					input = new BufferedReader(new InputStreamReader(client.getInputStream()));
					// to print data out
					output = new PrintStream(client.getOutputStream());
					

			
					ReadingInput t = new ReadingInput(input, ofi.textArea);
					t.start();

					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnConectar_oficina.setBounds(116, 159, 141, 53);
		frmOrderManagingSoftware.getContentPane().add(btnConectar_oficina);
		
		JButton btnConectar_Almacen = new JButton("Conectar almacén");
		btnConectar_Almacen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Almacen alm=new Almacen();
				alm.setVisible(true);
				alm.client = new Socket(SERVER, PORT);// open socket
				// To read from the server

				input = new BufferedReader(new InputStreamReader(client.getInputStream()));
				// to write to the server
				output = new PrintStream(client.getOutputStream());
		
			ReadingInput t = new ReadingInput(input, alm.textArea2);
				t.start();
				
			
				
				
				
			}
				catch (IOException ex) {
					
				}
			}
		});
		btnConectar_Almacen.setBounds(351, 159, 141, 53);
		frmOrderManagingSoftware.getContentPane().add(btnConectar_Almacen);
		
		JButton btnCerrar = new JButton("Cerrar conexión");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					server.close();
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnCerrar.setBounds(244, 248, 141, 53);
		frmOrderManagingSoftware.getContentPane().add(btnCerrar);
		
		
	}
	}

