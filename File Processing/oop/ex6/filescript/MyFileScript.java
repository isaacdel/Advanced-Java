package oop.ex6.filescript;

import java.io.File;
/**
 * Contains the main method, performs the action
 on a given dir and command file.
 * @author isaacdelarosa
 *
 */
public class MyFileScript {
	private static final int ARGS_CONST = 2;
	private static final String ERROR_MESSEGE="ERROR";
	/**
	 * the MANAGER. "knows" all of the other classes and uses and combines 
	 * them to create the file explorer.
	 * @param args the arguments that hold the paths of command file and files.
	 */
	public static void main(String[] args) {
		//check if less than two arguments are given.
		if (args.length!=ARGS_CONST) {
			System.out.println(ERROR_MESSEGE);
			return;
		}
		try{
			//create blocks of Sections and stores them in a string array.
			String[] sections= Parser.parser(args[1]);
			for (int j = 1; j < sections.length; j++) {
				//take one block each time and make a valid Section from it
				Section section=Parser.parseSection(sections[j], args[0]);
				//save command file
				File source=new File(args[0]);
				//apply order and filter on files using the command file.
				section.applySec(source);
			}
			//reset the parameter used to create the Sections
			Parser.lineNumber=0;
			Parser.string="";
			//Parser.line=null;
		}
		catch(TypeTwoError e){	
			System.out.println(ERROR_MESSEGE);
			//reset the parameter used to create the Sections
			Parser.lineNumber=0;
			Parser.string="";
			//exit program
			return;
		}
	}
}
