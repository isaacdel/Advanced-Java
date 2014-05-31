package Filter;
import java.io.File;
/**
 * - Implements Filter, used to filter files which are
 smaller than a given value.
 * @author isaacdelarosa
 *
 */
public class GreaterThanFilter implements Filter {
	private String size;
	private static final double CONVERSION_FACTOR=1024;
	/**
	 * constructor
	 * @param size the min size.
	 */
	public GreaterThanFilter(String size) {
		this.size = size;
	}

	@Override
	/**
	 * filter files smaller than given size
	 */
	public boolean match(File file) {
		double fileSize = file.length()/CONVERSION_FACTOR;
		if (fileSize>Double.parseDouble(size)) {
			return true;
		}
		else {
			return false;
		}
	}
}
