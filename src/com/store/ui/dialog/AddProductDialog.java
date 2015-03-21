package com.store.ui.dialog;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.store.ui.ManageProductsFrame;

public class AddProductDialog extends com.store.util.GenericTwoButtonDialog {
		
	JFrame frame;
	
	public AddProductDialog(JFrame frame) {
		super (frame, "Add Product");
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
		((ManageProductsFrame) frame).getTableModel().addRow(new Object[]{"1234", "Test", "Test", "Test", "Test", "Test", "Test", "Test"});
		return true;
	}

}
