package Filter;
import java.io.File;

/**
 * Implements Filter, used to filter files that are 
(not) writable (depending on parameters).
 * @author isaacdelarosa
 *
 */
public class WritableFilter implements Filter {
	private String str;
	private Boolean bool;
	/**
	 * constructor.
	 * @param 
	 */
	public WritableFilter(String str){
		this.str = str;
		//convert YER or NO to booleans.

		if(str.equals("YES")){
			this.bool=true;
		}
		else{
			this.bool=false;
		}	
	}
	@Override
	public boolean match(File file) {
		if(file.canWrite()==bool){
			return true;
		}
		else{
			return false;
		}
	}
}
