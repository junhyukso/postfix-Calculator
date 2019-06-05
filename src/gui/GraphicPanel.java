package gui;

public interface GraphicPanel {
	
	//result panel
	public String getResult();
	public void setResult(String text);
	public void addResult(String s);
	public void backspaceResult();
	public void clearResult();
	public boolean isResultEmpty();
	
	//expression panel
	public String getExpression();
	public void setExpression(String expressions);
	public void clearExpression();
	
	public void clearAll();
	
}
