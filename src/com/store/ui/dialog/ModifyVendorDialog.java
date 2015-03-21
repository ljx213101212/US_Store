package com.store.ui.dialog;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ModifyVendorDialog extends com.store.util.GenericTwoButtonDialog {
		
	public ModifyVendorDialog(JFrame frame) {
		super (frame, "Modify Vendor");
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
