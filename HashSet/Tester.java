import static org.junit.Assert.*;

import org.junit.Test;
/**
 * This class is j-Unit testers. The tests base on online testers.
 * The object a - represent OpenHashSet object
 * The object b - represent ChainedHashSet object
 * 
 * @author Yaniv Pade'
 *
 */

public class Tester {
	String str1 ="Hi", str2 ="Bye",str3="Hello", str4 ="Ciao" ;


	/**Test1
	 * # simple creation of an empty set with the default initial capacity and load factors
	 */
	@Test(timeout=100)
	public void test1() {
		OpenHashSet a = new OpenHashSet();
		assertTrue("Not intial capacity", (a.capacity()==16));

		ChainedHashSet b = new ChainedHashSet();
		assertTrue("Not intial capacity", (b.capacity()==16));
	}

	/**Test2
	 * # simple data creation of a set
	 */
	@Test(timeout=100)	
	public void test2() {
		String [] A = new String [] {"1","5","9","7"};

		OpenHashSet a = new OpenHashSet(A);

		ChainedHashSet b = new ChainedHashSet(A);
	}
	/**Test3
	 * # simple creation of an empty set with the specified load factors
	 */
	@Test(timeout=100)	
	public void test3() {
		float upper =(float) 0.6,lower =(float) 0.1;

		OpenHashSet a = new OpenHashSet(upper,lower);

		ChainedHashSet b = new ChainedHashSet(upper,lower);
	}
	/**Test 4
	 * # simple add test
	 */
	@Test
	public void test4() {
		String newValue ="Hi";
		OpenHashSet a = new OpenHashSet();
		assertTrue("Not add String",a.add(newValue));

		ChainedHashSet b = new ChainedHashSet();
		assertTrue("Not add String",b.add(newValue));

	}
	/**Test 5
	 * # simple add test of an existing value
	 */
	@Test
	public void test5() {
		OpenHashSet a = new OpenHashSet();

		assertTrue("Not add String",a.add(str1));
		assertTrue("Add same String to set",(a.contains(str1)));

		ChainedHashSet b = new ChainedHashSet();
		assertTrue("Not add String",b.add(str1));
		assertTrue("Add same String to set",(a.contains(str1)));

	}

	/**Test 6
	 * # simple contains test of a non-existing value
	 */
	@Test
	public void test6() {
		OpenHashSet a = new OpenHashSet();
		assertFalse("Not contains",a.contains(str1));

		ChainedHashSet b = new ChainedHashSet();
		assertFalse("Not contains",b.contains(str1));

	}
	/**Test 7
	 * # simple contains of an existing value
	 */
	@Test
	public void test7() {
		OpenHashSet a = new OpenHashSet();
		assertTrue("Not add Hi",a.add(str1));
		assertTrue("Not contains",a.contains(str1));

		ChainedHashSet b = new ChainedHashSet();
		assertTrue("Not add Hi",b.add(str1));
		assertTrue("Not contains",b.contains(str1));
	}

	/**Test 8
	 * # simple delete of an existing value
	 */
	@Test
	public void test8() {
		OpenHashSet a = new OpenHashSet();
		assertTrue("Not add Hi",a.add(str1));
		assertTrue("Not delete",a.delete(str1));

		ChainedHashSet b = new ChainedHashSet();
		assertTrue("Not add Hi",b.add(str1));
		assertTrue("Not delete",b.delete(str1));
	}

	/**Test 9
	 * #  simple delete of a non-existing value
	 */
	@Test
	public void test9() {
		OpenHashSet a = new OpenHashSet();
		assertFalse("Delete non-existing value",a.delete(str1));

		ChainedHashSet b = new ChainedHashSet();
		assertFalse("Delete non-existing value",b.delete(str1));
	}	

	/**Test 10
	 *# simple size test of an empty hash
	 */
	@Test
	public void test10() {
		OpenHashSet a = new OpenHashSet();
		assertTrue("Empty table size isn't 0",(a.size()==0));

		ChainedHashSet b = new ChainedHashSet();
		assertTrue("Empty table size isn't 0",(b.size()==0));
	}

	/**Test 11
	 *# simple size test of a non-empty tree
	 */
	@Test
	public void test11() {
		OpenHashSet a = new OpenHashSet();
		a.add(str1);
		assertTrue("The size should be 1",(a.size()==1));

		ChainedHashSet b = new ChainedHashSet();
		b.add(str1);
		assertTrue("The size should be 1",(b.size()==1));

	}
	/**Test 12
	 *# simple delete + size
	 */
	@Test
	public void test12() {
		OpenHashSet a = new OpenHashSet();
		a.add(str1);
		a.delete(str1);
		assertTrue("Empty table size isn't 0",(a.size()==0));

		ChainedHashSet b = new ChainedHashSet();
		b.add(str1);
		b.delete(str1);
		assertTrue("Empty table size isn't 0",(b.size()==0));
	}

	/**Test 13
	 *# simple delete + size
	 */
	@Test
	public void test13() {
		OpenHashSet a = new OpenHashSet();
		assertTrue("Not add Hi",a.add(str1));
		assertFalse("Not delete Bye",a.delete(str2));
		assertTrue("The size should be 1",(a.size()==1));

		ChainedHashSet b = new ChainedHashSet();
		assertTrue("Not add Hi",b.add(str1));
		assertFalse("Not delete Bye",b.delete(str2));
		assertTrue("The size should be 1",(b.size() == 1));
	}

	/**Test 14
	 *# simple capacity
	 */
	@Test
	public void test14() {
		OpenHashSet a = new OpenHashSet();
		assertTrue("Capacity isn't 16",(a.capacity() == 16));

		ChainedHashSet b = new ChainedHashSet();
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
	}

	/**Test 15
	 *# simple capacity after adding elements that shouldn't affect the capacity
	 */
	@Test
	public void test15() {
		OpenHashSet a = new OpenHashSet();
		assertTrue("Not add Hi",a.add(str1));
		assertTrue("Capacity isn't 16",(a.capacity() == 16));

		ChainedHashSet b = new ChainedHashSet();
		assertTrue("Not add Hi",b.add(str1));
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
	}

	/**Test 16
	 *# simple capacity after adding elements that shouldn't affect the capacity
	 */
	@Test
	public void test16() {
		OpenHashSet a = new OpenHashSet();
		assertTrue("Not add Hi",a.add(str1));
		assertFalse("Shouldn't add Hi",a.add(str1));
		assertFalse("Shouldn't add Hi",a.add(str1));
		assertTrue("Capacity isn't 16",(a.capacity() == 16));

		ChainedHashSet b = new ChainedHashSet();
		assertTrue("Not add Hi",b.add(str1));
		assertFalse("Shouldn't add Hi",b.add(str1));
		assertFalse("Shouldn't",b.add(str1));
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
	}

	/**Test 17
	 *# simple size + capacity after adding elements that should not affect the capacity
	 */
	@Test
	public void test17() {
		float upper =(float) 0.7,lower =(float) 0.1;

		OpenHashSet a = new OpenHashSet(upper,lower);

		assertTrue("Not add Hi",a.add(str1));
		assertFalse("Shouldn't add Hi",a.add(str1));
		assertTrue("Not add element",a.add(str2));
		assertTrue("Size Should be 2",(a.size() == 2));
		assertTrue("Capacity isn't 16",(a.capacity() == 16));
		assertFalse("Shouldn't add Hi",a.add(str1));
		assertTrue("Size Should be 2",(a.size() == 2));
		assertTrue("Capacity isn't 16",(a.capacity() == 16));

		ChainedHashSet b = new ChainedHashSet(upper,lower);

		assertTrue("Not add Hi",b.add(str1));
		assertFalse("Shouldn't add Hi",b.add(str1));
		assertTrue("Not add element",b.add(str2));
		assertTrue("Size Should be 2",(b.size() == 2));
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
		assertFalse("Shouldn't add Hi",b.add(str1));
		assertTrue("Size Should be 2",(b.size() == 2));
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
	}

	/**Test 18
	 *# simple size + capacity after adding elements that should affect the capacity
	 */
	@Test
	public void test18() {
		float upper =(float) 0.7,lower =(float) 0.1;

		OpenHashSet a = new OpenHashSet(upper,lower);
		assertTrue("Not add element",a.add(str1));
		assertTrue("Not add element",a.add(str3));
		assertTrue("Not add element",a.add(str2));
		assertTrue("Size Should be 3",(a.size() == 3));
		assertTrue("Not add element",a.add(str4));
		assertTrue("Size Should be 4",(a.size() == 4));
		assertTrue("Not add element",a.add("1"));
		assertTrue("Not add element",a.add("2"));
		assertTrue("Not add element",a.add("3"));
		assertTrue("Not add element",a.add("4"));
		assertTrue("Not add element",a.add("5"));
		assertTrue("Not add element",a.add("6"));
		assertTrue("Not add element",a.add("7"));
		assertTrue("Capacity isn't 16",(a.capacity() == 16));
		assertTrue("Not add element",a.add("8"));
		assertTrue("Capacity isn't 32",(a.capacity() == 32));
		assertFalse("Shouldn't add double element",a.add("8"));
		assertTrue("Not add element",a.add("9"));
		assertTrue("Not add element",a.add("10"));
		assertTrue("Not add element",a.add("11"));
		assertTrue("Not add element",a.add("12"));
		assertTrue("Not add element",a.add("13"));
		assertTrue("Not add element",a.add("14"));
		assertTrue("Size Should be 18",(a.size() == 18));
		assertTrue("Capacity isn't 32",(a.capacity() == 32));

		ChainedHashSet b = new ChainedHashSet(upper,lower);
		assertTrue("Not add element",b.add(str1));
		assertTrue("Not add element",b.add(str3));
		assertTrue("Not add element",b.add(str2));
		assertTrue("Size Should be 3",(b.size() == 3));
		assertTrue("Not add element",b.add(str4));
		assertTrue("Size Should be 4",(b.size() == 4));
		assertTrue("Not add element",b.add("1"));
		assertTrue("Not add element",b.add("2"));
		assertTrue("Not add element",b.add("3"));
		assertTrue("Not add element",b.add("4"));
		assertTrue("Not add element",b.add("5"));
		assertTrue("Not add element",b.add("6"));
		assertTrue("Not add element",b.add("7"));
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
		assertTrue("Not add element",b.add("8"));
		assertTrue("Capacity isn't 32",(b.capacity() == 32));
		assertFalse("Shouldn't add double element",b.add("8"));
		assertTrue("Not add element",b.add("9"));
		assertTrue("Not add element",b.add("10"));
		assertTrue("Not add element",b.add("11"));
		assertTrue("Not add element",b.add("12"));
		assertTrue("Not add element",b.add("13"));
		assertTrue("Not add element",b.add("14"));
		assertTrue("Size Should be 18",(b.size() == 18));
		assertTrue("Capacity isn't 32",(b.capacity() == 32));

	}
	/**Test 19
	 *# simple capacity after adding elements that should affect the capacity twice	 
	 */
	@Test
	public void test19() {
		float upper =(float) 0.7,lower =(float) 0.1;

		OpenHashSet a = new OpenHashSet(upper,lower);
		assertTrue("Not add element",a.add(str1));
		assertTrue("Not add element",a.add(str3));
		assertFalse("Shouldn't add double element",a.add(str3));
		assertTrue("Not add element",a.add(str2));
		assertTrue("Size Should be 3",(a.size() == 3));
		assertTrue("Capacity isn't 16",(a.capacity() == 16));
		assertTrue("Not add element",a.add(str4));
		assertFalse("Shouldn't add double element",a.add(str1));
		assertTrue("Size Should be 4",(a.size() == 4));
		assertTrue("Not add element",a.add("5"));
		assertTrue("Not add element",a.add("6"));
		assertTrue("Not add element",a.add("7"));
		assertTrue("Not add element",a.add("8"));
		assertTrue("Not add element",a.add("9"));
		assertTrue("Not add element",a.add("10"));
		assertTrue("Not add element",a.add("11"));
		assertTrue("Capacity isn't 16",(a.capacity() == 16));
		assertFalse("Shouldn't add double element",a.add("11"));
		assertTrue("Not add element",a.add("12"));
		assertTrue("Capacity isn't 32",(a.capacity() == 32));
		assertTrue("Size Should be 12",(a.size() == 12));

		ChainedHashSet b = new ChainedHashSet(upper,lower);
		assertTrue("Not add element",b.add(str1));
		assertTrue("Not add element",b.add(str3));
		assertFalse("Shouldn't add double element",b.add(str3));
		assertTrue("Not add element",b.add(str2));
		assertTrue("Size Should be 3",(b.size() == 3));
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
		assertTrue("Not add element",b.add(str4));
		assertFalse("Shouldn't add double element",b.add(str1));
		assertTrue("Size Should be 4",(b.size() == 4));
		assertTrue("Not add element",b.add("5"));
		assertTrue("Not add element",b.add("6"));
		assertTrue("Not add element",b.add("7"));
		assertTrue("Not add element",b.add("8"));
		assertTrue("Not add element",b.add("9"));
		assertTrue("Not add element",b.add("10"));
		assertTrue("Not add element",b.add("11"));
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
		assertFalse("Shouldn't add double element",b.add("11"));
		assertTrue("Not add element",b.add("12"));
		assertTrue("Capacity isn't 32",(b.capacity() == 32));
		assertTrue("Size Should be 12",(b.size() == 12));
	}
	/**Test 20
	 *# simple size + capacity after adding elements that should affect the capacity	 
	 */
	@Test
	public void test20() {
		float upper =(float) 0.5,lower =(float) 0.1;

		OpenHashSet a = new OpenHashSet(upper,lower);
		assertTrue("Not add element",a.add(str1));
		assertTrue("Not add element",a.add(str3));
		assertTrue("Not add element",a.add(str2));
		assertTrue("Not add element",a.add("4"));
		assertTrue("Not add element",a.add("5"));
		assertTrue("Not add element",a.add("6"));
		assertTrue("Not add element",a.add("7"));
		assertTrue("Not add element",a.add("8"));
		assertTrue("Capacity isn't 16",(a.capacity() == 16));
		assertTrue("Not add element",a.add("9"));
		assertTrue("Capacity isn't 32",(a.capacity() == 32));
		assertTrue("Not add element",a.add("10"));
		assertTrue("Not add element",a.add("11"));
		assertTrue("Capacity isn't 32",(a.capacity() == 32));
		assertTrue("Not add element",a.add("12"));
		assertTrue("Not add element",a.add("13"));
		assertTrue("Not add element",a.add("14"));
		assertTrue("Not add element",a.add("15"));
		assertTrue("Not add element",a.add("16"));
		assertTrue("Capacity isn't 32",(a.capacity() == 32));
		assertTrue("Not add element",a.add("17"));
		assertTrue("Capacity isn't 64",(a.capacity() == 64));
		assertTrue("Not add element",a.add("18"));
		assertTrue("Not add element",a.add("19"));
		assertTrue("Not add element",a.add("20"));
		assertTrue("Capacity isn't 64",(a.capacity() == 64));
		assertTrue("Size Should be 20",(a.size() == 20));

		ChainedHashSet b = new ChainedHashSet(upper,lower);
		assertTrue("Not add element",b.add(str1));
		assertTrue("Not add element",b.add(str3));
		assertTrue("Not add element",b.add(str2));
		assertTrue("Not add element",b.add("4"));
		assertTrue("Not add element",b.add("5"));
		assertTrue("Not add element",b.add("6"));
		assertTrue("Not add element",b.add("7"));
		assertTrue("Not add element",b.add("8"));
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
		assertTrue("Not add element",b.add("9"));
		assertTrue("Capacity isn't 32",(b.capacity() == 32));
		assertTrue("Not add element",b.add("10"));
		assertTrue("Not add element",b.add("11"));
		assertTrue("Capacity isn't 32",(b.capacity() == 32));
		assertTrue("Not add element",b.add("12"));
		assertTrue("Not add element",b.add("13"));
		assertTrue("Not add element",b.add("14"));
		assertTrue("Not add element",b.add("15"));
		assertTrue("Not add element",b.add("16"));
		assertTrue("Capacity isn't 32",(b.capacity() == 32));
		assertTrue("Not add element",b.add("17"));
		assertTrue("Capacity isn't 64",(b.capacity() == 64));
		assertTrue("Not add element",b.add("18"));
		assertTrue("Not add element",b.add("19"));
		assertTrue("Not add element",b.add("20"));
		assertTrue("Capacity isn't 64",(b.capacity() == 64));
		assertTrue("Size Should be 20",(b.size() == 20));
	}

	/**Test 21
	 * # simple size after using the data constructor	 
	 */
	@Test(timeout=100)
	public void test21() {
		String [] A = new String [] {"Hi", "Bye", "Hello", "Ciao", "Shalom" };

		OpenHashSet a = new OpenHashSet(A);
		assertTrue("Size Should be 5",(a.size() == 5));

		ChainedHashSet b = new ChainedHashSet(A);
		assertTrue("Size Should be 5",(b.size() == 5));
	}

	/**Test 22
	 * # simple capacity after using the data constructor	 
	 */
	@Test(timeout=100)
	public void test22() {
		String [] A = new String [] {"Hi", "Bye", "Hello", "Ciao", "Shalom" };

		OpenHashSet a = new OpenHashSet(A);
		assertTrue("Capacity isn't 16",(a.capacity() == 16));

		ChainedHashSet b = new ChainedHashSet(A);
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
	}

	/**Test 23
	 *# simple size + capacity after using the data constructor that contains duplicated elements	 
	 */
	@Test(timeout=100)
	public void test23() {
		String [] A = new String [] {"Hi", "Bye", "Hello", "Ciao", "Shalom","Hi", "Hello", "Bye" };

		OpenHashSet a = new OpenHashSet(A);
		assertTrue("Size Should be 5",(a.size() == 5));
		assertTrue("Capacity isn't 16",(a.capacity() == 16));

		ChainedHashSet b = new ChainedHashSet(A);
		assertTrue("Size Should be 5",(b.size() == 5));
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
	}

	/**Test 24
	 *# simple size + capacity after using the data constructor that contains 
	 * elements that should be mapped to the same bucket in the hash
	 */ 
	@Test
	public void test24() {
		String [] A = new String [] {"DAST", "CLIDS", "Infi", "Hello", "Bye", "Test", "Algebra", "History", "Java", "Math" };

		OpenHashSet a = new OpenHashSet(A);
		assertTrue("Size Should be 10",(a.size() == 10));
		assertTrue("Capacity isn't 16",(a.capacity() == 16));

		ChainedHashSet b = new ChainedHashSet(A);
		assertTrue("Size Should be 10",(b.size() == 10));
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
	}

	/**Test 25
	 *# simple delete - deleting elements that are mapped to different buckets in the hash
	 */ 
	@Test
	public void test25() {
		String [] A = new String [] {"DAST", "CLIDS", "Infi", "Hello", "Bye", "Test", "Algebra", "History", "Java", "Math" };

		OpenHashSet a = new OpenHashSet(A);
		assertTrue("not delete element",(a.delete("History")));
		assertTrue("not delete element",(a.delete("CLIDS")));
		assertTrue("Size Should be 8",(a.size() == 8));
		assertTrue("Capacity isn't 16",(a.capacity() == 16));

		ChainedHashSet b = new ChainedHashSet(A);
		assertTrue("not delete element",(b.delete("History")));
		assertTrue("not delete element",(b.delete("CLIDS")));
		assertTrue("Size Should be 8",(b.size() == 8));
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
	}
	/**Test 26
	 * # complex delete - deleting elements that are mapped to different buckets 
	 * in the hash but contain additional elements in the same bucket
	 */ 
	@Test
	public void test26() {
		String [] A = new String [] {"DAST", "CLIDS", "Infi", "Hello", "Bye", "Test", "Algebra", "History", "Java", "Math" };

		OpenHashSet a = new OpenHashSet(A);
		assertTrue("not delete element",(a.delete("Hello")));
		assertTrue("not delete element",(a.delete("Algebra")));
		assertTrue("Size Should be 8",(a.size() == 8));
		assertTrue("Capacity isn't 16",(a.capacity() == 16));

		ChainedHashSet b = new ChainedHashSet(A);
		assertTrue("not delete element",(b.delete("Hello")));
		assertTrue("not delete element",(b.delete("Algebra")));
		assertTrue("Size Should be 8",(b.size() == 8));
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
	}
	/**Test 27
	 * # simple capacity + size - after deleting elements that should affect the capacity only once
	 */ 
	@Test
	public void test27() {
		String [] A = new String [] {"DAST", "CLIDS", "Infi", "Hello", "Bye", "Test", "Algebra"};

		OpenHashSet a = new OpenHashSet(A);
		assertTrue("Capacity isn't 16",(a.capacity() == 16));
		assertTrue("Size Should be 7",(a.size() == 7));
		assertTrue("Not delete element",(a.delete("Test")));
		assertTrue("Not delete element",(a.delete("Hello")));
		assertTrue("Not delete element",(a.delete("DAST")));
		assertTrue("Not delete element",(a.delete("Infi")));
		assertTrue("Capacity isn't 8",(a.capacity() == 8));
		assertTrue("Size Should be 3",(a.size() == 3));
		assertFalse("Shouldn't delete non-exits element",a.delete("Clids"));
		assertTrue("Size Should be 3",(a.size() == 3));

		ChainedHashSet b = new ChainedHashSet(A);
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
		assertTrue("Size Should be 7",(b.size() == 7));
		assertTrue("Not delete element",(b.delete("Test")));
		assertTrue("Not delete element",(b.delete("Hello")));
		assertTrue("Not delete element",(b.delete("DAST")));
		assertTrue("Not delete element",(b.delete("Infi")));
		assertTrue("Capacity isn't 8",(b.capacity() == 8));
		assertTrue("Size Should be 3",(b.size() == 3));
		assertFalse("Shouldn't delete non-exits element",b.delete("Clids"));
		assertTrue("Size Should be 3",(b.size() == 3));
	}

	/**Test 28
	 * # simple capacity + size - after deleting elements that should affect the capacity twice
	 */ 
	@Test
	public void test28() {
		String [] A = new String [] {"DAST", "CLIDS", "Infi", "Hello", "Bye", "Test", "Algebra"};

		OpenHashSet a = new OpenHashSet(A);
		assertTrue("Capacity isn't 16",(a.capacity() == 16));
		assertTrue("Size Should be 7",(a.size() == 7));
		assertTrue("Not delete element",(a.delete("Test")));
		assertTrue("Not delete element",(a.delete("Hello")));
		assertTrue("Not delete element",(a.delete("DAST")));
		assertTrue("Not delete element",(a.delete("Infi")));
		assertTrue("Capacity isn't 8",(a.capacity() == 8));
		assertTrue("Size Should be 3",(a.size() == 3));
		assertTrue("Not delete element",a.delete("CLIDS"));
		assertTrue("Not delete element",a.delete("Bye"));
		assertTrue("Capacity isn't 4",(a.capacity() == 4));
		assertTrue("Size Should be 1",(a.size() == 1));

		ChainedHashSet b = new ChainedHashSet(A);
		assertTrue("Capacity isn't 16",(b.capacity() == 16));
		assertTrue("Size Should be 7",(b.size() == 7));
		assertTrue("Not delete element",(b.delete("Test")));
		assertTrue("Not delete element",(b.delete("Hello")));
		assertTrue("Not delete element",(b.delete("DAST")));
		assertTrue("Not delete element",(b.delete("Infi")));
		assertTrue("Capacity isn't 8",(b.capacity() == 8));
		assertTrue("Size Should be 3",(b.size() == 3));
		assertTrue("Not delete element",b.delete("CLIDS"));
		assertTrue("Not delete element",b.delete("Bye"));
		assertTrue("Capacity isn't 4",(b.capacity() == 4));
		assertTrue("Size Should be 1",(b.size() == 1));
	}

	/**Test 29
	 * # complex - a series of add, delete, capacity that does not affect the capacity
	 */ 
	@Test
	public void test29(){
		String [] A = new String [] {"hash", "Hash", "guitar", "piano", "violin", "DAST", 
				"CLIDS", "Infi", "Hello", "Bye", "Test", "Algebra", "Boo", "DAST", "CLIDS", "Shalom",
				"Kushkush", "hello", "hi", "naal", "DAST", "CLIDS", "oink"};

		OpenHashSet a = new OpenHashSet(A);
		assertTrue("Size Should be 19",(a.size() == 19));
		assertTrue("Capacity isn't 32",(a.capacity() == 32));
		assertTrue("Not delete element",(a.delete("Boo")));
		assertTrue("Not delete element",(a.delete("Infi")));
		assertTrue("Not delete element",(a.delete("Hello")));
		assertTrue("Not delete element",(a.delete("hello")));
		assertTrue("Not delete element",(a.delete("Hash")));
		assertTrue("Not add element",(a.add("Hash")));
		assertTrue("Not delete element",(a.delete("Hash")));
		assertTrue("Not delete element",(a.delete("Bye")));
		assertTrue("Size Should be 19",(a.size() == 13));
		assertTrue("Capacity isn't 32",(a.capacity() == 32));

		ChainedHashSet b = new ChainedHashSet(A);
		assertTrue("Size Should be 19",(b.size() == 19));
		assertTrue("Capacity isn't 32",(b.capacity() == 32));
		assertTrue("Not delete element",(b.delete("Boo")));
		assertTrue("Not delete element",(b.delete("Infi")));
		assertTrue("Not delete element",(b.delete("Hello")));
		assertTrue("Not delete element",(b.delete("hello")));
		assertTrue("Not delete element",(b.delete("Hash")));
		assertTrue("Not add element",(b.add("Hash")));
		assertTrue("Not delete element",(b.delete("Hash")));
		assertTrue("Not delete element",(b.delete("Bye")));
		assertTrue("Size Should be 19",(b.size() == 13));
		assertTrue("Capacity isn't 32",(b.capacity() == 32));

	}

}
