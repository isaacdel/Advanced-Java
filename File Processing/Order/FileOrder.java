package Order;

import java.io.File;
import java.util.Comparator;
/**
 * Implements Comparator<File>, compares files by absolute path.
 * @author isaacdelarosa
 *
 */
public class FileOrder implements Comparator<File> {
	/**
	 * this method is going to be used as is or be modified by different order
	 * types. 
	 */
	@Override
	public int compare(File firstFile, File secondFile) {
		return firstFile.getAbsolutePath()
				.compareTo(secondFile.getAbsolutePath());
	}
}
