package Filter;
import java.io.File;
/**
 * Implements Filter, used to filter files that are bigger 
 * or smaller than given values.
 * @author isaacdelarosa
 *
 */
public class BetweenFilter implements Filter{
	private String upper,lower;
	private static final double CONVERSION_FACTOR=1024;
	/**
	 * constructor.
	 * @param lower the lower size.
	 * @param upper the upper size.
	 */
	public BetweenFilter(String lower,String upper){
		this.upper=upper;
		this.lower=lower;
	}
	/**
	 * filters files between sizes.
	 */
	@Override
	public boolean match(File file) {
		double fileSize = file.length()/CONVERSION_FACTOR;
		if(fileSize<=Double.parseDouble(upper)&& 
				fileSize>=Double.parseDouble(lower)){
			return true;
		}
		return false;
	}
}
