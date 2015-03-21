package com.store.ui.dialog;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddVendorDialog extends com.store.util.GenericTwoButtonDialog {
		
	public AddVendorDialog(JFrame frame) {
		super (frame, "Add Vendor");
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
		return true;
	}

}
