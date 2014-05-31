package Order;
import java.io.File;
import java.util.Comparator;

/**
 * extends FileOrder, sorts files by size.
 * @author isaacdelarosa
 *
 */
public class SizeOrder extends FileOrder{
	Comparator<File> absComparator;
	/**
	 * default constructor
	 */
	public SizeOrder(){
	}
	/**
	 * sort by size
	 */
	@Override
	public int compare(File firstFile, File secondFile) {
		int compare=(int)(firstFile.length()-secondFile.length());
		if(compare==0){//when equal
			return super.compare(firstFile, secondFile);
		}
		else{
			return compare;
		}
	}
}
