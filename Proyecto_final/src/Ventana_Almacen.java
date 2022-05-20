import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Ventana_Almacen {

	private JFrame frm_almacen;

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
		frm_almacen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_almacen.getContentPane().setLayout(null);
		
		JLabel lblInformacinDelPedido = new JLabel("Información del pedido:");
		lblInformacinDelPedido.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInformacinDelPedido.setBounds(164, 27, 258, 28);
		frm_almacen.getContentPane().add(lblInformacinDelPedido);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(48, 76, 505, 153);
		frm_almacen.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Pedido Enviado");
		btnNewButton.setBounds(48, 260, 142, 57);
		frm_almacen.getContentPane().add(btnNewButton);
		
		JButton btnPedidoCancelado = new JButton("Pedido Cancelado");
		btnPedidoCancelado.setBounds(411, 260, 142, 57);
		frm_almacen.getContentPane().add(btnPedidoCancelado);
	}
}
