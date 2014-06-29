/**
 * this class parse each line into array of words
 * that can be easily analyze. 
 */
package oop.ex7.main;

import java.util.ArrayList;
import java.util.regex.*;

import oop.ex7.main.utilities.ExceptionTypeOne;
import oop.ex7.main.utilities.RagexUtils;

public class Parser {

	/**
	 * this method receive a line and parse it into word
	 * than he will send the arrays for further analyze
	 * @param line
	 * @throws ExceptionTypeOne 
	 */
	public static ArrayList<ArrayList<String>> parser (String line) 
			throws ExceptionTypeOne{
		miniCheck(line);
		ArrayList<String> rValues = new ArrayList<String>();
		ArrayList<String> lValues = new ArrayList<>();
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		if (isAssignment(line)){
			int cutHere = line.indexOf("=");
			String leftSide = line.substring(0, cutHere);
			String rightSide = line.substring(cutHere + 1);
			lValues = parseLeftSide(leftSide);
			rValues = parseRightSide(rightSide);

			result.add(lValues);
			result.add(rValues);

			return result;
		}
		else{
			lValues = parseLeftSide(line);
			result.add(lValues);
			return result;
		}

	}
	/*
	 * parse the left side of the line
	 * the left side is the default in case there is no '=' in the line
	 */
	private static ArrayList<String> parseLeftSide(String string) {
		ArrayList<String> result = new ArrayList<>(1);
		string = string.trim();
		if((Pattern.compile("\\w+").matcher(string)).find()){
			String[] split = string.split("(\\W+)");
			if((Pattern.compile(RagexUtils.VALID_MODIFY)
					.matcher(split[0])).matches()){
				result.add(0,split[0]);
				if(split[1] != null){
					for(int i = 1;i<split.length;i++){
						result.add(split[i]);
					}
				}
			}

			else{
				for(String word:split){
					result.add(word);
				}
			}
		}

		return result;
	}
	/*
	 * provide minimal check just to see if there is a reason to proceed. 
	 */
	private static void miniCheck(String string) throws ExceptionTypeOne {
		if(!(Pattern.compile(RagexUtils.MINIMAL_CHECK).matcher(string))
				.matches()){
			throw new ExceptionTypeOne("Parser miniCheck: fail mini check");}
	}
	/*
	 * make actual parse into words
	 */
	private static ArrayList<String> parseRightSide(String string) 
			throws ExceptionTypeOne {
		ArrayList<String> result = new ArrayList<>();
		string = string.trim();
		String[] splitedString = string.split("\\W+");
		if(string.startsWith("{")){
			result.add(string.substring(string.indexOf("{"),
					string.indexOf("{")+1));
			for(String word:splitedString){
				if(!word.isEmpty()){result.add(word);}
			}
			if(string.endsWith("};")){result.add(result.size(), 
					string.substring(string.indexOf("}")));}
			else{throw new ExceptionTypeOne("does not end in }");}
		}

		for(String word: splitedString){
			result.add(word);
		}
		return result;
	}
	/*
	 * check if there is assignment operator - '='.
	 */
	private static boolean isAssignment(String line) {
		return line.indexOf("=") != -1;
	}

}
