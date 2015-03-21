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
import com.store.ui.dialog.AddCategoryDialog;
import com.store.ui.dialog.ModifyCategoryDialog;
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
public class ManageCategoriesFrame extends javax.swing.JFrame implements ActionListener {
	
	private StoreApplication application;
	private JButton modifyCategoryButton;
	private JButton removeCategoryButton;
	private JTable categoryTable;
	private JScrollPane categoryScrollPane;
	private JButton cancelButton;
	private JButton addCategoryButton;
	private CustomTableModel tableModel;

	public ManageCategoriesFrame(StoreApplication application) {
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
				addCategoryButton = new JButton();
				getContentPane().add(addCategoryButton);
				addCategoryButton.setText("Add New Category");
				addCategoryButton.setBounds(24, 46, 151, 33);
			}
			{
				cancelButton = new JButton();
				getContentPane().add(cancelButton);
				cancelButton.setText("Cancel");
				cancelButton.setBounds(613, 46, 108, 33);
			}
			{
				categoryScrollPane = new JScrollPane();
				getContentPane().add(categoryScrollPane);
				categoryScrollPane.setBounds(68, 113, 613, 191);
				{
					tableModel = 
							new CustomTableModel(
									new String[][] {  },
									new String[] { "Code", "Name", "Created" });
					categoryTable = new JTable();
					categoryScrollPane.setViewportView(categoryTable);
					categoryTable.setModel(tableModel);
				}
			}
			{
				removeCategoryButton = new JButton();
				getContentPane().add(removeCategoryButton);
				removeCategoryButton.setText("Remove Category");
				removeCategoryButton.setBounds(227, 46, 139, 33);
			}
			{
				modifyCategoryButton = new JButton();
				getContentPane().add(modifyCategoryButton);
				modifyCategoryButton.setText("Modify Category");
				modifyCategoryButton.setBounds(420, 46, 137, 33);
			}
			pack();
			this.setSize(772, 362);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addListeners() {
		addCategoryButton.addActionListener(this);
		cancelButton.addActionListener(this);
		modifyCategoryButton.addActionListener(this);
		removeCategoryButton.addActionListener(this);
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
		} else if(e.getSource() == addCategoryButton) {
			
			AddCategoryDialog dialog = new AddCategoryDialog(this);
			dialog.pack();
			dialog.setVisible(true);			
		} else if(e.getSource() == modifyCategoryButton) {
			
			ModifyCategoryDialog dialog = new ModifyCategoryDialog(this);
			dialog.pack();
			dialog.setVisible(true);
		} else if(e.getSource() == removeCategoryButton) {
			
			int index = categoryTable.getSelectedRow();
			if(index != -1) {
				tableModel.removeRow(index);
			} else {
				GenericOKDialog dialog = new GenericOKDialog(this, "", "No Category Selected!");
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
