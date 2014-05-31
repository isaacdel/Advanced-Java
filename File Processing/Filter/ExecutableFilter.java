package Filter;
import java.io.File;

/**
 *  Implements Filter, used to filter files that are
 (not)executable (depending on parameters).
 * @author isaacdelarosa
 *
 */
public class ExecutableFilter implements Filter{
	private String str;
	private Boolean bool;
	/**
	 * constructor.
	 * @param String the string that defines if we look for files that are
	 * allowed to execute or not.
	 */
	public ExecutableFilter(String str){
		this.str=str;
		if(str.equals("YES")){
			this.bool=true;
		}
		else{//if "NO"
			this.bool=false;
		}
	}
	@Override
	public boolean match(File file) {
		if (file.canExecute()==bool) {
			return true;
		}
		else {
			return false;
		}
	}
}
