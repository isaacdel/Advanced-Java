package oop.ex7.main.utilities;
/**
 * exception class
 */
public class ExceptionTypeOne extends java.lang.Exception {
	public  String syntaxError;
	public ExceptionTypeOne(String error) {
		this.syntaxError = error; 

	}
}
