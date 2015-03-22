package com.store.ui.dialog;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.store.ui.CheckoutFrame;
import com.store.util.CustomTableModel;



public class AddPurchaseProductDialog extends
		com.store.util.GenericTwoButtonDialog {

	JFrame frame;
	public JTable table;

	public AddPurchaseProductDialog(JFrame frame) {
		super(frame, "Select Products");
		this.frame = frame;
		//this.setSize(950, 150);
		//setLocationRelativeTo(frame);
	}

	@Override
	protected JPanel createFormPanel() {
		JPanel panel = new JPanel();
		JScrollPane itemDetailsScrollPane = new JScrollPane();
		table = new JTable();
		
		//frame.getContentPane().add(table);

		//itemDetailsScrollPane = new JScrollPane();
		
		//panel.setLayout(null);
		panel.setSize(893, 100);
		{
			JScrollPane itemsTableScrollPane = new JScrollPane();
			panel.add(itemsTableScrollPane);
			CustomTableModel itemsTableModel = 
						new CustomTableModel(
								null,
								new String[] { "Product ID", "Name", "Quantity", "Unit Price"});
				itemsTableScrollPane.setViewportView(table);
				table.setModel(itemsTableModel);
		}
		
		
		/*
		CustomTableModel itemsTableModel = 
				new CustomTableModel(
						null,
						new String[] { "Product ID", "Name", "Quantity", "Unit Price", "Price" });
		table.setModel(itemsTableModel);
		itemsTableModel.addRow(new Object[]{"CLO/12", "Bikinis", "1","What is this?","25.80"});
		panel.add(table);
		*/
		panel.setLayout(new FlowLayout());
		return panel;
	}

	@Override
	protected boolean performOkAction() {
		
		/*((CheckoutFrame) frame).getTableModel().addRow(
				new Object[] { "1234", "Test", "Test", "Test", "Test", "Test",
						"Test", "Test" });
		*/
		DefaultTableModel tableModel = (DefaultTableModel) ((CheckoutFrame) frame).getTableModel().getModel();
		// test add directly
		tableModel.addRow(new Object[]{"CLO/12", "Bikinis", "1","What is this?","25.80"});
		return true;
	}

}
