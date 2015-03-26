package uiLayer;

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
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton productCrud = new JButton("Product");
		productCrud.setToolTipText("Create, find or delete a product.");
		productCrud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductGUI g1 = new ProductGUI();
				g1.setVisible(true);
			}
		});
		productCrud.setBounds(158, 62, 118, 41);
		contentPane.add(productCrud);
		
		JButton customerCrud = new JButton("Customer");
		customerCrud.setToolTipText("Create, find or delete a customer. You can also pay the balance for a customer.");
		customerCrud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerGUI c1 = new CustomerGUI();
				c1.setVisible(true);
			}
		});
		customerCrud.setBounds(158, 114, 118, 41);
		contentPane.add(customerCrud);
		
		JButton createSale = new JButton("Create Sale");
		createSale.setToolTipText("Creates a new sale.");
		createSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleGUI s1 = new SaleGUI();
				s1.setVisible(true);
			}
		});
		createSale.setBounds(158, 11, 118, 40);
		contentPane.add(createSale);
		
		JButton exit = new JButton("Exit");
		exit.setToolTipText("Exit the application.");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit.setBounds(158, 209, 118, 40);
		contentPane.add(exit);
	}
}
