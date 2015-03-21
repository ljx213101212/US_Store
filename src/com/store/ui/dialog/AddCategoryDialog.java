package com.store.ui.dialog;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.store.ui.ManageCategoriesFrame;

public class AddCategoryDialog extends com.store.util.GenericTwoButtonDialog {
	
	JFrame frame;
	
	public AddCategoryDialog(JFrame frame) {
		super (frame, "Add Category");
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
		((ManageCategoriesFrame) frame).getTableModel().addRow(new Object[]{"1234", "Test", "Test"});
		return true;
	}

}
