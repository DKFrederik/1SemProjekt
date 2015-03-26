package uiLayer;

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
import javax.swing.JCheckBox;

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
	private JCheckBox cmCheckBox;
	
	private CustomerCtr cCtr;
	private JLabel errMsg;
	private JTextField txtBalance;

	/**
	 * Create the frame.
	 */
	public CustomerGUI() {
		setTitle("Create Customer");
		
		cCtr = new CustomerCtr();
		cCtr.createCraftsman("Claus", "Jørgensen", "Vestertoften", "22164410");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel lblSalgsPris = new JLabel("ID");
		lblSalgsPris.setBounds(10, 111, 103, 14);
		contentPane.add(lblSalgsPris);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("");
		txtFirstName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				errMsg.setText("");
				txtFirstName.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				;
			}
		});
		txtFirstName.setBounds(136, 11, 263, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setText("");
		txtLastName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				errMsg.setText("");
				txtLastName.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				;
			}
		});
		txtLastName.setBounds(135, 36, 263, 20);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setText("");
		txtAddress.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				errMsg.setText("");
				txtAddress.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				;
			}
		});
		txtAddress.setBounds(136, 61, 263, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setText("");
		txtPhone.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				errMsg.setText("");
				txtPhone.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				checkPhone();
			}
		});
		txtPhone.setBounds(136, 86, 263, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setText("");
		txtId.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtId.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				;
			}
		});
		txtId.setBounds(136, 111, 263, 20);
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
		btnNewButton.setToolTipText("Create customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errMsg.setText("");
				createCustomer();
			}
		});
		btnNewButton.setBounds(244, 157, 154, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Find");
		btnNewButton_1.setToolTipText("Find customer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtPhone.getText().length() > 0)
				{
					errMsg.setText("");
					findCustomer();
				
				}
				else {
					errMsg.setText("Enter phone.");
				}
			}
		});
		btnNewButton_1.setBounds(211, 197, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnDelete = new JButton("Delete");
		btnDelete.setToolTipText("Delete product");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtId.getText().length() > 0)
				{
					errMsg.setText("");
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

		errMsg = new JLabel("");
		errMsg.setBounds(10, 231, 191, 14);
		contentPane.add(errMsg);
		
		cmCheckBox = new JCheckBox("Craftsman");
		cmCheckBox.setBounds(244, 135, 97, 23);
		contentPane.add(cmCheckBox);
		
		txtBalance = new JTextField();
		txtBalance.setEditable(false);
		txtBalance.setText("");
		txtBalance.setColumns(10);
		txtBalance.setBounds(136, 136, 98, 20);
		contentPane.add(txtBalance);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setBounds(10, 139, 103, 14);
		contentPane.add(lblBalance);
	}
	
	public void resetCustomerFields()
	{
        this.txtFirstName.setText("");
        this.txtLastName.setText("");
        this.txtAddress.setText("");
        this.txtPhone.setText("");
        this.txtId.setText("");
        
	}

	private void checkPhone()
	{
		try{
			if(txtPhone.getText().length() != 8)
			{
				txtPhone.setText("");
				errMsg.setText("Not a phone number.");
			}
		}
		catch(NumberFormatException e) {
			txtPhone.setText("");
			errMsg.setText("Not a phone number.");
		}
	}

	private void createCustomer()
	{
		if(txtFirstName.getText().length() > 0 && txtLastName.getText().length() > 0 && 
				txtPhone.getText().length() > 0 && txtAddress.getText().length() > 0) {
			if(cmCheckBox.isSelected()) {
				cCtr.createCraftsman(txtFirstName.getText(), txtLastName.getText(),  txtAddress.getText(), txtPhone.getText());
				errMsg.setText("Craftsman created!");
				txtFirstName.setText("");
				txtLastName.setText("");
				txtId.setText("");
				txtPhone.setText("");
				txtAddress.setText("");
				cmCheckBox.setSelected(false);
			}
			else {
				cCtr.createCustomer(txtFirstName.getText(), txtLastName.getText(),  txtAddress.getText(), txtPhone.getText());
				errMsg.setText("Customer created!");
				txtFirstName.setText("");
				txtLastName.setText("");
				txtId.setText("");
				txtPhone.setText("");
				txtAddress.setText("");
			}
		}
		else {
			errMsg.setText("Enter correct info");
		}	
	}

	private void deleteCustomer()
	{
			try {
				cCtr.deleteCustomer(cCtr.findCustomer(txtId.getText()));
				errMsg.setText("Customer deleted.");
			}
			catch(NullPointerException e) {
				errMsg.setText("Customer not found.");
			}
			
	}
	
	private void findCustomer()
	{
		try {
			txtFirstName.setText(cCtr.findCraftsman(txtPhone.getText()).getFirstName());
			txtLastName.setText(cCtr.findCraftsman(txtPhone.getText()).getLastName());
			txtId.setText(cCtr.findCraftsman(txtPhone.getText()).getCustomerId());
			txtPhone.setText(cCtr.findCraftsman(txtPhone.getText()).getPhone());
			txtAddress.setText(cCtr.findCraftsman(txtPhone.getText()).getAddress());
			txtBalance.setText(Double.toString(cCtr.findCraftsman(txtPhone.getText()).getBalance()));
		}
		catch(NullPointerException e) {
			try {
				txtFirstName.setText(cCtr.findCustomer(txtPhone.getText()).getFirstName());
				txtLastName.setText(cCtr.findCustomer(txtPhone.getText()).getLastName());
				txtId.setText(cCtr.findCustomer(txtPhone.getText()).getCustomerId());
				txtPhone.setText(cCtr.findCustomer(txtPhone.getText()).getPhone());
				txtAddress.setText(cCtr.findCustomer(txtPhone.getText()).getAddress());
				txtBalance.setText("Not a craftsman");
			}
			catch(NullPointerException er) {
				errMsg.setText("Customer not found.");
			}
		}		
	}
}
