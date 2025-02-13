package calculator;

public class Calculator {
	int result = 0;
	
	public double add(int num1, int num2) {
		result = num1 + num2;
		return result;
	}
	
	public double sub(int num1, int num2) {
		result = num1 - num2;
		return result;
	}
	
	public double mul(int num1, int num2) {
		result = num1 * num2;
		return result;
	}
	
	public double div(int num1, int num2) {
		result = num1 / num2;
		return result;
	}
}
