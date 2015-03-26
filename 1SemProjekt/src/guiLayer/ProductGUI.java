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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		txtName = new JTextField();
		txtName.setText("name...");
		txtName.setBounds(136, 11, 231, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtId = new JTextField();
		txtId.setText("id...");
		txtId.setBounds(135, 36, 232, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setText("description...");
		txtDescription.setBounds(136, 61, 231, 20);
		contentPane.add(txtDescription);
		txtDescription.setColumns(10);
		
		txtPurchasePrice = new JTextField();
		txtPurchasePrice.setText("purchase price..");
		txtPurchasePrice.setBounds(136, 86, 231, 20);
		contentPane.add(txtPurchasePrice);
		txtPurchasePrice.setColumns(10);
		
		txtSalesPrice = new JTextField();
		txtSalesPrice.setText("sales price...");
		txtSalesPrice.setBounds(136, 111, 231, 20);
		contentPane.add(txtSalesPrice);
		txtSalesPrice.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setText("quantity...");
		txtQuantity.setBounds(135, 136, 232, 20);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		txtQuantityDiscount = new JTextField();
		txtQuantityDiscount.setText("quantity discount...");
		txtQuantityDiscount.setBounds(136, 161, 232, 20);
		contentPane.add(txtQuantityDiscount);
		txtQuantityDiscount.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setToolTipText("Reset text fields");
		btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                resetProductFields();
            }
        });
		btnReset.setBounds(227, 227, 89, 23);
		contentPane.add(btnReset);
		
		btnNewButton = new JButton("Create");
		btnNewButton.setToolTipText("Create product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(136, 197, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Find");
		btnNewButton_1.setToolTipText("Find product");
		btnNewButton_1.setBounds(227, 197, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnDelete = new JButton("Delete");
		btnDelete.setToolTipText("Delete product");
		btnDelete.setBounds(317, 197, 89, 23);
		contentPane.add(btnDelete);
		
		btnBack = new JButton("Back");
		btnBack.setToolTipText("Go back");
		btnBack.setBounds(317, 227, 89, 23);
		contentPane.add(btnBack);
	}
	
	public void resetProductFields()
	{
        this.txtName.setText("");
        this.txtId.setText("");
        this.txtDescription.setText("");
        this.txtPurchasePrice.setText("");
        this.txtSalesPrice.setText("");
        this.txtQuantity.setText("");
        this.txtQuantityDiscount.setText("");
	}
}
