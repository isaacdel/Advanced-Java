package oop.ex6.filescript;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

import Filter.AllFilter;
import Filter.Filter;
import Filter.FilterFactory;
import Filter.IllegalValuesException;
import Order.OrderFactory;
import Order.TypeOrder;

/**
 * Contains the parsing to sections method, used in MyFileScript 
in order to create sections.
 * @author isaacdelarosa
 *
 */
public class Parser {
	protected static int lineNumber=0,arraySize;
	protected static String string="",line,before;
	private static final String FILTER_HEADER="FILTER";
	private static final String ORDER_HEADER="ORDER";
	private static final String WARNING="Warning in line ";
	/**
	 * @param filePath The file path.
	 * @return An array of strings.
	 * @throws FileNotFoundException 
	 * @throws TypTwoError 
	 */
	public static String[] parser(String filePath)  throws TypeTwoError{
		File commandFile=new File(filePath);
		try (Scanner scan=new Scanner(commandFile)) {
			//array that holds the commands of filtering and ordering.
			arraySize=fileSize(commandFile);
			before=scan.nextLine();//saves the previous FILTER/ORDER.
			//add the lines scanned to a string.
			string+=before+"\n";
			//first line needs to be filter
			if (!before.equals(FILTER_HEADER)) {
				throw new SubsectionException();
			}
			do {
				line=scan.nextLine();//the line that holds the specific filter
				string+=line+"\n";
				//a series of checks to the command file structure.
				//throws typeTwo if needed.
				if (line.equals(FILTER_HEADER)||line.equals(ORDER_HEADER)) {
					switch (line) {
					case FILTER_HEADER:
						if (!before.equals(ORDER_HEADER)) {
							throw new SubsectionException();
						}
						break;
					case ORDER_HEADER:
						if (!before.equals(FILTER_HEADER)) {
							throw new SubsectionException();
						}
						break;
					}
					before=line;//update before to move along the file.
				}
				else if (line.equals("ACTION")){
					throw new SubsectionException();
				}
			} while (scan.hasNext());//run over until file ends
			//prevent structure error
			if (before.equals(FILTER_HEADER)) {
				//reset the parameter used to create the Sections
				Parser.lineNumber=0;
				Parser.string="";
				throw new SubsectionException();
			}
		}
		//catch the fileSize exception
		catch(FileNotFoundException e){
			throw new oop.ex6.filescript.IOException();
		}
		//split and store the command lines in array.
		String[] sections=string.split(FILTER_HEADER+"\n");
		return sections;
	}
	/**
	 * @param sectionString Represents the section the code is in.
	 * @param sourceDirectory The source Directory.
	 * @return Section object.
	 */
	public static Section parseSection(String sectionString,String sourceDirectory) {
		String line;
		Filter filter=null;
		Comparator<File> order=null;
		lineNumber++;//line counter for error display
		//create the sections from the strings in cells holding the
		//wanted filters and orders
		try (Scanner scanner=new Scanner(sectionString)) {
			for (line=scanner.nextLine(); !line.equals(ORDER_HEADER);
					line=scanner.nextLine()) {
				lineNumber++;
				//try creating the filter
				try {
					filter=FilterFactory.createFilter(line);
				}
				catch (TypeOneError e) {
					System.out.println(WARNING+lineNumber);
					//in case of error returns the default filter.
					filter=new AllFilter();
				}
			}
			lineNumber++;
			//continue reading the instructions and try creating order.
			if (scanner.hasNext()) {
				do {
					line=scanner.nextLine();
					lineNumber++;
					try {
						order=OrderFactory.createOrder(line);
					}
					catch (TypeOneError e) {
						System.out.println(WARNING+lineNumber);
					}
				}
				while (scanner.hasNext());
			}
			//return valid and functional Section
			return new Section(filter,order);
		}
	}
	/**
	 * @param file The source file.
	 * @return The length of the file (in lines).
	 * @throws FileNotFoundException
	 */
	private static int fileSize(File file) throws FileNotFoundException {
		Scanner scan=new Scanner(file);
		int i=0;
		while (scan.hasNext()) {
			scan.nextLine();
			i++;
		}
		scan.close();
		return i;
	}
}
