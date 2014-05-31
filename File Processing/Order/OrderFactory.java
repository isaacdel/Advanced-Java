package Order;
import java.io.File;
import java.util.Comparator;

import Filter.NotFilter;

/**
 * Generates orders according to strings.
 * @author isaacdelarosa
 *
 */
public class OrderFactory {
	/**
	 * Generates orders according to strings,than 
	 * @param orderString the line in the command file that holds the wanted
	 *  order
	 * @return a Comperator order that will be used by the collection to 
	 * sort the files in specific 
	 * order.
	 * @throws OrderValueException
	 */
	public static Comparator<File> createOrder(String orderString) 
			throws OrderValueException{
		Comparator<File> order;
		//create array that holds the order parameters.
		String[] orderParameters=orderString.split("#");
		//parameters name in first cell (str[0])
		if(orderParameters[0].equals("abs")){
			order= new AbsOrder();
		}
		else if(orderParameters[0].equals("size")){
			order= new SizeOrder();
		}
		else if(orderParameters[0].equals("type")){
			order= new TypeOrder();
		}
		else{
			//default when no other order is valid.
			new AbsOrder();
			throw new OrderValueException();
		}
		//REVERSE Order checker
		//if exists its in the last cell
		if (orderParameters[orderParameters.length-1].equals("REVERSE")) {
			order=new reverseOrder(order);
		}
		return order;
	}
}
