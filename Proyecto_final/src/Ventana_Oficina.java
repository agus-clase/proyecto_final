import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Oficina {

	private JFrame frm_oficina;
	private JTextField textField_nombre;
	private JTextField textField_id;
	private JTextField textField_precio;
	private JTextField textField_cantidad;
	private JTextField textField_categoria;
	private JButton btnEnviarPedido;
	private JLabel lblNombre;
	private JLabel lblCantidad;
	private JLabel lblPrecio;
	private JLabel lblCantidad_1;
	private JLabel lblCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Oficina window = new Ventana_Oficina();
					window.frm_oficina.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana_Oficina() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm_oficina = new JFrame();
		frm_oficina.setTitle("Stock Manager");
		frm_oficina.setBounds(100, 100, 1280, 800);
		frm_oficina.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_oficina.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(45, 38, 1173, 170);
		frm_oficina.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAadirProducto = new JLabel("Añadir pedido:");
		lblAadirProducto.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAadirProducto.setBounds(503, 12, 197, 28);
		panel.add(lblAadirProducto);
		
		textField_nombre = new JTextField();
		textField_nombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField_nombre.setBounds(53, 99, 160, 28);
		panel.add(textField_nombre);
		textField_nombre.setColumns(10);
		
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
		
		btnEnviarPedido = new JButton("Enviar pedido");
		btnEnviarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panel1 = new JPanel();
				try {
				if (textField_nombre.getText().equals(null)||textField_id.getText().equals(null)||textField_precio.getText().equals(null)||
						textField_cantidad.getText().equals(null)||textField_categoria.getText().equals(null)) {
					
					
				}
				else { 
					Producto nuevo=new Producto(textField_nombre.getText(),Integer.valueOf(textField_id.getText()),
						Double.valueOf(textField_precio.getText()),Integer.valueOf(textField_cantidad.getText()),
						textField_categoria.getText());
					
					JOptionPane.showMessageDialog(
							panel1, "Pedido enviado con éxito!", "Pedido enviado",
						   	JOptionPane.PLAIN_MESSAGE);
				}
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(panel1,
							"Completa todos los campos, por favor.", "Warning",
							JOptionPane.WARNING_MESSAGE);
					
				}
			}
		});
		btnEnviarPedido.setBounds(998, 99, 130, 27);
		panel.add(btnEnviarPedido);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNombre.setBounds(96, 57, 83, 17);
		panel.add(lblNombre);
		
		lblCantidad = new JLabel("ID:");
		lblCantidad.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCantidad.setBounds(302, 57, 83, 17);
		panel.add(lblCantidad);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPrecio.setBounds(473, 57, 83, 17);
		panel.add(lblPrecio);
		
		lblCantidad_1 = new JLabel("Cantidad:");
		lblCantidad_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCantidad_1.setBounds(660, 57, 83, 17);
		panel.add(lblCantidad_1);
		
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCategoria.setBounds(857, 57, 83, 17);
		panel.add(lblCategoria);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(44, 300, 1174, 343);
		frm_oficina.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Ver Stock");
		btnNewButton.setBounds(583, 686, 105, 27);
		frm_oficina.getContentPane().add(btnNewButton);
	}
}
