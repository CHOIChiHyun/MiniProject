package calculator;

public class Calculator {
	int result = 0;
	
	public double add(int num) {
		result += num;
		return result;
	}
	
	public double sub(int num) {
		result -= num;
		return result;
	}
	
	public double mul(int num) {
		result *= num;
		return result;
	}
	
	public double div(int num) {
		result /= num;
		return result;
	}
}
