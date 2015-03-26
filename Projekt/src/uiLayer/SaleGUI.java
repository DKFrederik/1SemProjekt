package uiLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import ctrLayer.*;

import javax.swing.JTable;

public class SaleGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProductName;
	private JTextField txtTotal;
	private JTextField txtAmount;
	private List list;
	private SaleCtr sCtr;
	private ProductCtr pCtr;
	private CustomerCtr cCtr;
	private JTable table;
	//private JTextField txtCustomer;
	//private JLabel errMsg;


	/**
	 * Create the frame.
	 */
	public SaleGUI() {
		cCtr = new CustomerCtr();
		pCtr = new ProductCtr();
		sCtr = new SaleCtr();

		sCtr.makeNewSale();
		
		setTitle("Create Sale");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 498, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel errMsg = new JLabel("");
		errMsg.setBounds(10, 271, 366, 14);
		contentPane.add(errMsg);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setToolTipText("Go back");
		btnNewButton.setBounds(383, 295, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sCtr.cancelSale();
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		
		JLabel lblProduct = new JLabel("Product Name / Amount");
		lblProduct.setBounds(10, 11, 120, 14);
		contentPane.add(lblProduct);
		
		txtProductName = new JTextField();
		txtProductName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				checkProduct();		
			}
		});
		txtProductName.setColumns(10);
		txtProductName.setBounds(140, 11, 236, 20);
		contentPane.add(txtProductName);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(10, 233, 103, 14);
		contentPane.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(136, 230, 336, 20);
		contentPane.add(txtTotal);
		
		list = new List();
		list.setBounds(136, 64, 336, 160);
		contentPane.add(list);
		JButton btnPayment = new JButton("Payment");
		btnPayment.setToolTipText("Continue to cashout");
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentGUI p1 = new PaymentGUI(cCtr, pCtr, sCtr);
				p1.setVisible(true);			
			}
		});
		btnPayment.setBounds(10, 295, 89, 23);
		contentPane.add(btnPayment);
		
		JButton btnAddItem = new JButton("Add item");
		btnAddItem.setToolTipText("Add item to the sale");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});
		btnAddItem.setBounds(10, 64, 120, 23);
		contentPane.add(btnAddItem);
		
		txtAmount = new JTextField();
		txtAmount.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				checkAmount();
			}

			@Override
			public void focusGained(FocusEvent e) {
				
			}
		});
		txtAmount.setBounds(383, 11, 86, 20);
		contentPane.add(txtAmount);
		txtAmount.setColumns(10);

		
		JButton btnListProducts = new JButton("List items");
		btnListProducts.setToolTipText("List all the items in store");
		btnListProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//					ListItems l1 = new ListItems();
//					l1.setVisible(true);
			}
		});
		btnListProducts.setBounds(10, 132, 120, 23);
		contentPane.add(btnListProducts);
		
		JLabel lblNewLabel = new JLabel(" Product                Amount                Price");
		lblNewLabel.setBounds(162, 42, 263, 16);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(136, 212, 89, -127);
		contentPane.add(table);
		
		JButton btnRemoveItem = new JButton("Remove item");
		btnRemoveItem.setToolTipText("Remove item for the sale");
		btnRemoveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeItem();
			}
		});
		btnRemoveItem.setBounds(10, 98, 120, 23);
		contentPane.add(btnRemoveItem);
		

		

	}
	private void addItem()
	{
		if(txtAmount.getText().length() > 0 && txtProductName.getText().length() > 0) {
			sCtr.enterItem(txtProductName.getText(), Integer.parseInt(txtAmount.getText()));
			list.add(pCtr.findItem(txtProductName.getText()).getName() + "     :     "+ txtAmount.getText());
			txtProductName.setText("");
			txtAmount.setText("");
			txtTotal.setText(Double.toString(sCtr.getPayment()));
		}
		
	}
	
	private void removeItem()
	{
		try {
			String s = list.getSelectedItem().substring(0, list.getSelectedItem().indexOf(" "));
			list.remove(list.getSelectedIndex());
			sCtr.removePartSale(s);
			if(Double.toString(sCtr.getPayment()).equals("NaN")) {
				txtTotal.setText("");
			}
			else {
			txtTotal.setText(Double.toString(sCtr.getPayment()));
			}
			
		}
		catch(NullPointerException e) {
			
		}
		catch(ArrayIndexOutOfBoundsException oe) {
			//Index out of bounds
		}
	}
	private void checkProduct()
	{
		try {
			pCtr.findItem(txtProductName.getText());
			if(txtAmount.getText().length() > 0) {
				setTotal();
			}
		}	
		catch(NullPointerException e) {
			txtProductName.setText("");
		}
	}
	private void checkAmount()
	{
		try {
			int i = Integer.parseInt(txtAmount.getText().trim());
			if(i > 0) {
				if(txtProductName.getText().length() > 0) {
					setTotal();				
				}
			}
			else {
							}
		}
		catch(NullPointerException ne) {
			txtAmount.setText("");
		}
		catch(NumberFormatException e) {
			txtAmount.setText("");
		}
		catch(IllegalArgumentException ex) {
			txtAmount.setText("");
		}
	}
	
	private void setTotal()
	{
		txtTotal.setText(Double.toString(Integer.parseInt(txtAmount.getText()) * pCtr.findItem(txtProductName.getText()).getSalesPrice()));
	}
}
