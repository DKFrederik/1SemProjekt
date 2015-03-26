package uiLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import ctrLayer.*;

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
	private JLabel lblErrorMsg;
	
	private CustomerCtr cCtr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerGUI frame = new CustomerGUI();
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
		
		cCtr = new CustomerCtr();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblErrorMsg = new JLabel("");
		lblErrorMsg.setBounds(10, 231, 254, 14);
		contentPane.add(lblErrorMsg);
		
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
		txtFirstName.setText("");
		txtFirstName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				lblErrorMsg.setText("");
				txtFirstName.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				;
			}
		});
		txtFirstName.setBounds(136, 11, 231, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setText("");
		txtLastName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				lblErrorMsg.setText("");
				txtLastName.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				;
			}
		});
		txtLastName.setBounds(135, 36, 232, 20);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setText("");
		txtAddress.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				lblErrorMsg.setText("");
				txtAddress.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				;
			}
		});
		txtAddress.setBounds(136, 61, 231, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setText("");
		txtPhone.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				lblErrorMsg.setText("");
				txtPhone.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!checkPhone())
				{
					txtPhone.setText("");
					lblErrorMsg.setText("Id must be a number.");
				}
				else {
					lblErrorMsg.setText("");
				}
			}
		});
		txtPhone.setBounds(136, 86, 231, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		txtId = new JTextField();
		txtId.setText("");
		txtId.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				lblErrorMsg.setText("");
				txtId.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				lblErrorMsg.setText("Id must be a number.");
			}
		});
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
		btnReset.setBounds(310, 197, 89, 23);
		contentPane.add(btnReset);
		
		btnNewButton = new JButton("Create customer");
		btnNewButton.setToolTipText("Create product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErrorMsg.setText("");
				createCustomer();
			}
		});
		btnNewButton.setBounds(112, 150, 123, 36);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Find");
		btnNewButton_1.setToolTipText("Find product");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtId.getText().length() > 0)
				{
					lblErrorMsg.setText("");
					findCustomer();
				
				}
				else {
					lblErrorMsg.setText("Enter id.");
				}
			}
		});
		btnNewButton_1.setBounds(10, 197, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnDelete = new JButton("Delete");
		btnDelete.setToolTipText("Delete product");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtId.getText().length() > 0)
				{
					lblErrorMsg.setText("");
					deleteCustomer();
				}
			}
		});
		btnDelete.setBounds(112, 197, 89, 23);
		contentPane.add(btnDelete);
		
		btnBack = new JButton("Back");
		btnBack.setToolTipText("Go back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnBack.setBounds(310, 227, 89, 23);
		contentPane.add(btnBack);
		
		btnCreateCraftsman = new JButton("Create craftsman");
		btnCreateCraftsman.setToolTipText("Create product");
		btnCreateCraftsman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCraftsman();
			}
		});
		btnCreateCraftsman.setBounds(264, 150, 135, 36);
		contentPane.add(btnCreateCraftsman);
		
		JButton btnList = new JButton("List");
		btnList.setToolTipText("View a list of all customers");
		btnList.setBounds(211, 197, 89, 23);
		contentPane.add(btnList);
		
		
		
	}
	
	public void resetCustomerFields()
	{
        this.txtFirstName.setText("");
        this.txtLastName.setText("");
        this.txtAddress.setText("");
        this.txtPhone.setText("");
        this.txtId.setText("");
        
	}


	private boolean checkPhone()
	{
		try{
			int i = Integer.parseInt(txtPhone.getText());
			if(txtPhone.getText().length() != 8)
			{
				txtPhone.setText("");
				lblErrorMsg.setText("Not a phone number.");
				return true;
			}
			else {
				
				return false;
			}
		}
		catch(NumberFormatException e) {
			txtPhone.setText("");
			lblErrorMsg.setText("Not a phone number.");
			return false;
		}
	}

	private void createCustomer()
	{
		if(txtFirstName.getText().length() > 0 && txtLastName.getText().length() > 0 && txtId.getText().length() > 0 && 
				txtPhone.getText().length() > 0 && txtAddress.getText().length() > 0) {
			cCtr.createCustomer(txtFirstName.getText(), txtLastName.getText(),  txtAddress.getText(), txtPhone.getText(), txtId.getText());
			lblErrorMsg.setText("Customer created!");
			txtFirstName.setText("");
			txtLastName.setText("");
			txtId.setText("");
			txtPhone.setText("");
			txtAddress.setText("");
		}
		else {
			lblErrorMsg.setText("Enter correct info.");
		}
	}
	
	private void createCraftsman()
	{
		if(txtFirstName.getText().length() > 0 && txtLastName.getText().length() > 0 && txtId.getText().length() > 0 && 
				txtPhone.getText().length() > 0 && txtAddress.getText().length() > 0) {
			cCtr.createCraftsman(txtFirstName.getText(), txtLastName.getText(),  txtAddress.getText(), txtPhone.getText(), txtId.getText());
			lblErrorMsg.setText("Craftsman created!");
			txtFirstName.setText("");
			txtLastName.setText("");
			txtId.setText("");
			txtPhone.setText("");
			txtAddress.setText("");
		}
		else {
			lblErrorMsg.setText("Enter correct info.");
		}		
	}
	
	private void deleteCustomer()
	{
			try {
				cCtr.deleteCustomer(cCtr.findCustomer(txtId.getText()));
				lblErrorMsg.setText("Customer deleted.");
			}
			catch(NullPointerException e) {
				lblErrorMsg.setText("Customer not found.");
			}
			
	}
	
	private void findCustomer()
	{
		try {
			txtFirstName.setText(cCtr.findCustomer(txtId.getText()).getFirstName());
			txtLastName.setText(cCtr.findCustomer(txtId.getText()).getLastName());
			txtId.setText(cCtr.findCustomer(txtId.getText()).getCustomerId());
			txtPhone.setText(cCtr.findCustomer(txtId.getText()).getPhone());
			txtAddress.setText(cCtr.findCustomer(txtId.getText()).getAddress());
		}
		catch(NullPointerException e) {
			lblErrorMsg.setText("Customer not found.");
		}
	}
}
