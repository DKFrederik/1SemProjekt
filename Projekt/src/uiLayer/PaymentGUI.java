package uiLayer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ctrLayer.*;

public class PaymentGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox collectCheckBox;
	private JPanel contentPane;
	// private JCheckBox craftsmanCheckBox;
	private JTextField textPhone;
	private JTextField textCustomer;
	private CustomerCtr cCtr;
	// private ProductCtr pCtr;
	private SaleCtr sCtr;
	private JTextField txtCustomerType;
	private JLabel errMsg;
	
	public PaymentGUI(CustomerCtr cCtr, ProductCtr pCtr, SaleCtr sCtr) {
		
		this.cCtr = cCtr;
		// this.pCtr = pCtr;
		this.sCtr = sCtr;
		
		setTitle("Payment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomer = new JLabel("Phone");
		lblCustomer.setBounds(10, 11, 97, 14);
		getContentPane().add(lblCustomer);
		
		collectCheckBox = new JCheckBox("Picked up");
		collectCheckBox.setBounds(261, 60, 97, 23);
		contentPane.add(collectCheckBox);
		
		textPhone = new JTextField();
		textPhone.setBounds(138, 8, 286, 20);
		textPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!checkPhoneMsg())
				{
					textPhone.setText("");
					errMsg.setText("Please enter a valid phonenumber.");
				}
				else {
					checkPhone();
					errMsg.setText("");
				}
			}
		});
		getContentPane().add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblPhone = new JLabel("Customer");
		lblPhone.setBounds(10, 36, 97, 14);
		getContentPane().add(lblPhone);
		
		textCustomer = new JTextField();
		textCustomer.setBounds(138, 33, 286, 20);
		textCustomer.setEditable(false);
		textCustomer.setColumns(10);
		getContentPane().add(textCustomer);
		
		JButton btnNewButton = new JButton("Pay by credit");
		btnNewButton.setToolTipText("Pay by credit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payCredit();
			}
		});
		btnNewButton.setBounds(10, 227, 123, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setToolTipText("Go back");
		btnBack.setBounds(335, 227, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		getContentPane().add(btnBack);
		
		JButton btnPayByCash = new JButton("Pay by cash");
		btnPayByCash.setToolTipText("Pay by cash");
		btnPayByCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payCash();		
			}
		});
		btnPayByCash.setBounds(143, 227, 123, 23);
		getContentPane().add(btnPayByCash);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(10, 64, 46, 14);
		contentPane.add(lblType);
		
		txtCustomerType = new JTextField();
		txtCustomerType.setEditable(false);
		txtCustomerType.setBounds(138, 61, 86, 20);
		contentPane.add(txtCustomerType);
		txtCustomerType.setColumns(10);
		
		errMsg = new JLabel("");
		errMsg.setBounds(10, 202, 189, 14);
		contentPane.add(errMsg);
	}

	private void checkPhone()
	{
		try {
			textCustomer.setText(cCtr.findCraftsman(textPhone.getText()).getFirstName() + " " + (cCtr.findCraftsman(textPhone.getText()).getLastName()));
			textPhone.setText(cCtr.findCraftsman(textPhone.getText()).getPhone());
			txtCustomerType.setText("Craftsman");
			sCtr.setCustomer(cCtr.findCraftsman(textPhone.getText()));
		}
		catch(NullPointerException e) {
			try {
				textCustomer.setText(cCtr.findCustomer(textPhone.getText()).getFirstName() + " " + (cCtr.findCustomer(textPhone.getText()).getLastName()));
				textPhone.setText(cCtr.findCustomer(textPhone.getText()).getPhone());
				txtCustomerType.setText("Private");
				sCtr.setCustomer(cCtr.findCustomer(textPhone.getText()));
			}
			catch(NullPointerException ex) {
				//errMsg.setText("Customer not found.");
				System.out.println("err: customer not found");
				textPhone.setText("");
			}
		}
	}
	
	private void payCredit()
	{
		setCollectAtStore();
		
		if(sCtr.getCustomer() != null) {
			if(sCtr.payByCredit()) {
				sCtr.endSale();
				//Print bon
				System.out.println("Bon");
				sCtr.makeNewSale();
				dispose();
			}
			else {
				System.out.println("Not a craftsman");
			}
		}
		else {
			System.out.println("Customer not set");
		}
	}
	
	private void payCash()
	{
		setCollectAtStore();
		
		if(sCtr.getCustomer() != null) {
			PayCashGUI pc1 = new PayCashGUI(sCtr);
			pc1.setVisible(true);
		}
	}
	
	private void setCollectAtStore()
	{
		if(collectCheckBox.isSelected()) {
			sCtr.setCollect(true);
		}
		else {
			sCtr.setCollect(false);
		}
	}
	
	private boolean checkPhoneMsg()
	{
		try {
				double i = Double.parseDouble(textPhone.getText().trim());
				if(i >= 0)
			{
				return true;
			}
			else {
				return false;
			}
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
}
