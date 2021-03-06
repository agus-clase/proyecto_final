import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Almacen extends JFrame {

	private JPanel contentPane;
	
	protected final static int PORT = 5008;
	protected final static String SERVER = "localhost";
	protected ServerSocket server;
	protected Socket client;
	protected BufferedReader input;
	protected ObjectInputStream obj_input;
	protected PrintStream output;
	protected ObjectOutputStream obj_output;

	protected JTextArea textArea2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Almacen frame = new Almacen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Almacen() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformacinDelPedido = new JLabel("Información del pedido:");
		lblInformacinDelPedido.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInformacinDelPedido.setBounds(152, 30, 258, 28);
		contentPane.add(lblInformacinDelPedido);
		
		textArea2 = new JTextArea();
		textArea2.setBounds(42, 86, 505, 153);
		contentPane.add(textArea2);
		
		JButton btnNewButton2 = new JButton("Pedido Enviado");
		btnNewButton2.setBounds(42, 251, 142, 57);
		contentPane.add(btnNewButton2);
		
		JButton btnPedidoCancelado = new JButton("Pedido Cancelado");
		btnPedidoCancelado.setBounds(405, 251, 142, 57);
		contentPane.add(btnPedidoCancelado);
		
		JButton btn_comprobar = new JButton("Comprobar Stock");
		btn_comprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btn_comprobar.setBounds(208, 266, 173, 27);
		contentPane.add(btn_comprobar);
		
		try {
			this.client = new Socket(SERVER, PORT);
			this.input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			obj_input=new ObjectInputStream( new BufferedInputStream(client.getInputStream()));
			// to write to the server
			this.output = new PrintStream(client.getOutputStream());
			obj_output= new ObjectOutputStream(client.getOutputStream());
			ReadingInput t2 = new ReadingInput(input, textArea2,obj_input);
			t2.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
