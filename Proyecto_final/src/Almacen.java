import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JButton;

public class Almacen extends JFrame {

	private JPanel contentPane;
	
	protected final static int PORT = 5008;
	protected final static String SERVER = "localhost";
	protected ServerSocket server;
	protected Socket client;
	protected BufferedReader input;
	protected PrintStream output;

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
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setBounds(42, 86, 505, 153);
		contentPane.add(textArea2);
		
		JButton btnNewButton2 = new JButton("Pedido Enviado");
		btnNewButton2.setBounds(42, 251, 142, 57);
		contentPane.add(btnNewButton2);
		
		JButton btnPedidoCancelado = new JButton("Pedido Cancelado");
		btnPedidoCancelado.setBounds(405, 251, 142, 57);
		contentPane.add(btnPedidoCancelado);
		
		JButton btn_actualizar = new JButton("Actualizar");
		btn_actualizar.setBounds(245, 266, 105, 27);
		contentPane.add(btn_actualizar);
	}
}
