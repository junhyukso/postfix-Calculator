package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CalcGraphicPanel extends JPanel implements GraphicPanel{
	private JLabel expressionLabel = new JLabel();
	private JLabel resultLabel = new JLabel();
	
	public CalcGraphicPanel() {
		super();
		//this.setPreferredSize(new Dimension(500,100));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		Panel p1 = new Panel();
		Panel p2 = new Panel();

		p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		expressionLabel.setFont(new Font(this.getFont().getName(),Font.ITALIC,20));
		resultLabel.setFont(new Font(this.getFont().getName(),Font.PLAIN,30));
		
		p1.add(expressionLabel);
		p2.add(resultLabel);
		
		this.add(p1);
		this.add(p2);
	}
	
	//result panel
	@Override
	public String getResult() {
		return this.resultLabel.getText();
	}
	@Override
	public void setResult(String text) {
		this.resultLabel.setText(text);
	}
	@Override
	public void addResult(String s) {
		this.setResult(this.getResult()+s);
	}
	@Override
	public void backspaceResult() {
		String nowResult = this.getResult();
		this.setResult(nowResult.substring(0, nowResult.length()-1));
	}
	@Override
	public void clearResult() {
		this.setResult("");
	}
	@Override
	public boolean isResultEmpty() {
		if(this.getResult().length() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//expression Panel
	@Override
	public String getExpression() {
		return this.expressionLabel.getText();
	}
	@Override
	public void setExpression(String expressions) {
		this.expressionLabel.setText(expressions);
	}
	@Override
	public void clearExpression() {
		this.setExpression("");
	}
	
	public void setExpressionByStack(Stack<String> stack) {
		StringBuffer sb = new StringBuffer();
		for(String s : stack) {
			sb.append(s);
			sb.append(" ");
		}
		this.setExpression(sb.toString());
	}
	//
	@Override
	public void clearAll() {
		this.clearResult();
		this.clearExpression();
	}
}
