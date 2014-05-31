package Filter;
import java.io.File;

/**
 * Implements Filter, used to filter files which start 
with a given prefix.
 * @author isaacdelarosa
 *
 */
public class PrefixFilter implements Filter{
	private String name;
	/**
	 * constructor.
	 * @param name The string name we are checking.
	 */
	public PrefixFilter(String name) {
		this.name=name;
	}
	public boolean match(File file) {
		String fileName=file.getName();
		return (fileName.startsWith(name));
	}
}
