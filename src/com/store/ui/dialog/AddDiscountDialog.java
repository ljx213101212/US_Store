package com.store.ui.dialog;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.store.ui.ManageDiscountsFrame;

public class AddDiscountDialog extends com.store.util.GenericTwoButtonDialog {
		
	JFrame frame;
	
	public AddDiscountDialog(JFrame frame) {
		super (frame, "Add Discount");
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
		((ManageDiscountsFrame) frame).getTableModel().addRow(new Object[]{"1234", "Test", "Test", "Test", "Test", "Test", "Test"});
		return true;
	}

}
