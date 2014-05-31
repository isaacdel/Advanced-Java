package Filter;
import java.io.File;

/**
 *  The interface from which all of the filter methods inherit.
 * @author isaacdelarosa
 *
 */
public interface Filter {
	/**
	 * this method will be used differently in every filter.it will be used
	 * in the Section class to check witch file matches the filter than it 
	 * will be added and sorted.
	 * @param file the file we are checking
	 * @return true iff it does match the filter given.
	 */
	public boolean match(File file);
}
