package package1;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class SortingAlgorithms {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		boolean check = false;	
		
		int index = 0;
		
		while (check == false) {
			
			System.out.print("Input a random number between 5 and 10: ");
			index = input.nextInt();
			
			if (index < 5 || index > 10) {
				System.out.println("Error - your input must be between 5 and 10");
			}
			else {
				check = true;
			}
		}
		
		System.out.println("A list with " + index + " elements will now be generated: ");
		int[] list = genList(index);
		
		printList(list);
		
		check = false;
		while (check == false) {
			System.out.print("Input 1 to do a bubble sort, input 2 to do a selection sort, input 3 to do a merge sort: ");
			int select = input.nextInt();
			if (select == 1) {
				System.out.println("The program will now do a bubble sort: ");
				bubble(list);
				check = true;
			}
			else if (select == 2) {
				System.out.println("The program will now do a selection sort: ");
				selection(list);
				check = true;
			}
			else if (select == 3) {
				System.out.println("The program will now do a merge sort: ");
				split(list);
				check = true;
			}
			else {
				System.out.println("Error - you must input 1, 2 or 3");
			}
		}
		
		input.close();
	
	}
	
	public static void printList(int[] list) {
		System.out.print( "{" );
		for (int i = 0; i < list.length; i++) {
			if (i > 0) {
				System.out.print( ", " );
			}
			System.out.print(list[i]);
		}
		System.out.println( "}" );
	}
	
	public static int[] genList(int index) {
		Random rand = new Random();		
		
		ArrayList<Integer> alist = new ArrayList<>();
		
		for (int i = 0; i < index; i++) {
			alist.add(rand.nextInt(11));
		}
		
		int[] list = new int[alist.size()];
	    for (int i = 0; i < list.length; i++)
	    {
	        list[i] = alist.get(i);
	    }
	    
		return list;
	}
	
	public static int[] bubble(int[] list) {
		boolean sorted = false;
		
		while (sorted == false) {
			int count = 0;
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] > list[i+1]) {
					count = count + 1;
					int store = list[i];
					list[i] = list[i+1];
					list[i+1] = store;
				}
				printList(list);
			}
			sorted = checkSorted(count, list);
		}
		
		return list;
	}
	
	public static int[] selection(int[] list) {
		boolean sorted = false;
		
		while (sorted == false) {
			int count = 0;
			for (int i = 0; i < list.length; i++) {
				for (int j = (i + 1); j < list.length; j++) {
					if (list[i] > list[j]) {
						count = count + 1;
						int temp = list[i];
						list[i] = list[j];
						list[j] = temp;
						j = list.length;
					}				
				}
				printList(list);
			}
			sorted = checkSorted(count, list);
			}
		
		return list;
	}
	
	public static boolean checkSorted(int count, int[] list) {
		boolean sorted = false;
		
		if (count == 0) {
			System.out.println("Here is the sorted list: ");
			printList(list);
			sorted = true;
		}
		
		return sorted;
	}
	
	public static int[] split(int[] list) {
		if (list.length > 1) {
			int size1 = ((list.length) / 2) + (list.length % 2);
			int size2 = list.length - size1;
			
			int[] split1 = new int[size1];
			int[] split2 = new int[size2];
			
			for (int i = 0; i < split1.length; i++) {
				split1[i] = list[i];
			} 
			for (int i = 0; i < split2.length; i++) {
				split2[i] = list[size1 + i];
			}	
			
			split1 = split(split1);
			split2 = split(split2);	
	
			list = combine(split1, split2);
		}
		
		printList(list);
		
		return list;
	}
	
	public static int[] combine(int[] list1, int[] list2) {		
		int[] combined = new int[list1.length + list2.length]; 
		int index = 0;
		int track = 0;
		
		for (int i = 0; i < list2.length; i++) {
			for (int j = track; j < list1.length; j++) {
				if (list2[i] > list1[j]) { 
					combined[index] = list1[j];
					track++;
					index++;					
				}
			}
			combined[index] = list2[i];
			index++;
		}
		for (int i = track; i < list1.length; i++) {
			combined[index] = list1[i];
			index++;
		}
				
		return combined;
	}
}
