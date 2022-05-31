import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Ventana_Almacen {

	private JFrame frm_almacen;
	
	protected int port;
	protected Socket server;
	private BufferedReader input;
	private PrintStream output;

	public Ventana_Almacen(int port,Socket server,BufferedReader input,PrintStream output) {
		this.port=port;
		this.server=server;
		this.input=input;
		this.output=output;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Almacen window = new Ventana_Almacen();
					window.frm_almacen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana_Almacen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm_almacen = new JFrame();
		frm_almacen.setBounds(100, 100, 600, 380);
		// frm_almacen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_almacen.getContentPane().setLayout(null);
		
		JLabel lblInformacinDelPedido = new JLabel("Información del pedido:");
		lblInformacinDelPedido.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInformacinDelPedido.setBounds(164, 27, 258, 28);
		frm_almacen.getContentPane().add(lblInformacinDelPedido);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setBounds(48, 76, 505, 153);
		frm_almacen.getContentPane().add(textArea2);
		
		
		
		JButton btnNewButton2 = new JButton("Pedido Enviado");
		btnNewButton2.setBounds(48, 260, 142, 57);
		frm_almacen.getContentPane().add(btnNewButton2);
		
		JButton btnPedidoCancelado = new JButton("Pedido Cancelado");
		btnPedidoCancelado.setBounds(411, 260, 142, 57);
		frm_almacen.getContentPane().add(btnPedidoCancelado);
		
		JButton btn_actualizar = new JButton("Actualizar");
		btn_actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				;
				try {
					String p = input.readLine();
					textArea2.append(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btn_actualizar.setBounds(258, 275, 105, 27);
		frm_almacen.getContentPane().add(btn_actualizar);
	}
}
