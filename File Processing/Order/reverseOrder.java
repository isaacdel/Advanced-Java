package Order;

import java.io.File;
import java.util.Comparator;
/**
 * extends FileOrder,sorts the given order in reverse order.
 * @author isaacdelarosa
 *
 */
public class reverseOrder extends FileOrder {
	private Comparator<File> order;
	/**
	 * constructor
	 * @param order the order to apply and reverse.
	 */
	public reverseOrder(Comparator<File> order){
		this.order=order;
	}
	/**
	 * return the opposite number (-1 becomes 1 etc) on the "way back" from the
	 * applied order so the order will be in reverse.
	 */
	@Override
	public int compare(File o1, File o2) {
		return -(order.compare(o1, o2));
	}
}
