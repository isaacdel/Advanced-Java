package Order;

import java.io.File;
import java.util.Comparator;
/**
 * extends FileOrder, sorts files by type.
 * @author isaacdelarosa
 *
 */
public class TypeOrder extends FileOrder {
	String firstExtension,secondExtension = "";
	/**
	 * default constructor
	 */
	public TypeOrder(){
	}
	/**
	 * store extensions and sort by type.
	 */
	@Override
	public int compare(File firstFile, File secondFile) {
		//get get the extensions and save in strings
		int i = firstFile.getName().lastIndexOf('.');
		int j=secondFile.getName().lastIndexOf('.');
		if (i >= 0) {
			firstExtension = firstFile.getName().substring(i+1);
		}
		if(j>=0){
			secondExtension=secondFile.getName().substring(j+1);
		}
		//compare the extensions
		int compared= firstExtension.compareTo(secondExtension);

		if(compared==0){//when equal
			return super.compare(firstFile, secondFile);
		}
		else{
			return compared;
		}
	}
}
