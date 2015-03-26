package guiLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CustomerGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtId;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnDelete;
	private JButton btnBack;
	private JButton btnCreateCraftsman;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductGUI frame = new ProductGUI();
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
	public CustomerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("First name");
		lblName.setBounds(10, 11, 103, 14);
		contentPane.add(lblName);
		
		JLabel lblId = new JLabel("Last name");
		lblId.setBounds(10, 36, 103, 14);
		contentPane.add(lblId);
		
		JLabel lblDesctiption = new JLabel("Address");
		lblDesctiption.setBounds(10, 61, 103, 14);
		contentPane.add(lblDesctiption);
		
		JLabel lblPurchasePrice = new JLabel("Phone");
		lblPurchasePrice.setBounds(10, 86, 103, 14);
		contentPane.add(lblPurchasePrice);
		
		JLabel lblSalgsPris = new JLabel("Id");
		lblSalgsPris.setBounds(10, 111, 103, 14);
		contentPane.add(lblSalgsPris);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("first name...");
		txtFirstName.setBounds(136, 11, 231, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setText("last name...");
		txtLastName.setBounds(135, 36, 232, 20);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setText("address...");
		txtAddress.setBounds(136, 61, 231, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setText("phone...");
		txtPhone.setBounds(136, 86, 231, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		txtId = new JTextField();
		txtId.setText("id...");
		txtId.setBounds(136, 111, 231, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setToolTipText("Reset text fields");
		btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                resetCustomerFields();
            }
        });
		btnReset.setBounds(223, 227, 89, 23);
		contentPane.add(btnReset);
		
		btnNewButton = new JButton("Create customer");
		btnNewButton.setToolTipText("Create product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(91, 160, 123, 36);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Find");
		btnNewButton_1.setToolTipText("Find product");
		btnNewButton_1.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnDelete = new JButton("Delete");
		btnDelete.setToolTipText("Delete product");
		btnDelete.setBounds(124, 227, 89, 23);
		contentPane.add(btnDelete);
		
		btnBack = new JButton("Back");
		btnBack.setToolTipText("Go back");
		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
		
		btnCreateCraftsman = new JButton("Create craftsman");
		btnCreateCraftsman.setToolTipText("Create product");
		btnCreateCraftsman.setBounds(223, 160, 135, 36);
		contentPane.add(btnCreateCraftsman);
	}
	
	public void resetCustomerFields()
	{
        this.txtFirstName.setText("");
        this.txtLastName.setText("");
        this.txtAddress.setText("");
        this.txtPhone.setText("");
        this.txtId.setText("");
        
	}
}
