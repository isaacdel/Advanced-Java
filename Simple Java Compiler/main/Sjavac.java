/**
 * this class receive a text file and break it into lines. 
 */
package oop.ex7.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import oop.ex7.main.utilities.Store;

public class Sjavac {
	public static void main(String[] args) {
		Compiler.methLine = 0;
		Compiler.compilerTextRunNum =0;
		Compiler.currentMeth=0;
		Compiler.methLocationForOwnVar=0;
		Compiler.textRunCounter =1; 
		Store.methodList = new ArrayList<>();
		try {
			ArrayList<String> allLines = new ArrayList<String>();
				BufferedReader br = new BufferedReader
						(new FileReader(args[0]));
				String line  = br.readLine();
				
				while (line != null){
					line = line.trim();

				
					if(!line.isEmpty() && !line.startsWith("//")){
						allLines.add(line);
					}
					line = br.readLine();
				}
				
			String[] linesArray = new String[allLines.size()];
			for(int i=0; i<allLines.size();i++){
				linesArray[i] = allLines.get(i);
			}

			br.close();
			Compiler isCompile = new Compiler(linesArray);
			System.out.println(isCompile.getResult());
			
			
		} catch (FileNotFoundException e) {
			System.out.println("2");
		} catch (IOException e) {
			System.out.println("2");
		}catch(Exception  e){
			System.out.println("1");	
			System.err.println(e.getMessage());
			} catch(Throwable e){

			}
	}

}
