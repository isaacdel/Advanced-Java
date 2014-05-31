package oop.ex6.filescript;
import Filter.Filter;
import java.util.*;
import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

import Order.*;
public class Section {
	private Filter filter;
	private Comparator<File> order;
	/**
	 * Contains the method which creates sections of Filter
,Order objects.
	 * @param filter
	 * @param order
	 */
	public Section(Filter filter,Comparator<File> order){
		this.filter=filter;
		this.order=order;
	}
	/**
	 * filters all of the files using the current filter than applying the 
	 * current order.
	 * @param path the files path being checked.
	 */
	public void applySec(File path){
		//the list that will hold the files
		ArrayList<File> arrayList=new ArrayList<>();
		//run over all files in the given path
		for (int i=0; i<path.listFiles().length; i++) {
			File file=path.listFiles()[i];
			//add the file only if its not a folder and wasn't filtered out.
			if(file.isFile()&&(filter.match(file)||filter==null) ){
				arrayList.add(file);
			}
		}
		//sort the arraylist holding the files by the requested order.
		Collections.sort(arrayList, order);
		//print the ordered list of files.
		for (int j = 0; j < arrayList.size(); j++) {
			System.out.println(arrayList.get(j).getName());
		}
	}
}
