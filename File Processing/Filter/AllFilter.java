package Filter;
import java.io.File;
/**
 * A default filter that is triggered when asked or when there 
is a problem with the filter line.implements Filter.
 * @author isaacdelarosa
 *
 */
public class AllFilter implements Filter {
	@Override
	public boolean match(File file) {
		return true;
	}
}
