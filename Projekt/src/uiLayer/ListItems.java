package uiLayer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import java.awt.Dimension;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ctrLayer.*;

import java.util.ArrayList;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ListItems extends JFrame{
	private JTable table;
	
	public ListItems() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		String[] columnNames = {"Name", "ID"};
		String[] data = {"Hammer", "1"};
		
		JTable table = new JTable(columnNames);
		table.setFillsViewportHeight(true);
		getContentPane().add(table);
		


		
		ProductCtr pCtr = new ProductCtr();	
		
	}
}
