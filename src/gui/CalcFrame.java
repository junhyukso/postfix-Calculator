package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalcFrame extends JFrame {
	public CalcFrame() {
		//frame init
		super("postfix Calculator");
		this.setSize(400,350);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//basePanel
		Panel basePanel = new Panel();
		basePanel.setLayout(new BoxLayout(basePanel,BoxLayout.Y_AXIS));
		
		//CalcGraphicPanel
		CalcGraphicPanel calcGraphicPanel = new CalcGraphicPanel();
		calcGraphicPanel.setFocusable(false);
		
		//EventHandlers
		EventHandler e = new EventHandler(calcGraphicPanel);
		ButtonEventHandler b = new ButtonEventHandler(e);
		KeyEventHandler k = new KeyEventHandler(e);
		
		//CalcButtonPanel
		CalcButtonPanel calcButtonPanel = new CalcButtonPanel(b);
		calcButtonPanel.setFocusable(false);
		
		basePanel.add(calcGraphicPanel);
		basePanel.add(calcButtonPanel);
		basePanel.addKeyListener(k);
		basePanel.setFocusable(true);
		basePanel.requestFocus();
		
		this.setContentPane(basePanel);
		this.setVisible(true);
	}
}
