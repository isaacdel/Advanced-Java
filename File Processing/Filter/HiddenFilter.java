package Filter;
import java.io.File;

public class HiddenFilter implements Filter{
	private Boolean bool;
	/**Implements Filter, used to filter files that are (not)
 hidden (depending on parameters).
	 * @param bool the string containing "YES" or "NO".
	 */
	public HiddenFilter(String bool){
		//convert YER or NO to booleans.
		if(bool.equals("YES")){
			this.bool=true;
		}
		else{
			this.bool=false;
		}
	}
	@Override
	public boolean match(File file) {
		if(file.isHidden()==bool){
			return true;
		}
		else{
			return false;
		}
	}
}
