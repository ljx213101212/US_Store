package com.store.main;

import com.store.ui.LoginFrame;

public class StoreApplication {

	LoginFrame loginJFrame;
	
	public StoreApplication() {
		loginJFrame = new LoginFrame(this);
		loginJFrame.setLocationRelativeTo(null);
		loginJFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		StoreApplication application = new StoreApplication();
		application.start();
	}

	private void start() {
		loginJFrame.setVisible(true);
	}

	public void shutdown() {
		System.exit(0);
	}
}
