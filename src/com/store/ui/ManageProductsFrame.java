package com.store.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import com.store.main.StoreApplication;
import com.store.ui.dialog.AddProductDialog;
import com.store.ui.dialog.ModifyMemberDialog;
import com.store.util.AppConstants;
import com.store.util.CustomTableModel;
import com.store.util.GenericOKDialog;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ManageProductsFrame extends javax.swing.JFrame implements ActionListener {

	private StoreApplication application;
	private JTable productTable;
	private JButton removeProductButton;
	private JButton modifyProductButton;
	private JScrollPane productScrollPane;
	private JButton cancelButton;
	private JButton addProductButton;
	private CustomTableModel tableModel;
		
	public ManageProductsFrame(StoreApplication application) {
		super(AppConstants.WINDOW_TITLE);
		initGUI();
		addListeners();
		this.application = application;
		addWindowListener(windowListener);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				addProductButton = new JButton();
				getContentPane().add(addProductButton);
				addProductButton.setText("Add New Product");
				addProductButton.setBounds(53, 41, 151, 33);
			}
			{
				cancelButton = new JButton();
				getContentPane().add(cancelButton);
				cancelButton.setText("Cancel");
				cancelButton.setBounds(601, 41, 108, 33);
			}
			{
				productScrollPane = new JScrollPane();
				getContentPane().add(productScrollPane);
				productScrollPane.setBounds(53, 113, 656, 176);
				{
					tableModel = 
							new CustomTableModel(
									new String[][] {  },
									new String[] { "ID", "Name", "Description", "Quantity", "Price", "Barcode No.", "Threshold", "Order Qty" });
					productTable = new JTable();
					productScrollPane.setViewportView(productTable);
					productTable.setModel(tableModel);
				}
			}
			{
				modifyProductButton = new JButton();
				getContentPane().add(modifyProductButton);
				modifyProductButton.setText("Modify Product");
				modifyProductButton.setBounds(248, 41, 135, 33);
			}
			{
				removeProductButton = new JButton();
				getContentPane().add(removeProductButton);
				removeProductButton.setText("Remove Product");
				removeProductButton.setBounds(422, 41, 143, 33);
			}
			pack();
			this.setSize(772, 362);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addListeners() {
		addProductButton.addActionListener(this);
		cancelButton.addActionListener(this);
		modifyProductButton.addActionListener(this);
		removeProductButton.addActionListener(this);
	}
	
	private WindowListener windowListener = new WindowAdapter () {
        public void windowClosing (WindowEvent e) {
            application.shutdown();
        }
    };
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelButton) {
			StoreKeeperHomeFrame frame = new StoreKeeperHomeFrame(application);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			setVisible(false);
			dispose();
		} else if(e.getSource() == addProductButton) {
			
			AddProductDialog dialog = new AddProductDialog(this);
			dialog.pack();
			dialog.setVisible(true);
		} else if(e.getSource() == modifyProductButton) {
			
			ModifyMemberDialog dialog = new ModifyMemberDialog(this);
			dialog.pack();
			dialog.setVisible(true);
		} else if(e.getSource() == removeProductButton) {
			
			int index = productTable.getSelectedRow();
			if(index != -1) {
				tableModel.removeRow(index);
			} else {
				GenericOKDialog dialog = new GenericOKDialog(this, "", "No Product Selected!");
				dialog.pack();
				dialog.setVisible(true);
			}
		}
	}

	public CustomTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(CustomTableModel tableModel) {
		this.tableModel = tableModel;
	}
}
