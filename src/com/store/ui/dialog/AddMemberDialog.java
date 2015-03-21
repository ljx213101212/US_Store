package com.store.ui.dialog;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.store.ui.ManageMembersFrame;

public class AddMemberDialog extends com.store.util.GenericTwoButtonDialog {
	
	JFrame frame;
	
	public AddMemberDialog(JFrame frame) {
		super (frame, "Add Member");
		this.frame = frame;
		setLocationRelativeTo(null);
	}

	@Override
	protected JPanel createFormPanel() {
		JPanel panel = new JPanel ();
        panel.setLayout (new GridLayout (0, 2));
        return panel;
	}

	@Override
	protected boolean performOkAction() {
		((ManageMembersFrame) frame).getTableModel().addRow(new Object[]{"Test", "Test", "Test", "Test"});
		return true;
	}

}
