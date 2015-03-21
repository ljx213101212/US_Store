package com.store.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
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
public class LoginFrame extends javax.swing.JFrame implements ActionListener {

	private JButton loginButton;
	private JPasswordField passwordField;
	private JLabel loginLabel;
	private JButton cancelButton;
	private JLabel passwordLabel;
	private JLabel usernameLabel;
	private JTextField usernameTextField;
	private StoreApplication application;

	public LoginFrame(StoreApplication application) {
		super(AppConstants.WINDOW_TITLE);
		this.application = application;
		initGUI();
		addListeners();
		addWindowListener(windowListener);
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				usernameTextField = new JTextField();
				getContentPane().add(usernameTextField);
				usernameTextField.setBounds(223, 92, 192, 23);
			}
			{
				usernameLabel = new JLabel();
				getContentPane().add(usernameLabel);
				usernameLabel.setText("Username");
				usernameLabel.setBounds(95, 95, 104, 16);
			}
			{
				passwordLabel = new JLabel();
				getContentPane().add(passwordLabel);
				passwordLabel.setText("Password");
				passwordLabel.setBounds(95, 142, 104, 16);
			}
			{
				passwordField = new JPasswordField();
				getContentPane().add(passwordField);
				passwordField.setBounds(223, 139, 192, 23);
			}
			{
				loginButton = new JButton();
				getContentPane().add(loginButton);
				loginButton.setText("Login");
				loginButton.setBounds(95, 206, 114, 34);
			}
			{
				loginLabel = new JLabel();
				getContentPane().add(loginLabel);
				loginLabel.setText("Login");
				loginLabel.setBounds(223, 33, 109, 16);
			}
			{
				cancelButton = new JButton();
				getContentPane().add(cancelButton);
				cancelButton.setText("Cancel");
				cancelButton.setBounds(284, 206, 113, 34);
			}
			pack();
			this.setSize(513, 313);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addListeners() {
		loginButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginButton) {
			// authenticate user
			StoreKeeperHomeFrame frame = new StoreKeeperHomeFrame(application);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			setVisible(false);
			dispose();
		} else if(e.getSource() == cancelButton) {
			setVisible(false);
			dispose();
		}
	}
	
	private WindowListener windowListener = new WindowAdapter () {
        public void windowClosing (WindowEvent e) {
            application.shutdown();
        }
    };
}
