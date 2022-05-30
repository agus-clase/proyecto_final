import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Oficina extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nombre;
	private JTextField textField_id;
	private JTextField textField_precio;
	private JTextField textField_cantidad;
	private JTextField textField_categoria;
	
	protected final static int PORT = 5008;
	protected final static String SERVER = "localhost";
	protected ServerSocket server;
	protected Socket client;
	protected BufferedReader input;
	protected PrintStream output;
	protected JTextArea textArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Oficina frame = new Oficina();
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
	public Oficina() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(56, 86, 1173, 170);
		contentPane.add(panel);
		
		JLabel lblAadirProducto = new JLabel("Añadir pedido:");
		lblAadirProducto.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAadirProducto.setBounds(503, 12, 197, 28);
		panel.add(lblAadirProducto);
		
		textField_nombre = new JTextField();
		textField_nombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField_nombre.setColumns(10);
		textField_nombre.setBounds(53, 99, 160, 28);
		panel.add(textField_nombre);
		
		textField_id = new JTextField();
		textField_id.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField_id.setColumns(10);
		textField_id.setBounds(243, 99, 160, 28);
		panel.add(textField_id);
		
		textField_precio = new JTextField();
		textField_precio.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField_precio.setColumns(10);
		textField_precio.setBounds(432, 99, 160, 28);
		panel.add(textField_precio);
		
		textField_cantidad = new JTextField();
		textField_cantidad.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField_cantidad.setColumns(10);
		textField_cantidad.setBounds(619, 99, 160, 28);
		panel.add(textField_cantidad);
		
		textField_categoria = new JTextField();
		textField_categoria.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField_categoria.setColumns(10);
		textField_categoria.setBounds(814, 99, 160, 28);
		panel.add(textField_categoria);
		
		
		
		JButton btnEnviarPedido = new JButton("Enviar pedido");
		btnEnviarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panel = new JPanel();
				try {
				if (textField_nombre.getText().equals(null)||textField_id.getText().equals(null)||textField_precio.getText().equals(null)||
						textField_cantidad.getText().equals(null)||textField_categoria.getText().equals(null)) {
					
					
				}
				else { 
					Producto nuevo=new Producto(textField_nombre.getText(),Integer.valueOf(textField_id.getText()),
						Double.valueOf(textField_precio.getText()),Integer.valueOf(textField_cantidad.getText()),
						textField_categoria.getText());
					
					//para enviar el objeto al cliente
					String prueba=nuevo.getNombre();
					output.print(prueba);
		
					
					JOptionPane.showMessageDialog(
							panel, "Pedido enviado con éxito!", "Pedido enviado",
						   	JOptionPane.PLAIN_MESSAGE);
				}
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(panel,
							"Completa todos los campos, por favor.", "Warning",
							JOptionPane.WARNING_MESSAGE);
					
				}
			}
		});
			
		btnEnviarPedido.setBounds(998, 99, 130, 27);
		panel.add(btnEnviarPedido);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNombre.setBounds(96, 57, 83, 17);
		panel.add(lblNombre);
		
		JLabel lblCantidad = new JLabel("ID:");
		lblCantidad.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCantidad.setBounds(302, 57, 83, 17);
		panel.add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPrecio.setBounds(473, 57, 83, 17);
		panel.add(lblPrecio);
		
		JLabel lblCantidad_1 = new JLabel("Cantidad:");
		lblCantidad_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCantidad_1.setBounds(660, 57, 83, 17);
		panel.add(lblCantidad_1);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCategoria.setBounds(857, 57, 83, 17);
		panel.add(lblCategoria);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(55, 350, 1174, 343);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Ver Stock");
		
		btnNewButton.setBounds(480, 728, 105, 27);
		contentPane.add(btnNewButton);
	}
}
