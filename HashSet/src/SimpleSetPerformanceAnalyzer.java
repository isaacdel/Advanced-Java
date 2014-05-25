import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
/**
 * this class measures times for feeding data1,and data2 and contains operation
 * as well
 * @author isaacdelarosa
 *
 */
public class SimpleSetPerformanceAnalyzer {
	static SimpleSet[] dataBaseArray;
	private static long[] dataComparisonA;
	private static long[] dataComparisonB;
	static long[] timesArray=new long[5];
	//the ex numbers are printed before each one
	public static void main(String[] args) {
		String[] data1=
				Ex4Utils.file2array
				("/Users/isaacdelarosa/Desktop/test/ex1/data1.txt");
		String[] data2=
				Ex4Utils.file2array
				("/Users/isaacdelarosa/Desktop/test/ex1/data2.txt");
		dataBaseArray=dataBases();
		System.out.println("****EX1*******");
		dataComparisonA= feedTimeTester(data1).clone();
		printQuickest(dataComparisonA);
		System.out.println("****EX2*******");
		dataComparisonB=feedTimeTester(data2).clone();
		printQuickest(dataComparisonB);
		System.out.println("****EX3*******");
		System.out.println
		("***the results compering data1 vs data2 are:");
		printQuickest(dataComparisonA);
		printQuickest(dataComparisonB);
		System.out.println("****EX4*******");
		long[] firstComparisonA=containsTimeTester(data1,"hi").clone();
		printQuickest(firstComparisonA);
		System.out.println("****EX5*******");
		long[] fisrtComparisonB=containsTimeTester
				(data1,"-13170890158").clone();
		printQuickest(fisrtComparisonB);
		System.out.println("****EX6*******");
		System.out.println
		("***the results compering " +
				"hi vs -13170890158 with data1 are:");
		printQuickest(firstComparisonA);
		printQuickest(fisrtComparisonB);
		System.out.println("****EX6 DATA2*******");
		long[] secondComparisonA=containsTimeTester
				(data2,"23").clone();
		printQuickest(secondComparisonA);
		long[] secondComparisonB=containsTimeTester
				(data2,"hi").clone();
		printQuickest(secondComparisonB);
		System.out.println("------4-------");
		printQuickest(secondComparisonB);
		System.out.println("------5-------");
		long[] thirdComparison=containsTimeTester
				(data2,"-13170890158").clone();
		printQuickest(thirdComparison);
		System.out.println("------6-------");
		System.out.println
		("***the results compering hi" +
				" vs -13170890158 with data2 are:");
		printQuickest(secondComparisonB);
		printQuickest(thirdComparison);
		System.out.println
		("***the results compering hi vs 23 with data2 are:");
		printQuickest(secondComparisonB);
		printQuickest(secondComparisonA);
	}
	/**
	 * Tests the speed of creating and adding new strings to table
	 * @param data the string array to hash
	 * @return the exact time the process took
	 */
	private static long[] feedTimeTester (java.lang.String[] data){
		long difference=0;
		int i=0;
		for(SimpleSet collection:dataBaseArray){
			long timeBefore=new Date().getTime();//measure starting time
			for(String str:data){
				collection.add(str);
			}
			long timeAfter=new Date().getTime();//measure end time
			difference=timeAfter-timeBefore;//the total time
			timesArray[i]=difference;
			i++;
		}
		return timesArray;
	}
	/**
	 *  Tests the speed of searching for strings in table
	 * @param data  the string array to hash
	 * @param searchVal the wanted string
	 * @return the exact time the process took
	 */
	private static long[] containsTimeTester(String[] data,String searchVal){
		long difference=0;
		int i=0;
		for(SimpleSet collection:dataBaseArray){		
			for(String str:data){
				collection.add(str);
			}
			long timeBefore=new Date().getTime();//measure start time
			collection.contains(searchVal);
			long timeAfter=new Date().getTime();//measure end time
			difference=timeAfter-timeBefore;//the total time
			timesArray[i]=difference;
			i++;
		}
		return timesArray;
	}
	/**
	 * all of the data bases used in this comparison arranged as a collection.
	 * (for easier access)
	 * @return the collection combining all of the data bases.
	 */
	private static SimpleSet[] dataBases (){
		CollectionFacadeSet tree=
				new CollectionFacadeSet(new TreeSet<String>());
		CollectionFacadeSet list=
				new CollectionFacadeSet(new LinkedList<String>());
		CollectionFacadeSet hash=
				new CollectionFacadeSet(new HashSet<String>());
		ChainedHashSet chainedHash=new ChainedHashSet();
		OpenHashSet openHash=new OpenHashSet();
		return new SimpleSet[]{tree,list,hash,chainedHash,openHash};
	}
	/**
	 * prints the quickest data base by comparing their total time for 
	 * the action
	 * @param times the total times that took each data base
	 */
	private static void printQuickest (long[] times){
		//This will retrieve line separator
		String newLine = 
				System.getProperty("line.separator");
		System.out.println
		("the times for Tree,List,Hash,chainedHash,openHash are:");
		for(int i=0;i<times.length;i++){
			System.out.println(times[i]);
		}
		long fastest= min(times);
		//print who is the fastest
		System.out.println("and the quickest data base from"
				+newLine+"0)TreeSet"+newLine+"1)LinkedList"+
				newLine+"2)HashSet"+newLine+"3)chainedHash"
				+newLine+"4)openHash"+newLine+"is:"+fastest);
	}
	/**
	 * returns the min number in the array
	 * @param array the array to look for min through
	 * @return the smallest long number
	 */
	private static long min(long[] array) {
		// Finds and returns min
		long min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
}
