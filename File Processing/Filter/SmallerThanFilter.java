package Filter;
import java.io.File;

/**
 * Implements Filter, used to filter files that are
 bigger than a given value.
 * @author isaacdelarosa
 *
 */
public class SmallerThanFilter implements Filter {
	private String size;
	private static final double CONVERSION_FACTOR=1024;
	/**
	 * constructor.
	 * @param size the limit size.
	 */
	public SmallerThanFilter(String size) {
		this.size=size;
	}
	@Override
	public boolean match(File file) {
		double fileSize = file.length()/CONVERSION_FACTOR;
		if (fileSize<Double.parseDouble(size)) {
			return true;
		}
		else {
			return false;
		}
	}
}
