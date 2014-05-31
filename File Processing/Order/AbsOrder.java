package Order;

import java.io.File;
import java.util.Comparator;
/**
 * extends FileOrder , used to sort the files by 
absolute paths.
 * @author isaacdelarosa
 *
 */
public class AbsOrder extends FileOrder {
	/**
	 * default constructor
	 */
	public AbsOrder(){
	}
	@Override
	/**
	 * sort by ABS order using FileOrder compare
	 */
	public int compare(File firstFile, File secondFile) {
		return super.compare(firstFile, secondFile);
	}
}
