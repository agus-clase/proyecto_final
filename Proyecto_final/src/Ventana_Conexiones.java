import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Conexiones {

	private JFrame frmOrderManagingSoftware;

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
	//			frmStockManager.setVisible(true);
			}
		});
		btnConectar_oficina.setBounds(116, 159, 141, 53);
		frmOrderManagingSoftware.getContentPane().add(btnConectar_oficina);
		
		JButton btnConectar_Almacen = new JButton("Conectar almacén");
		btnConectar_Almacen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConectar_Almacen.setBounds(351, 159, 141, 53);
		frmOrderManagingSoftware.getContentPane().add(btnConectar_Almacen);
	}
}
