package Filter;
import java.io.File;

/**
 * A filter that checks if a file exists in the dir.
 * @author isaacdelarosa
 *
 */
public class ContainsFilter implements Filter{
	private String subString;
	/**
	 * constructor.
	 * @param subString the string name we want to look for.
	 */
	public ContainsFilter(String subString){
		this.subString=subString;
	}
	@Override
	public boolean match(File file) {
		String fileName=file.getName();
		if(fileName.contains(subString)){
			return true;
		}
		else{
			return false;
		}
	}
}
