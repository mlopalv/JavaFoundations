package codeacademy.learnintermediatejava.lambdas;
/*
 * This is an example interface created to illustrate that when having an interface with a single method
 * the lambda implementation will call this method by default
 * See the lambda implementation in the TestLambdas class
 * 
 */
@FunctionalInterface
public interface StringFunction {
	
	public String run(String str);
	
	public static String runA(String str) {
		return "This is a default mehtod running for String Function";		
	}
	
	
}
