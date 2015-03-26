package uiLayer;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import ctrLayer.*;

public class PayCashGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTotalPay;
	private SaleCtr sCtr;
	//private JButton btnNewButton_1;

	/**
	 * Create the frame.
	 */
	public PayCashGUI(SaleCtr sCtr) {
		setTitle("Cashout");
		
		this.sCtr = sCtr;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 249, 118);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(10, 11, 46, 14);
		contentPane.add(lblTotal);
		
		textTotalPay = new JTextField();
		textTotalPay.setEditable(false);
		if(Double.toString(sCtr.getPayment()).equals("NaN")) {
			textTotalPay.setText(" ");
			}
		else {
			textTotalPay.setText(Double.toString(sCtr.getPayment()));
		}
		textTotalPay.setBounds(66, 8, 131, 20);
		contentPane.add(textTotalPay);
		textTotalPay.setColumns(10);
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.setToolTipText("Register payment and end sale");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Bon");
				pay();
				closeWindows();
			}
		});
		btnNewButton.setBounds(10, 45, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setToolTipText("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(134, 45, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	
	public void closeWindows()
	{
		WindowEvent winEventClose = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winEventClose);
	}
	
	private void pay()
	{
		sCtr.makePayment(Double.parseDouble(textTotalPay.getText()));
		sCtr.endSale();
	}
	
}
