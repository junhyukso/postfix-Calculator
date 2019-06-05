package gui;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonEventHandler implements ActionListener{
	
	private EventHandler ev;
	
	public ButtonEventHandler(EventHandler ev) {
		this.ev=ev;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton)e.getSource();
		String clickedName = clickedButton.getText();
		System.out.println(clickedName +" Button pressed");
		ev.handleEvent(clickedName);
	}

}
