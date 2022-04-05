package introduction;

public class Calculator {
	private String operation;
	
	public Calculator(String operation) {
		this.operation = operation;
	}
	
	public String getSquare() {
		double result = 0.0;
		try {
			result = Double.parseDouble(operation);
		}
		catch(NumberFormatException exception) {
			return exception.toString();
		}
		return String.valueOf(result * result);
	}
}
