package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventHandler implements KeyListener {
	
	private EventHandler ev;
	
	public KeyEventHandler(EventHandler ev) {
		this.ev = ev;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		System.out.println((int)c);
		if((48<=c&&c<=57) || (c == 46 )) { //0~9
			ev.handleEvent(String.valueOf(c));
		}
		else if((c == 43) ||  (c == 45) ||  (c == 42) ||  (c == 47) ||  (c == 37)) {// + - * / % 
			ev.handleEvent(String.valueOf(c));
		}
		else if(c == 27) { //ESC
			ev.handleEvent("C");
		}
		else if(c == 8) { //backspace
			ev.handleEvent("←");
		}
		else if(c == 10) { //enter
			ev.handleEvent("=");
		}
		else if(c == 32) {//space
			ev.handleEvent("␣");
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
