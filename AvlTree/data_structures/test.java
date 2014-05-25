package oop.ex5.data_structures;

public class test {
	public static void main(String [ ] args){
		
		/**
		 * txt3
		 */
		System.out.println("*txt3*");
		AvlTree tree1= new AvlTree();
		System.out.println("add 5: "+tree1.add(5));
		System.out.println("\n");
		
		/**
		 * txt4
		 */
		System.out.println("*txt4*");
		AvlTree tree2= new AvlTree();
		System.out.println("add 5: "+tree2.add(5));
		System.out.println("add 5: "+tree2.add(5));
		System.out.println("\n");
		
		/**
		 * txt5
		 */
		System.out.println("*txt5*");
		AvlTree tree3= new AvlTree();
		System.out.println("contains 5: "+tree3.contains(5));
		System.out.println("\n");
		
		/**
		 * txt6
		 */
		System.out.println("*txt6*");
		AvlTree tree4= new AvlTree();
		System.out.println("add 5: "+tree4.add(5));
		System.out.println("contains 5: "+tree4.contains(5));
		System.out.println("\n");
		
		/**
//		 * txt7  
//		 */
		System.out.println("*txt7*");
		AvlTree tree5= new AvlTree();
		System.out.println("add 5: "+tree5.add(5));
		System.out.println("delete 5: "+tree5.delete(5));
		System.out.println("\n");
		
		/**
		 * txt8
		 */
		System.out.println("*txt8*");
		AvlTree tree6= new AvlTree();
		System.out.println("add 1: "+tree6.add(1));
		System.out.println("add 2: "+tree6.add(2));
		System.out.println("add 3: "+tree6.add(3));
		AvlTree tree7= new AvlTree(tree6);
		System.out.println("\n");
		
		/**
		 * txt9
		 */
		System.out.println("*txt9*");
		int[] a= {1,3,5,7};
		AvlTree tree8= new AvlTree(a);
		AvlTree tree9= new AvlTree(tree8);
		System.out.println("size: "+tree8.size());
		System.out.println("size copy: "+tree9.size());
		System.out.println("\n");

		/**
		 * txt10
		 */
		System.out.println("*txt10*");
		AvlTree tree10= new AvlTree();
		System.out.println("delete 5: "+tree10.delete(5));
		System.out.println("\n");
		
		/**
		 * txt11
		 */
		System.out.println("*txt11*");
		AvlTree tree11= new AvlTree();
		System.out.println("size: "+tree11.size());
		System.out.println("\n");
		
		/**
		 * txt12
		 */
		System.out.println("*txt12*");
		AvlTree tree12= new AvlTree();
		System.out.println("add 5: "+tree12.add(5));
		System.out.println("size: "+tree12.size());
		System.out.println("\n");
		
		/**
		 * txt13
		 */
		System.out.println("*txt13*");
		AvlTree tree13= new AvlTree();
    	System.out.println("add 5: "+tree13.add(5));
		System.out.println("delete 5: "+tree13.delete(5));
		System.out.println("size: "+tree13.size());
		System.out.println("\n");
		
		/**
		 * txt14
		 */
		System.out.println("*txt14*");
		AvlTree tree14= new AvlTree();
		System.out.println("add 5: "+tree14.add(5));
		System.out.println("delete 6: "+tree14.delete(6));
		System.out.println("size: "+tree14.size());
		System.out.println("\n");
		
		/**
		 * txt15
		 */
		System.out.println("*txt15*");
		AvlTree tree15= new AvlTree();
		System.out.println("add 5: "+tree15.add(5));
		System.out.println("add 3: "+tree15.add(3));
		System.out.println("add 4: "+tree15.add(4));
		System.out.println("contains 5:"+tree15.contains(5));
		System.out.println("contains 4:"+tree15.contains(4));
		System.out.println("contains 3:"+tree15.contains(3));
		System.out.println("\n");

		/**
		 * txt16
		 */
		System.out.println("*txt16*");
		AvlTree tree16= new AvlTree();
		System.out.println("add 5: "+tree16.add(5));
		System.out.println("add 7: "+tree16.add(7));
		System.out.println("add 6: "+tree16.add(6));
		System.out.println("contains 5:"+tree16.contains(5));
		System.out.println("contains 7:"+tree16.contains(7));
		System.out.println("contains 6:"+tree16.contains(6));
		System.out.println("\n");

		/**
		 * txt17
		 */
		System.out.println("*txt17*");
		AvlTree tree17= new AvlTree();
		System.out.println("add 5: "+tree17.add(5));
		System.out.println("add 3: "+tree17.add(3));
		System.out.println("add 1: "+tree17.add(1));
		System.out.println("contains 5:"+tree17.contains(5));
		System.out.println("contains 3:"+tree17.contains(3));
		System.out.println("contains 1:"+tree17.contains(1));
		System.out.println("\n");

		/**
		 * txt18
		 */
		System.out.println("*txt18*");
		AvlTree tree18= new AvlTree();
		System.out.println("add 5: "+tree18.add(5));
		System.out.println("add 7: "+tree18.add(7));
		System.out.println("add 9: "+tree18.add(9));
		System.out.println("contains 5:"+tree18.contains(5));
		System.out.println("contains 7:"+tree18.contains(7));
		System.out.println("contains 9:"+tree18.contains(9));
		System.out.println("\n");
		
		/**
		 * txt19
		 */
		System.out.println("*txt19*");
		AvlTree tree19= new AvlTree();
		System.out.println("add 5: "+tree19.add(5));
		System.out.println("add 6: "+tree19.add(6));
		System.out.println("add 3: "+tree19.add(3));
		System.out.println("add 4: "+tree19.add(4));
		System.out.println("delete 6:"+tree19.delete(6));
		System.out.println("contains 5:"+tree19.contains(5));
		System.out.println("contains 4:"+tree19.contains(4));
		System.out.println("contains 3:"+tree19.contains(3));
		System.out.println("contains 6:"+tree19.contains(6));
		System.out.println("\n");
		
		/**
		 * txt20
		 */
		System.out.println("*txt20*");
		AvlTree tree20= new AvlTree();
		System.out.println("add 5: "+tree20.add(5));
		System.out.println("add 3: "+tree20.add(3));
		System.out.println("add 7: "+tree20.add(7));
		System.out.println("add 6: "+tree20.add(6));
		System.out.println("delete 3:"+tree20.delete(3));
		System.out.println("contains 5:"+tree20.contains(5));
		System.out.println("contains 6:"+tree20.contains(6));
		System.out.println("contains 7:"+tree20.contains(7));
		System.out.println("contains 3:"+tree20.contains(3));
		System.out.println("\n");
		
		/**
		 * txt21
		 */
		System.out.println("*txt21*");
		AvlTree tree21= new AvlTree();
		System.out.println("add 5: "+tree21.add(5));
		System.out.println("add 6: "+tree21.add(6));
		System.out.println("add 3: "+tree21.add(3));
		System.out.println("add 1: "+tree21.add(1));
		System.out.println("delete 6:"+tree21.delete(6));
		System.out.println("contains 5:"+tree21.contains(5));
		System.out.println("contains 3:"+tree21.contains(3));
		System.out.println("contains 1:"+tree21.contains(1));
		System.out.println("contains 6:"+tree21.contains(6));
		System.out.println("\n");
		
		/**
		 * txt22
		 */
		System.out.println("*txt22*");
		AvlTree tree22= new AvlTree();
		System.out.println("add 5: "+tree22.add(5));
		System.out.println("add 3: "+tree22.add(3));
		System.out.println("add 7: "+tree22.add(7));
		System.out.println("add 9: "+tree22.add(9));
		System.out.println("delete 3:"+tree22.delete(3));
		System.out.println("contains 5:"+tree22.contains(5));
		System.out.println("contains 7:"+tree22.contains(7));
		System.out.println("contains 9:"+tree22.contains(9));
		System.out.println("contains 3:"+tree22.contains(3));
		System.out.println("\n");
		
		/**
		 * txt23
		 */
		System.out.println("*txt23*");
		int[] b={1,2,3,4,5,6,7};
		AvlTree tree23= new AvlTree(b);
		System.out.println("size: "+tree23.size());
		System.out.println("contain 1: "+tree23.contains(1));
		System.out.println("contain 2: "+tree23.contains(2));
		System.out.println("contain 3: "+tree23.contains(3));
		System.out.println("contain 4: "+tree23.contains(4));
		System.out.println("contain 5: "+tree23.contains(5));
		System.out.println("contain 6: "+tree23.contains(6));
		System.out.println("contain 7: "+tree23.contains(7));
		System.out.println("\n");
		
		/**
		 * txt24
		 */
		System.out.println("*txt24*");
		int[] c={10,8,5,2,3,1,9,7,4,6};
		AvlTree tree24= new AvlTree(c);
		System.out.println("size: "+tree24.size());
		System.out.println("contain 1: "+tree24.contains(1));
		System.out.println("contain 2: "+tree24.contains(2));
		System.out.println("contain 3: "+tree24.contains(3));
		System.out.println("contain 4: "+tree24.contains(4));
		System.out.println("contain 5: "+tree24.contains(5));
		System.out.println("contain 6: "+tree24.contains(6));
		System.out.println("contain 7: "+tree24.contains(7));
		System.out.println("contain 8: "+tree24.contains(8));
		System.out.println("contain 9: "+tree24.contains(9));
		System.out.println("contain 10: "+tree24.contains(10));
		System.out.println("\n");
		
		/**
		 * txt25
		 */
		System.out.println("*txt25*");
		int[] d={2,3,8,4,1,6,5,7};
		AvlTree tree25= new AvlTree(d);
		System.out.println("size: "+tree25.size());
		System.out.println("contain 1: "+tree25.contains(1));
		System.out.println("contain 2: "+tree25.contains(2));
		System.out.println("contain 3: "+tree25.contains(3));
		System.out.println("contain 4: "+tree25.contains(4));
		System.out.println("contain 5: "+tree25.contains(5));
		System.out.println("contain 6: "+tree25.contains(6));
		System.out.println("contain 7: "+tree25.contains(7));
		System.out.println("contain 8: "+tree25.contains(8));
		System.out.println("\n");
		
		/**
		 * txt26
		 */
		System.out.println("*txt26*");
		int[] e={6,3,8,2,5,7,10,1,4,9,11};
		AvlTree tree26= new AvlTree(e);
		System.out.println("size: "+tree26.size());
		System.out.println("contain 1: "+tree26.contains(1));
		System.out.println("contain 2: "+tree26.contains(2));
		System.out.println("contain 3: "+tree26.contains(3));
		System.out.println("contain 4: "+tree26.contains(4));
		System.out.println("contain 5: "+tree26.contains(5));
		System.out.println("contain 6: "+tree26.contains(6));
		System.out.println("contain 7: "+tree26.contains(7));
		System.out.println("contain 8: "+tree26.contains(8));
		System.out.println("contain 9: "+tree26.contains(9));
		System.out.println("contain 10: "+tree26.contains(10));
		System.out.println("contain 11: "+tree26.contains(11));
		System.out.println("delete 6:"+tree26.delete(6));
		System.out.println("size: "+tree26.size());
		System.out.println("contain 1: "+tree26.contains(1));
		System.out.println("contain 2: "+tree26.contains(2));
		System.out.println("contain 3: "+tree26.contains(3));
		System.out.println("contain 4: "+tree26.contains(4));
		System.out.println("contain 5: "+tree26.contains(5));
		System.out.println("contain 6: "+tree26.contains(6));
		System.out.println("contain 7: "+tree26.contains(7));
		System.out.println("contain 8: "+tree26.contains(8));
		System.out.println("contain 9: "+tree26.contains(9));
		System.out.println("contain 10: "+tree26.contains(10));
		System.out.println("contain 11: "+tree26.contains(11));
		System.out.println("\n");
		
		/**
		 * txt27
		 */
		System.out.println("*txt27*");
		int[] f={5,3,10,2,4,8,12,1,7,9,11,6,13};
		AvlTree tree27= new AvlTree(f);
		System.out.println("size: "+tree27.size());
		System.out.println("contain 1: "+tree27.contains(1));
		System.out.println("contain 2: "+tree27.contains(2));
		System.out.println("contain 3: "+tree27.contains(3));
		System.out.println("contain 4: "+tree27.contains(4));
		System.out.println("contain 5: "+tree27.contains(5));
		System.out.println("contain 6: "+tree27.contains(6));
		System.out.println("contain 7: "+tree27.contains(7));
		System.out.println("contain 8: "+tree27.contains(8));
		System.out.println("contain 9: "+tree27.contains(9));
		System.out.println("contain 10: "+tree27.contains(10));
		System.out.println("contain 11: "+tree27.contains(11));
		System.out.println("contain 12: "+tree27.contains(12));
		System.out.println("contain 13: "+tree27.contains(13));
		System.out.println("delete 2:"+tree27.delete(2));
		System.out.println("size: "+tree27.size());
		System.out.println("contain 1: "+tree27.contains(1));
		System.out.println("contain 2: "+tree27.contains(2));
		System.out.println("contain 3: "+tree27.contains(3));
		System.out.println("contain 4: "+tree27.contains(4));
		System.out.println("contain 5: "+tree27.contains(5));
		System.out.println("contain 6: "+tree27.contains(6));
		System.out.println("contain 7: "+tree27.contains(7));
		System.out.println("contain 8: "+tree27.contains(8));
		System.out.println("contain 9: "+tree27.contains(9));
		System.out.println("contain 10: "+tree27.contains(10));
		System.out.println("contain 11: "+tree27.contains(11));
		System.out.println("contain 12: "+tree27.contains(12));
		System.out.println("contain 13: "+tree27.contains(13));
		System.out.println("\n");
		
		/**
		 * txt28
		 */
		System.out.println("*txt28*");
		int[] g={2,1,1};
		AvlTree tree28= new AvlTree(g);
		System.out.println("size: "+tree28.size());
		System.out.println("contain 1: "+tree28.contains(1));
		System.out.println("\n");

		/**
		 * txt29
		 */
		System.out.println("*txt29*");
		int[] h={3,4,2,1};
		AvlTree tree29= new AvlTree(h);
		System.out.println("size: "+tree29.size());
		System.out.println("contain 1: "+tree29.contains(1));
		System.out.println("delete 4:"+tree29.delete(4));
		System.out.println("contain 2: "+tree29.contains(2));
		System.out.println("delete 4:"+tree29.delete(4));
		System.out.println("\n");

		/**
		 * test nir
		 */
		System.out.println("*test nir*");
		int[] i = {10,11,9,12,8};
		AvlTree tree30= new AvlTree(i);
		System.out.println("size: "+tree30.size());
		System.out.println("contain 10: "+tree30.contains(10));
		System.out.println("contain 11: "+tree30.contains(11));
		System.out.println("contain 9: "+tree30.contains(9));
		System.out.println("contain 12: "+tree30.contains(12));
		System.out.println("contain 8: "+tree30.contains(8));
		System.out.println("delete 10:"+tree30.delete(10));
		System.out.println("size: "+tree30.size());
		System.out.println("contain 10: "+tree30.contains(10));
		System.out.println("contain 11: "+tree30.contains(11));
		System.out.println("contain 9: "+tree30.contains(9));
		System.out.println("contain 12: "+tree30.contains(12));
		System.out.println("contain 8: "+tree30.contains(8));
		System.out.println("\n");

		/**
		 * test oded
		 */
		System.out.println("*test oded*");
		int[] k = {1,2,3,19,84,5,28,27,26,96,91,92,45,8};
		AvlTree tree31= new AvlTree(k);
		System.out.println("size: "+tree31.size());
		System.out.println("contain 1: "+tree31.contains(1));
		System.out.println("contain 2: "+tree31.contains(2));
		System.out.println("contain 3: "+tree31.contains(3));
		System.out.println("contain 19: "+tree31.contains(19));
		System.out.println("contain 84: "+tree31.contains(84));
		System.out.println("contain 5: "+tree31.contains(5));
		System.out.println("contain 28: "+tree31.contains(28));
		System.out.println("contain 27: "+tree31.contains(27));
		System.out.println("contain 26: "+tree31.contains(26));
		System.out.println("contain 96: "+tree31.contains(96));
		System.out.println("contain 91: "+tree31.contains(91));
		System.out.println("contain 92: "+tree31.contains(92));
		System.out.println("contain 45: "+tree31.contains(45));
		System.out.println("contain 8: "+tree31.contains(8));

		System.out.println("delete 3:"+tree31.delete(3));
		System.out.println("contain 1: "+tree31.contains(1));
		System.out.println("contain 2: "+tree31.contains(2));
		System.out.println("contain 3: "+tree31.contains(3));
		System.out.println("contain 19: "+tree31.contains(19));
		System.out.println("contain 84: "+tree31.contains(84));
		System.out.println("contain 5: "+tree31.contains(5));
		System.out.println("contain 28: "+tree31.contains(28));
		System.out.println("contain 27: "+tree31.contains(27));
		System.out.println("contain 26: "+tree31.contains(26));
		System.out.println("contain 96: "+tree31.contains(96));
		System.out.println("contain 91: "+tree31.contains(91));
		System.out.println("contain 92: "+tree31.contains(92));
		System.out.println("contain 45: "+tree31.contains(45));
		System.out.println("contain 8: "+tree31.contains(8));
		System.out.println("\n");

	}
	

}
