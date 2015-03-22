package com.store.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import com.store.main.StoreApplication;
import com.store.ui.dialog.AddProductDialog;
import com.store.ui.dialog.AddPurchaseProductDialog;
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
public class CheckoutFrame extends javax.swing.JFrame implements ActionListener {
	private JLabel headingLabel;
	private JLabel billingForLabel;
	private JRadioButton memberRadioButton;
	private JScrollPane itemDetailsScrollPane;
	private JButton removeProductButton;
	private JTextField loyaltyPointsTextField;
	private JTextField memberIDTextField;
	private JTextField memberNameTextField;
	private JTextPane balanceTextPane;
	private JTextPane amountTenderedTextPane;
	private JTextField pointsTextField;
	private JTextPane amountPayableTextPane;
	private JTextPane totalTextPane;
	private JButton cancelButton;
	private JTable itemsTable;
	private JScrollPane itemsTableScrollPane;
	private JPanel itemDetailsPanel;
	private JLabel discountApplicableLabel;
	private JComboBox<String> discountComboBox;
	private JLabel loyaltyPointsLabel;
	private JLabel memberIDPanel;
	private JLabel memberNameLabel;
	private JPanel memberDetailsPanel;
	private JTextField memberTextField;
	private JRadioButton allRadioButton;
	private JPanel billingForPanel;

	private StoreApplication application;
	private JButton checkoutButton;
	private JLabel balanceAmountLabel;
	private JLabel amountTenderedLabel;
	private JLabel pointsLabel;
	private JLabel amountPayableLabel;
	private JLabel totalLabel;
	private JButton addProductButton;
	private JLabel itemDetailsLabel;
	private ButtonGroup group;
	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public CheckoutFrame(StoreApplication application) {
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
				headingLabel.setText("Checkout");
				headingLabel.setBounds(363, 12, 149, 16);
			}
			{
				billingForPanel = new JPanel();
				getContentPane().add(billingForPanel);
				billingForPanel.setBounds(33, 52, 213, 96);
				billingForPanel.setLayout(null);
				billingForPanel.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				{
					billingForLabel = new JLabel();
					billingForPanel.add(billingForLabel);
					billingForLabel.setText("Billing For");
					billingForLabel.setBounds(12, 7, 153, 16);
				}
				{
					memberRadioButton = new JRadioButton();
					billingForPanel.add(memberRadioButton);
					memberRadioButton.setText("Member");
					memberRadioButton.setBounds(12, 33, 93, 20);
					memberRadioButton.setSelected(true);
				}
				{
					allRadioButton = new JRadioButton();
					billingForPanel.add(allRadioButton);
					allRadioButton.setText("All");
					allRadioButton.setBounds(132, 33, 54, 20);
				}
				{
					memberTextField = new JTextField();
					billingForPanel.add(memberTextField);
					memberTextField.setBounds(24, 62, 162, 23);
				}
			}
			{
				memberDetailsPanel = new JPanel();
				getContentPane().add(memberDetailsPanel);
				memberDetailsPanel.setBounds(344, 52, 311, 96);
				memberDetailsPanel.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				memberDetailsPanel.setLayout(null);
				{
					memberNameLabel = new JLabel();
					memberDetailsPanel.add(memberNameLabel);
					memberNameLabel.setText("Member Name");
					memberNameLabel.setBounds(13, 13, 138, 16);
				}
				{
					memberIDPanel = new JLabel();
					memberDetailsPanel.add(memberIDPanel);
					memberIDPanel.setText("Member ID");
					memberIDPanel.setBounds(13, 41, 138, 16);
				}
				{
					loyaltyPointsLabel = new JLabel();
					memberDetailsPanel.add(loyaltyPointsLabel);
					loyaltyPointsLabel.setText("Loyalty Points");
					loyaltyPointsLabel.setBounds(13, 68, 138, 16);
				}
				{
					memberNameTextField = new JTextField();
					memberDetailsPanel.add(memberNameTextField);
					memberNameTextField.setBounds(169, 7, 129, 22);
				}
				{
					memberIDTextField = new JTextField();
					memberDetailsPanel.add(memberIDTextField);
					memberIDTextField.setBounds(169, 35, 129, 22);
				}
				{
					loyaltyPointsTextField = new JTextField();
					memberDetailsPanel.add(loyaltyPointsTextField);
					loyaltyPointsTextField.setBounds(169, 62, 129, 22);
				}
			}
			{
				ComboBoxModel<String> discountComboBoxModel = 
						new DefaultComboBoxModel<String>(
								new String[] { "Item One", "Item Two" });
				discountComboBox = new JComboBox<String>();
				getContentPane().add(discountComboBox);
				discountComboBox.setModel(discountComboBoxModel);
				discountComboBox.setBounds(720, 88, 156, 30);
			}
			{
				discountApplicableLabel = new JLabel();
				getContentPane().add(discountApplicableLabel);
				discountApplicableLabel.setText("Discount Applicable");
				discountApplicableLabel.setBounds(720, 60, 177, 16);
			}
			{
				itemDetailsScrollPane = new JScrollPane();
				getContentPane().add(itemDetailsScrollPane);
				itemDetailsScrollPane.setBounds(33, 168, 896, 381);
				{
					itemDetailsPanel = new JPanel();
					itemDetailsScrollPane.setViewportView(itemDetailsPanel);
					itemDetailsPanel.setLayout(null);
					itemDetailsPanel.setSize(893, 100);
					itemDetailsPanel.setPreferredSize(new java.awt.Dimension(10, 100));
					{
						itemsTableScrollPane = new JScrollPane();
						itemDetailsPanel.add(itemsTableScrollPane);
						itemsTableScrollPane.setBounds(34, 101, 821, 157);
						{
							CustomTableModel itemsTableModel = 
									new CustomTableModel(
											null,
											new String[] { "Product ID", "Name", "Quantity", "Unit Price", "Price" });
							itemsTable = new JTable();
							itemsTableScrollPane.setViewportView(itemsTable);
							itemsTable.setModel(itemsTableModel);
							
						}
					}
					{
						itemDetailsLabel = new JLabel();
						itemDetailsPanel.add(itemDetailsLabel);
						itemDetailsLabel.setText("Item Details");
						itemDetailsLabel.setBounds(19, 13, 162, 16);
					}
					{
						addProductButton = new JButton();
						itemDetailsPanel.add(addProductButton);
						addProductButton.setText("Add Product");
						addProductButton.setBounds(31, 43, 162, 35);
					}
					{
						totalLabel = new JLabel();
						itemDetailsPanel.add(totalLabel);
						totalLabel.setText("Total");
						totalLabel.setBounds(58, 282, 119, 16);
					}
					{
						amountPayableLabel = new JLabel();
						itemDetailsPanel.add(amountPayableLabel);
						amountPayableLabel.setText("Amount Payable after Discount");
						amountPayableLabel.setBounds(58, 310, 263, 16);
					}
					{
						pointsLabel = new JLabel();
						itemDetailsPanel.add(pointsLabel);
						pointsLabel.setText("Points to Redeem");
						pointsLabel.setBounds(58, 338, 159, 16);
					}
					{
						amountTenderedLabel = new JLabel();
						itemDetailsPanel.add(amountTenderedLabel);
						amountTenderedLabel.setText("Amount Tendered");
						amountTenderedLabel.setBounds(554, 282, 119, 16);
					}
					{
						balanceAmountLabel = new JLabel();
						itemDetailsPanel.add(balanceAmountLabel);
						balanceAmountLabel.setText("Balance Amount");
						balanceAmountLabel.setBounds(554, 326, 119, 16);
					}
					{
						checkoutButton = new JButton();
						itemDetailsPanel.add(checkoutButton);
						checkoutButton.setText("Checkout and Print Receipt");
						checkoutButton.setBounds(491, 43, 188, 35);
					}
					{
						cancelButton = new JButton();
						itemDetailsPanel.add(cancelButton);
						cancelButton.setText("Cancel");
						cancelButton.setBounds(732, 43, 123, 35);
					}
					{
						totalTextPane = new JTextPane();
						itemDetailsPanel.add(totalTextPane);
						totalTextPane.setBounds(266, 277, 82, 22);
					}
					{
						amountPayableTextPane = new JTextPane();
						itemDetailsPanel.add(amountPayableTextPane);
						amountPayableTextPane.setBounds(266, 304, 82, 22);
					}
					{
						pointsTextField = new JTextField();
						itemDetailsPanel.add(pointsTextField);
						pointsTextField.setBounds(266, 332, 82, 22);
					}
					{
						amountTenderedTextPane = new JTextPane();
						itemDetailsPanel.add(amountTenderedTextPane);
						amountTenderedTextPane.setBounds(729, 276, 102, 22);
					}
					{
						balanceTextPane = new JTextPane();
						itemDetailsPanel.add(balanceTextPane);
						balanceTextPane.setBounds(729, 320, 102, 22);
					}
					{
						removeProductButton = new JButton();
						itemDetailsPanel.add(removeProductButton);
						removeProductButton.setText("Remove Product");
						removeProductButton.setBounds(260, 43, 162, 35);
					}
				}
			}
			pack();
			this.setSize(975, 600);
			group = new ButtonGroup();
			group.add(memberRadioButton);
			group.add(allRadioButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addListeners() {
		cancelButton.addActionListener(this);
		checkoutButton.addActionListener(this);
		addProductButton.addActionListener(this);
		removeProductButton.addActionListener(this);
		memberRadioButton.addActionListener(this);
		allRadioButton.addActionListener(this);
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
			
			AddPurchaseProductDialog dialog = new AddPurchaseProductDialog(this);
			dialog.pack();
			dialog.setVisible(true);
			
			
		} else if(e.getSource() == removeProductButton) {
			
		} else if(e.getSource() == checkoutButton) {
			
		} else if(e.getSource() == memberRadioButton) {
			
			memberTextField.setText("");
			memberTextField.setEditable(true);
			memberNameTextField.setEditable(true);
			memberIDTextField.setEditable(true);
			loyaltyPointsTextField.setEditable(true);
			pointsTextField.setEditable(true);
		} else if(e.getSource() == allRadioButton) {
			
			memberTextField.setText("");
			memberTextField.setEditable(false);
			memberNameTextField.setEditable(false);
			memberIDTextField.setEditable(false);
			loyaltyPointsTextField.setEditable(false);
			pointsTextField.setEditable(false);
		}
	}

	public JTable getTableModel() {
		return itemsTable;
	}

	public void setTableModel(JTable tableModel) {
		this.itemsTable = tableModel;
	}
}
