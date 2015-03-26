package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProduct = new JButton("Product");
		btnProduct.setToolTipText("Create, find or delete a product.");
		btnProduct.setBounds(158, 62, 118, 41);
		contentPane.add(btnProduct);
		
		JButton button = new JButton("Customer");
		button.setToolTipText("Create, find or delete a customer. You can also pay the balance for a customer.");
		button.setBounds(158, 114, 118, 41);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Create Sale");
		button_1.setToolTipText("Creates a new sale.");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(158, 11, 118, 40);
		contentPane.add(button_1);
		
		JButton button_3 = new JButton("Exit");
		button_3.setToolTipText("Exit the application.");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_3.setBounds(158, 209, 118, 40);
		contentPane.add(button_3);
	}
}
