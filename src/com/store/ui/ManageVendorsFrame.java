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
import com.store.ui.dialog.AddVendorDialog;
import com.store.ui.dialog.ModifyVendorDialog;
import com.store.util.AppConstants;
import com.store.util.CustomTableModel;


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
public class ManageVendorsFrame extends javax.swing.JFrame implements ActionListener {

	private StoreApplication application;
	private JTable vendorsTable;
	private JButton removeVendorButton;
	private JButton modifyVendorButton;
	private JScrollPane vendorcrollPane;
	private JButton cancelButton;
	private JButton addVendorButton;

	public ManageVendorsFrame(StoreApplication application) {
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
				addVendorButton = new JButton();
				getContentPane().add(addVendorButton);
				addVendorButton.setText("Add New Vendor");
				addVendorButton.setBounds(53, 41, 151, 33);
			}
			{
				cancelButton = new JButton();
				getContentPane().add(cancelButton);
				cancelButton.setText("Cancel");
				cancelButton.setBounds(601, 41, 108, 33);
			}
			{
				vendorcrollPane = new JScrollPane();
				getContentPane().add(vendorcrollPane);
				vendorcrollPane.setBounds(53, 112, 656, 176);
				{
					CustomTableModel tableModel = 
							new CustomTableModel(
									new String[][] {  },
									new String[] { "Vendor Name", "Description" });
					vendorsTable = new JTable();
					vendorcrollPane.setViewportView(vendorsTable);
					vendorsTable.setModel(tableModel);
				}
			}
			{
				modifyVendorButton = new JButton();
				getContentPane().add(modifyVendorButton);
				modifyVendorButton.setText("Modify Vendor");
				modifyVendorButton.setBounds(248, 41, 135, 33);
			}
			{
				removeVendorButton = new JButton();
				getContentPane().add(removeVendorButton);
				removeVendorButton.setText("Remove Vendor");
				removeVendorButton.setBounds(432, 41, 125, 33);
			}
			pack();
			this.setSize(772, 362);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addListeners() {
		addVendorButton.addActionListener(this);
		cancelButton.addActionListener(this);
		modifyVendorButton.addActionListener(this);
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
		} else if(e.getSource() == addVendorButton) {
			
			AddVendorDialog dialog = new AddVendorDialog(this);
			dialog.pack();
			dialog.setVisible(true);
		} else if(e.getSource() == modifyVendorButton) {
			
			ModifyVendorDialog dialog = new ModifyVendorDialog(this);
			dialog.pack();
			dialog.setVisible(true);
		} else if(e.getSource() == removeVendorButton) {
			
		}
	}

}
