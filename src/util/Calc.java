package util;

import java.util.ArrayList;
import java.util.Stack;

public class Calc {
	/*
	private static boolean isNumber(String s) {
		char [] cs = s.toCharArray();
		for(char c : cs) {
			if(!((c>=48 && c<=57) || c == 46)) {
				return false;
			}
		}
		return true;
	}
	*/
	public static boolean isNumeric(String s) {
		return s.matches("-?\\d+(\\.\\d+)?");
	}
	
	private static String operate(String s1, String s2, String operator){
		double d1 = Double.parseDouble(s1);
		double d2 = Double.parseDouble(s2);
		if(operator.equals("+")) {
			return Double.toString(d1+d2);
		}
		else if(operator.equals("-")) {
			return Double.toString(d1-d2);
		}
		else if(operator.equals("*")) {
			return Double.toString(d1*d2);
		}
		else if(operator.equals("/")) {
			return Double.toString(d1/d2);
		}
		else if(operator.equals("%")) {
			return Double.toString(d1%d2);
		}
		else {
			return "-1"; //Undefined operator error!
		}
	}
	
	public static String calculate(String[] array) {
		Stack stack = new Stack();
		for(String s : array) {
			if(isNumeric(s)) {
				stack.push(s);
			}
			else {
			  String operator = s;
			  String operand2 = (String) stack.pop(); //µÚ¿¡²¨ ¸ÕÀú»Ì±â
			  String operand1 = (String) stack.pop();
			  stack.push(operate(operand1,operand2,operator));
			}
		}
		return (String)stack.pop();
	}
}
