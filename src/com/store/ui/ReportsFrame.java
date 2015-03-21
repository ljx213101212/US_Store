package com.store.ui;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
public class ReportsFrame extends javax.swing.JFrame {
	private JComboBox<String> reportTypeComboBox;
	private JLabel reportTypeLabel;
	private JTextField fromDayField;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JTextField fromYearField;
	private JTextField fromMonthField;
	private JLabel jLabel1;
	private JLabel fromDateLabel;
	private StoreApplication application;
	
	public ReportsFrame(StoreApplication application) {
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
				ComboBoxModel<String> reportTypeComboBoxModel = 
						new DefaultComboBoxModel<String>(
								new String[] { "Item One", "Item Two" });
				reportTypeComboBox = new JComboBox<String>();
				getContentPane().add(reportTypeComboBox);
				reportTypeComboBox.setModel(reportTypeComboBoxModel);
				reportTypeComboBox.setBounds(140, 58, 154, 34);
			}
			{
				reportTypeLabel = new JLabel();
				getContentPane().add(reportTypeLabel);
				reportTypeLabel.setText("Report Type");
				reportTypeLabel.setBounds(47, 67, 93, 16);
			}
			{
				fromDateLabel = new JLabel();
				getContentPane().add(fromDateLabel);
				fromDateLabel.setText("From Date (dd-mm-yyyy):");
				fromDateLabel.setBounds(345, 67, 154, 16);
			}
			{
				fromDayField = new JTextField();
				getContentPane().add(fromDayField);
				fromDayField.setBounds(511, 64, 29, 23);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("-");
				jLabel1.setBounds(552, 67, 13, 16);
			}
			{
				fromMonthField = new JTextField();
				getContentPane().add(fromMonthField);
				fromMonthField.setBounds(570, 64, 28, 23);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("-");
				jLabel2.setBounds(604, 67, 14, 16);
			}
			{
				fromYearField = new JTextField();
				getContentPane().add(fromYearField);
				fromYearField.setBounds(617, 64, 62, 23);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("To Date (dd-mm-yyyy):");
				jLabel3.setBounds(345, 120, 154, 16);
			}
			pack();
			this.setSize(923, 574);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addListeners() {
		
	}
	
	private WindowListener windowListener = new WindowAdapter () {
        public void windowClosing (WindowEvent e) {
            application.shutdown();
        }
    };
}
