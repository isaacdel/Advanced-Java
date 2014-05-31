package Filter;
import java.io.File;

/**
 * Implements Filter, used to filter files which end with 
a given suffix.
 * @author isaacdelarosa
 *
 */
public class SuffixFilter implements Filter{
	private String name;
	/**
	 * constructor.
	 * @param name The string we want to check.
	 */
	public SuffixFilter(String name) {
		this.name=name;
	}
	@Override
	public boolean match(File file) {
		String fileName=file.getName();
		return (fileName.endsWith(name));
	}
}
