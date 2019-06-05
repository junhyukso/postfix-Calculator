package gui;

import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import util.Calc;

public class EventHandler {
	
	private CalcGraphicPanel calcGraphicPanel;
	private static int numberCnt = 0;
	private static int operatorCnt = 0;
	private static Stack<String> expressionStack = new Stack<String>();
	
	public EventHandler(CalcGraphicPanel calcGraphicPanel) {
		this.calcGraphicPanel = calcGraphicPanel;
	}
	
	
	private void doEqualEvent(String s) throws Exception {
		if(operatorCnt == 0) {
			throw new Exception("OPERATOR EXCEPTION : no operator exist.");
		}
		else if(numberCnt - 1 > operatorCnt) {
			throw new Exception("OPERATOR EXCEPTION : the number of operator is too small.");
		}
		else if(numberCnt <= operatorCnt){
			throw new Exception("OPERATOR EXCEPTION : the number of operator is too large.");
		}
		else {
			String[] expressionArray = this.expressionStack.toArray(new String[this.expressionStack.size()]);
			String result = Calc.calculate(expressionArray);
			
			this.calcGraphicPanel.setResult(result);
			
			this.expressionStack.removeAllElements();
			numberCnt = 0;
			operatorCnt = 0;
			
			this.calcGraphicPanel.clearExpression();
		}
	}
	
	private void doClearEvent(String s) {
		this.expressionStack.removeAllElements();
		numberCnt = 0;
		operatorCnt = 0;
		
		this.calcGraphicPanel.clearAll();
	}
	
	private void doBackspaceEvent(String s) {
		if(this.calcGraphicPanel.isResultEmpty()) {
			if(this.expressionStack.empty()) { //if empty, DO NOTHING
				return;
			}
			String ss = this.expressionStack.pop();
			if(util.Calc.isNumeric(ss)) { //check is it number
				numberCnt--;
			}
			else {
				operatorCnt--;
			}
			
			this.calcGraphicPanel.setExpressionByStack(this.expressionStack);
		}
		else {
			
			this.calcGraphicPanel.backspaceResult();
		}
	}
	
	private void doSpaceEvent(String s) {
		
		String number = this.calcGraphicPanel.getResult();
		//Check double format by parseDouble
		//if it's not numeric,it will throw error.
		Double.parseDouble(number); 
		
		//if it's numeric..
		this.expressionStack.add(this.calcGraphicPanel.getResult());
		numberCnt++;
		
		this.calcGraphicPanel.setExpressionByStack(this.expressionStack);
		this.calcGraphicPanel.clearResult();
	}
	
	private void doNumberEvent(String s) {
		String num = s;
		
		this.calcGraphicPanel.addResult(num);
	}
	
	private void doOperatorEvent(String s) throws Exception{

		String op = s;
		
		if(this.calcGraphicPanel.isResultEmpty()) {
			if(numberCnt-operatorCnt < 2) {
				throw new Exception("OPERATOR EXCEPTION : operator needs 2 operands in leftside.");
			}
			//operator clicked AFTER space
			this.expressionStack.add(op);
			operatorCnt++;
			
			this.calcGraphicPanel.setExpressionByStack(this.expressionStack);
		}
		else {//operator clicked BEFORE space 
			if(numberCnt-operatorCnt < 1) {
				throw new Exception("OPERATOR EXCEPTION : operator needs 2 operands in leftside.");
			}
			doSpaceEvent(s);
			this.expressionStack.add(op);
			operatorCnt++;
			
			this.calcGraphicPanel.setExpressionByStack(this.expressionStack);
			this.calcGraphicPanel.clearResult();
		}
	}
	
	public void handleEvent(String s) {
		try {
			if(s == "=") { //calculate
				doEqualEvent(s);
			}
			else if(s == "C") { //Clear
				doClearEvent(s);
			}
			else if(s == "←") { //Backspace
				doBackspaceEvent(s);
			}
			else if(s == "␣") {// Next(space)
				doSpaceEvent(s);
			}
			else {
				char c = s.charAt(0);
				if((c>=48 && c<=57) || c == 46) { //0~9 or .
					doNumberEvent(s);
				}
				else {//operator
					doOperatorEvent(s);
				}
			}
		}
		catch(Exception error){
			JOptionPane.showMessageDialog(null, error.toString(), "Error",JOptionPane.WARNING_MESSAGE);
			//error.printStackTrace();
		}
	}

}
