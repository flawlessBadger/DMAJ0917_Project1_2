package guilayer;

import javax.swing.JOptionPane;

public class NotificationWindow {
	
	public NotificationWindow() {
		
	}
	
	public void errorWindow(String errorMessage,String windowName) {
		JOptionPane.showMessageDialog(null,
				errorMessage,
				windowName,
			    JOptionPane.ERROR_MESSAGE);
	}
	
	public void informationWindow(String errorMessage,String windowName) {
		JOptionPane.showMessageDialog(null,
				errorMessage,
				windowName,
			    JOptionPane.INFORMATION_MESSAGE);
	}
}
