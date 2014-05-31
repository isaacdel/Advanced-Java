package Filter;
import java.io.File;

/**
 * Implements Filter, used to filter files of a given name.
 * @author isaacdelarosa
 *
 */
public class FileFilter implements Filter {
	private String name;
	/**
	 * constructor.
	 * @param name the file name we look for.
	 */
	public FileFilter(String name){
		this.name=name;
	}
	@Override
	public boolean match(File file) {
		String fileName=file.getName();
		if(name.compareTo(fileName)==0){
			return true;
		}
		else{
			return false;
		}
	}
}
