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

public class ProductGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtDescription;
	private JTextField txtPurchasePrice;
	private JTextField txtSalesPrice;
	private JTextField txtQuantity;
	private JTextField txtQuantityDiscount;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnDelete;
	private JButton btnBack;
	private JLabel lblErrorMsg;
	private ProductCtr pCtr;
	private JButton btnList;

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
	public ProductGUI() {
		
		pCtr = new ProductCtr();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 103, 14);
		contentPane.add(lblName);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 36, 103, 14);
		contentPane.add(lblId);
		
		JLabel lblDesctiption = new JLabel("Desctiption");
		lblDesctiption.setBounds(10, 61, 103, 14);
		contentPane.add(lblDesctiption);
		
		JLabel lblPurchasePrice = new JLabel("Purchase price");
		lblPurchasePrice.setBounds(10, 86, 103, 14);
		contentPane.add(lblPurchasePrice);
		
		JLabel lblSalgsPris = new JLabel("Sales price");
		lblSalgsPris.setBounds(10, 111, 103, 14);
		contentPane.add(lblSalgsPris);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(10, 136, 103, 14);
		contentPane.add(lblQuantity);
		
		JLabel lblQuantityDiscount = new JLabel("Quantity discount");
		lblQuantityDiscount.setBounds(10, 161, 103, 14);
		contentPane.add(lblQuantityDiscount);
		
		lblErrorMsg = new JLabel("");
		lblErrorMsg.setBounds(10, 231, 188, 14);
		contentPane.add(lblErrorMsg);
		
		txtName = new JTextField();
		txtName.setText("");
		txtName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtName.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				lblErrorMsg.setText("");
			}
		});
		txtName.setBounds(136, 11, 231, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtId = new JTextField();
		txtId.setText("");
		txtId.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtId.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				lblErrorMsg.setText("");
			}
		});
		txtId.setBounds(135, 36, 232, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setText("");
		txtDescription.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtDescription.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				lblErrorMsg.setText("");
			}
		});
		txtDescription.setBounds(136, 61, 231, 20);
		contentPane.add(txtDescription);
		txtDescription.setColumns(10);
		
		txtPurchasePrice = new JTextField();
		txtPurchasePrice.setText("");
		txtPurchasePrice.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtPurchasePrice.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!checkPPrice())
				{
					txtPurchasePrice.setText("");
					lblErrorMsg.setText("Price must be a number.");
				}
				else {
					lblErrorMsg.setText("");
				}
			}
		});
		txtPurchasePrice.setBounds(136, 86, 231, 20);
		contentPane.add(txtPurchasePrice);
		txtPurchasePrice.setColumns(10);
		
		txtSalesPrice = new JTextField();
		txtSalesPrice.setText("");
		txtSalesPrice.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtSalesPrice.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!checkSPrice())
				{
					txtSalesPrice.setText("");
					lblErrorMsg.setText("Price must be a number.");
				}
				else {
					lblErrorMsg.setText("");
				}
			}
		});
		txtSalesPrice.setBounds(136, 111, 231, 20);
		contentPane.add(txtSalesPrice);
		txtSalesPrice.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setText("");
		txtQuantity.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtQuantity.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!checkQuantity())
				{
					txtQuantity.setText("");
					lblErrorMsg.setText("Quantity must be a number.");
				}
				else {
					lblErrorMsg.setText("");
				}
			}
		});
		txtQuantity.setBounds(135, 136, 232, 20);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		txtQuantityDiscount = new JTextField();
		txtQuantityDiscount.setText("");
		txtQuantityDiscount.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtQuantityDiscount.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(!checkQDiscount())
				{
					txtQuantityDiscount.setText("");
					lblErrorMsg.setText("Enter corret info.");
				}
				else {
					lblErrorMsg.setText("");
				}
			}
		});
		txtQuantityDiscount.setBounds(136, 161, 232, 20);
		contentPane.add(txtQuantityDiscount);
		txtQuantityDiscount.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setToolTipText("Reset text fields");
		btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                resetProductFields();
                lblErrorMsg.setText("");
            }
        });
		btnReset.setBounds(310, 197, 89, 23);
		contentPane.add(btnReset);
		
		btnNewButton = new JButton("Create");
		btnNewButton.setToolTipText("Create product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtName.getText().length() > 0 && txtId.getText().length() > 0 && txtDescription.getText().length() > 0  
				   && txtPurchasePrice.getText().length() > 0 && txtSalesPrice.getText().length() > 0 && txtQuantity.getText().length() > 0
				   && txtQuantityDiscount.getText().length() > 0)
				{
					lblErrorMsg.setText("Product succesfully created!");
					createProduct();
				
				}
				else {
					lblErrorMsg.setText("Enter corret info.");
				}
			}
		});
		btnNewButton.setBounds(10, 197, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Find");
		btnNewButton_1.setToolTipText("Find product");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtId.getText().length() > 0)
				{
					lblErrorMsg.setText("");
					findProduct();
				
				}
				else {
					lblErrorMsg.setText("Enter id.");
				}
			}
		});
		btnNewButton_1.setBounds(109, 197, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnDelete = new JButton("Delete");
		btnDelete.setToolTipText("Delete product");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtId.getText().length() > 0)
				{
					deleteProduct();
				}
			}
		});
		btnDelete.setBounds(211, 197, 89, 23);
		contentPane.add(btnDelete);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnBack.setToolTipText("Go back");
		btnBack.setBounds(310, 227, 89, 23);
		contentPane.add(btnBack);
		
		btnList = new JButton("List");
		btnList.setToolTipText("Views a list of all products");
		btnList.setBounds(211, 227, 89, 23);
		contentPane.add(btnList);
	}
	
	private void resetProductFields()
	{
        this.txtName.setText("");
        this.txtId.setText("");
        this.txtDescription.setText("");
        this.txtPurchasePrice.setText("");
        this.txtSalesPrice.setText("");
        this.txtQuantity.setText("");
        this.txtQuantityDiscount.setText("");
	}
	
	private boolean checkPPrice()
	{
		try {
			double i = Double.parseDouble(txtPurchasePrice.getText().trim());
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
	
	private boolean checkSPrice()
	{
		try {
				double i = Double.parseDouble(txtSalesPrice.getText().trim());
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
	
	private boolean checkQuantity()
	{
		try {
			int i = Integer.parseInt(txtQuantity.getText().trim());
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
	
	private boolean checkQDiscount()
	{
		try {
			int i = Integer.parseInt(txtQuantityDiscount.getText().trim());
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
	
	private void createProduct()
	{
		String name = txtName.getText();
		String id = txtId.getText();
		String description = txtDescription.getText();
		double purchasePrice = Double.parseDouble(txtPurchasePrice.getText().trim());
		double salesPrice = Double.parseDouble(txtSalesPrice.getText().trim());
		int quantity = Integer.parseInt(txtQuantity.getText().trim());
		int quantityDiscount = Integer.parseInt(txtQuantityDiscount.getText().trim());
		pCtr.createProduct(name, id, description, purchasePrice, salesPrice, quantity, quantityDiscount);
		
		txtName.setText("");
		txtId.setText("");
		txtDescription.setText("");
		txtPurchasePrice.setText("");
		txtSalesPrice.setText("");
		txtQuantity.setText("");
		txtQuantityDiscount.setText("");
	}
	
	private void deleteProduct()
	{
		try {
			pCtr.deleteProduct(pCtr.enterItem(txtId.getText()));
			lblErrorMsg.setText("Product deleted.");
		}
		catch(NullPointerException e) {
			lblErrorMsg.setText("Product not found.");
		}
	}
	
	private void findProduct()
	{
		try {
			txtName.setText(pCtr.enterItem(txtId.getText()).getName());
			txtId.setText(pCtr.enterItem(txtId.getText()).getId());
			txtDescription.setText(pCtr.enterItem(txtId.getText()).getDescription());
			txtPurchasePrice.setText(Double.toString(pCtr.enterItem(txtId.getText()).getPurchasePrice()));
			txtSalesPrice.setText(Double.toString(pCtr.enterItem(txtId.getText()).getSalesPrice()));
			txtQuantity.setText(Integer.toString(pCtr.enterItem(txtId.getText()).getQuantity()));
			txtQuantityDiscount.setText(Integer.toString(pCtr.enterItem(txtId.getText()).getQuantityDiscount()));
		}
		catch(NullPointerException e) {
			lblErrorMsg.setText("Product not found.");
		}
	}
	
}
