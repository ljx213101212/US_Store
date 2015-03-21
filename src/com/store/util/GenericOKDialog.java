package com.store.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GenericOKDialog extends JDialog implements ActionListener {

	private JButton okButton;
	private JLabel label;
	
	public GenericOKDialog(JFrame parent, String title, String message) {
		super(parent, title);
		label = new JLabel(message);
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		
		JPanel labelPanel = new JPanel();
		labelPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		labelPanel.add(label);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(new EmptyBorder(0, 0, 2, 0));
		buttonPanel.add(okButton);
		
		add("Center", labelPanel);
		add("South", buttonPanel);
		setLocationRelativeTo(null);
	}

	public GenericOKDialog(JFrame parent) {
		this(parent, "", "");
	}

	private void destroyDialog() {
		setVisible(false);
		dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == okButton) {
			destroyDialog();
		}
	}
}