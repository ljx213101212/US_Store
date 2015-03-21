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
import com.store.ui.dialog.AddMemberDialog;
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
public class ManageMembersFrame extends javax.swing.JFrame implements ActionListener {

	private StoreApplication application;
	private JTable memberTable;
	private JButton removeMemberButton;
	private JButton modifyMemberButton;
	private JScrollPane memberScrollPane;
	private JButton cancelButton;
	private JButton addMemberButton;
	private CustomTableModel tableModel;

	public ManageMembersFrame(StoreApplication application) {
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
				addMemberButton = new JButton();
				getContentPane().add(addMemberButton);
				addMemberButton.setText("Add New Member");
				addMemberButton.setBounds(53, 41, 151, 33);
			}
			{
				cancelButton = new JButton();
				getContentPane().add(cancelButton);
				cancelButton.setText("Cancel");
				cancelButton.setBounds(601, 41, 108, 33);
			}
			{
				memberScrollPane = new JScrollPane();
				getContentPane().add(memberScrollPane);
				memberScrollPane.setBounds(53, 113, 656, 176);
				{
					tableModel = 
							new CustomTableModel(
									new String[][] {  },
									new String[] { "Name", "ID", "Loyalty Points", "Created" });
					memberTable = new JTable();
					memberScrollPane.setViewportView(memberTable);
					memberTable.setModel(tableModel);
				}
			}
			{
				modifyMemberButton = new JButton();
				getContentPane().add(modifyMemberButton);
				modifyMemberButton.setText("Modify Member");
				modifyMemberButton.setBounds(248, 41, 135, 33);
			}
			{
				removeMemberButton = new JButton();
				getContentPane().add(removeMemberButton);
				removeMemberButton.setText("Remove Member");
				removeMemberButton.setBounds(429, 41, 135, 33);
			}
			pack();
			this.setSize(772, 362);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addListeners() {
		addMemberButton.addActionListener(this);
		cancelButton.addActionListener(this);
		removeMemberButton.addActionListener(this);
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
		} else if(e.getSource() == addMemberButton) {
			
			AddMemberDialog dialog = new AddMemberDialog(this);
			dialog.pack();
			dialog.setVisible(true);			
		} else if(e.getSource() == modifyMemberButton) {
			
			ModifyMemberDialog dialog = new ModifyMemberDialog(this);
			dialog.pack();
			dialog.setVisible(true);
		} else if(e.getSource() == removeMemberButton) {
			
			int index = memberTable.getSelectedRow();
			if(index != -1) {
				tableModel.removeRow(index);
			} else {
				GenericOKDialog dialog = new GenericOKDialog(this, "", "No Member Selected!");
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
