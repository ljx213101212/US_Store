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
import com.store.ui.dialog.AddDiscountDialog;
import com.store.ui.dialog.ModifyDiscountDialog;
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
public class ManageDiscountsFrame extends javax.swing.JFrame implements ActionListener {

	private StoreApplication application;
	private JTable discountsTable;
	private JButton removeDiscountButton;
	private JButton modifyDiscountButton;
	private JScrollPane discountScrollPane;
	private JButton cancelButton;
	private JButton addDiscountButton;
	private CustomTableModel tableModel;

	public ManageDiscountsFrame(StoreApplication application) {
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
				addDiscountButton = new JButton();
				getContentPane().add(addDiscountButton);
				addDiscountButton.setText("Add New Discount");
				addDiscountButton.setBounds(53, 41, 151, 33);
			}
			{
				cancelButton = new JButton();
				getContentPane().add(cancelButton);
				cancelButton.setText("Cancel");
				cancelButton.setBounds(601, 41, 108, 33);
			}
			{
				discountScrollPane = new JScrollPane();
				getContentPane().add(discountScrollPane);
				discountScrollPane.setBounds(35, 113, 682, 176);
				{
					tableModel = 
							new CustomTableModel(
									new String[][] {  },
									new String[] { "Discount Code", "Description", "Start Date", "Discount Period", "Discount %age", "Applicable To", "Created" });
					discountsTable = new JTable();
					discountScrollPane.setViewportView(discountsTable);
					discountsTable.setModel(tableModel);
				}
			}
			{
				modifyDiscountButton = new JButton();
				getContentPane().add(modifyDiscountButton);
				modifyDiscountButton.setText("Modify Discount");
				modifyDiscountButton.setBounds(248, 41, 135, 33);
			}
			{
				removeDiscountButton = new JButton();
				getContentPane().add(removeDiscountButton);
				removeDiscountButton.setText("Remove Discount");
				removeDiscountButton.setBounds(427, 41, 133, 33);
			}
			pack();
			this.setSize(772, 362);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addListeners() {
		addDiscountButton.addActionListener(this);
		cancelButton.addActionListener(this);
		modifyDiscountButton.addActionListener(this);
		removeDiscountButton.addActionListener(this);
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
		} else if(e.getSource() == addDiscountButton) {
			
			AddDiscountDialog dialog = new AddDiscountDialog(this);
			dialog.pack();
			dialog.setVisible(true);	
		} else if(e.getSource() == modifyDiscountButton) {
			
			ModifyDiscountDialog dialog = new ModifyDiscountDialog(this);
			dialog.pack();
			dialog.setVisible(true);	
		} else if(e.getSource() == removeDiscountButton) {
			
			int index = discountsTable.getSelectedRow();
			if(index != -1) {
				tableModel.removeRow(index);
			} else {
				GenericOKDialog dialog = new GenericOKDialog(this, "", "No Discount Selected!");
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
