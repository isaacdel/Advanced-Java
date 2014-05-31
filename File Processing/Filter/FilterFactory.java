package Filter;
import java.io.File;
public class FilterFactory {

	/**
	 * Generates filters according to strings.
	 * @param filterString the current line in command file that holds the filter
	 * type.
	 * @return the requested Filter.
	 * @throws IllegalValuesException
	 */
	public static Filter createFilter(String filterString) 
			throws IllegalValuesException {
		Filter filter;
		//splits and stores the arguments of the filter in array.
		String[] filterParameters=filterString.split("#");

		//		try{
		if(filterParameters[0].equals("greater_than")){
			filter= new GreaterThanFilter(filterParameters[1]);
		}
		else if(filterParameters[0].equals("smaller_than")){
			filter= new SmallerThanFilter(filterParameters[1]);
		}
		else if(filterParameters[0].equals("between")){
			//store elements for check
			double start=Double.parseDouble(filterParameters[1]);
			double end=Double.parseDouble(filterParameters[2]);
			if(start>end || start<0||end<=0){//checks if args are valid
				throw new IllegalValuesException();
			}
			filter= new BetweenFilter(filterParameters[1],filterParameters[2]);
		}
		else if(filterParameters[0].equals("contains")){
			filter= new ContainsFilter(filterParameters[1]);
		}
		else if(filterParameters[0].equals("executable")){
			String bool=filterParameters[1];//store elements for check
			//checks if args are valid
			if(!bool.equals("YES")&&!bool.equals("NO"))
			{
				throw new IllegalValuesException();
			}
			filter= new ExecutableFilter(filterParameters[1]);
		}
		else if(filterParameters[0].equals("hidden")){
			String bool=filterParameters[1];//store elements for check
			//checks if args are valid
			if(!bool.equals("YES")&&!bool.equals("NO"))
			{
				throw new IllegalValuesException();
			}
			filter= new HiddenFilter(filterParameters[1]);
		}
		else if(filterParameters[0].equals("prefix")){
			filter= new PrefixFilter(filterParameters[1]);
		}
		else if(filterParameters[0].equals("suffix")){
			filter= new SuffixFilter(filterParameters[1]);
		}
		else if(filterParameters[0].equals("writable")){
			String bool=filterParameters[1];//store elements for check
			//checks if args are valid
			if(!bool.equals("YES")&&!bool.equals("NO"))
			{
				throw new IllegalValuesException();
			}
			filter= new WritableFilter(filterParameters[1]);
		}
		else if(filterParameters[0].equals("file")){
			filter= new FileFilter(filterParameters[1]);
		}
		else if(filterParameters[0].equals("all")){
			filter= new AllFilter();
		}
		else{
			new AllFilter();//default filter in case there was a problem.a
			throw new IllegalValuesException();
		}
		//NOT Filter checker
		//if exists its in the last cell
		if (filterParameters[filterParameters.length-1].equals("NOT")) {
			filter=new NotFilter(filter);
		}
		return filter;
	}
}
