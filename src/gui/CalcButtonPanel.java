package gui;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalcButtonPanel extends Panel {
	
	private ActionListener a;
	
	public CalcButtonPanel(ActionListener a) {
		super();
		this.a = a;
		
		this.setLayout(new GridLayout(5,4));
		
		String[] buttonNames = {"=","C","←","+","7","8","9","-","4","5","6","*","1","2","3","/",".","0","␣","%"};
		for(String buttonName : buttonNames) {
			JButton b = new JButton(buttonName);
			b.addActionListener(a);
			b.setFocusable(false);
			this.add(b);
		}
	}

}