package com.store.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class GenericTwoButtonDialog extends JDialog implements ActionListener {

	private JButton okButton;
	private JButton cancelButton;
	
	public GenericTwoButtonDialog(JFrame parent, String title) {
		super(parent, title);
		add("Center", createFormPanel());
		add("South", createButtonPanel());
	}

	public GenericTwoButtonDialog(JFrame parent) {
		this(parent, "");
	}

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel();

		okButton = new JButton("OK");
		okButton.addActionListener(this);
		panel.add(okButton);

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		panel.add(cancelButton);

		return panel;
	}

	private void destroyDialog() {
		setVisible(false);
		dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == okButton) {
			if (performOkAction()) {
				destroyDialog();
			}
		} else if(e.getSource() == cancelButton) {
			destroyDialog();
		}
	}

	protected abstract JPanel createFormPanel();

	protected abstract boolean performOkAction();

}