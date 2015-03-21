package com.store.ui.dialog;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ModifyProductDialog extends com.store.util.GenericTwoButtonDialog {
		
	public ModifyProductDialog(JFrame frame) {
		super (frame, "Modify Product");
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
