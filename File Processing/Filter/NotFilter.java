package Filter;

import java.io.File;
/**
 * Implements Filter, decorator. used to deal with the
 "NOT" argument. uses the Decorator design pattern.
 * @author isaacdelarosa
 *
 */
public class NotFilter implements Filter {
	private Filter filter;
	/**
	 * constructor
	 * @param filter Filter object.
	 */
	public NotFilter(Filter filter) {
		this.filter = filter;
	}
	@Override
	public boolean match(File file) {
		//return the "opposite" filter result applied, when returning.
		if (filter.match(file)) {
			return false;
		}
		return true;
	}
}
