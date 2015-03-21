package com.store.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import com.store.main.StoreApplication;
import com.store.util.AppConstants;


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
public class StoreKeeperHomeFrame extends JFrame implements ActionListener {
	private JLabel headingLabel;
	private JButton checkoutButton;
	private JButton manageMembersButton;
	private JButton reportsButton;
	private JButton manageVendorsButton;
	private JButton manageCategoriesButton;
	private JButton manageProductsButton;
	private StoreApplication application;
	private JButton logoutButton;
	private JButton manageDiscountsButton;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public StoreKeeperHomeFrame(StoreApplication application) {
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
				headingLabel = new JLabel();
				getContentPane().add(headingLabel);
				headingLabel.setText("Welcome");
				headingLabel.setBounds(277, 19, 110, 16);
			}
			{
				checkoutButton = new JButton();
				getContentPane().add(checkoutButton);
				checkoutButton.setText("Checkout");
				checkoutButton.setBounds(24, 77, 158, 37);
			}
			{
				manageProductsButton = new JButton();
				getContentPane().add(manageProductsButton);
				manageProductsButton.setText("Manage Products");
				manageProductsButton.setBounds(225, 77, 174, 37);
			}
			{
				manageMembersButton = new JButton();
				getContentPane().add(manageMembersButton);
				manageMembersButton.setText("Manage Members");
				manageMembersButton.setBounds(452, 76, 170, 38);
			}
			{
				manageCategoriesButton = new JButton();
				getContentPane().add(manageCategoriesButton);
				manageCategoriesButton.setText("Manage Categories");
				manageCategoriesButton.setBounds(24, 168, 158, 40);
			}
			{
				manageVendorsButton = new JButton();
				getContentPane().add(manageVendorsButton);
				manageVendorsButton.setText("Manage Vendors");
				manageVendorsButton.setBounds(225, 168, 174, 40);
			}
			{
				reportsButton = new JButton();
				getContentPane().add(reportsButton);
				reportsButton.setText("Reports");
				reportsButton.setBounds(24, 243, 158, 40);
			}
			{
				manageDiscountsButton = new JButton();
				getContentPane().add(manageDiscountsButton);
				manageDiscountsButton.setText("Manage Discounts");
				manageDiscountsButton.setBounds(452, 168, 170, 36);
			}
			{
				logoutButton = new JButton();
				getContentPane().add(logoutButton);
				logoutButton.setText("Logout");
				logoutButton.setBounds(225, 245, 174, 36);
			}
			pack();
			this.setSize(655, 352);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void addListeners() {
		checkoutButton.addActionListener(this);
		manageMembersButton.addActionListener(this);
		reportsButton.addActionListener(this);
		manageVendorsButton.addActionListener(this);
		manageCategoriesButton.addActionListener(this);
		manageProductsButton.addActionListener(this);
		manageDiscountsButton.addActionListener(this);
		logoutButton.addActionListener(this);
	}
	
	private WindowListener windowListener = new WindowAdapter () {
        public void windowClosing (WindowEvent e) {
            application.shutdown();
        }
    };

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame;
		
		if(e.getSource() == manageMembersButton) {
			frame = new ManageMembersFrame(application);
		} else if(e.getSource() == reportsButton) {
			frame = new ReportsFrame(application);
		} else if(e.getSource() == manageVendorsButton) {
			frame = new ManageVendorsFrame(application);
		} else if(e.getSource() == manageCategoriesButton) {
			frame = new ManageCategoriesFrame(application);
		} else if(e.getSource() == manageProductsButton) {
			frame = new ManageProductsFrame(application);
		} else if(e.getSource() == manageDiscountsButton) {
			frame = new ManageDiscountsFrame(application);
		} else if(e.getSource() == checkoutButton) {
			frame = new CheckoutFrame(application);			
		} else if(e.getSource() == logoutButton) {
			frame = new LoginFrame(application);
		} else {
			return;
		}
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		dispose();
	}
}
