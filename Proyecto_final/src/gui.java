import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class gui {

	private JFrame frmStockManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frmStockManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStockManager = new JFrame();
		frmStockManager.setTitle("Stock Manager");
		frmStockManager.setBounds(100, 100, 1280, 800);
		frmStockManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStockManager.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(45, 38, 1173, 170);
		frmStockManager.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAadirProducto = new JLabel("Añadir producto:");
		lblAadirProducto.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAadirProducto.setBounds(503, 12, 197, 28);
		panel.add(lblAadirProducto);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(44, 300, 1174, 343);
		frmStockManager.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Ver Stock");
		btnNewButton.setBounds(583, 686, 105, 27);
		frmStockManager.getContentPane().add(btnNewButton);
	}
}
