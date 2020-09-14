import java.util.*;
import java.io.*;

public class Benchmarking {
	
	public static void main(String args[]) throws FileNotFoundException {
		LinkedList<Integer> sortedNums = new LinkedList<Integer>();
		
		Scanner console = new Scanner(System.in);
		String fileName = "";
		
		if (args.length == 0) {
			System.out.println("What is the input file name?");
			fileName = console.next();
			
		} else {
			fileName = args[0];
			System.out.println(args[0]);
			
		}
		
		File inFile = new File(fileName);
		Scanner readFile = new Scanner(inFile);
		
		sortedNums = intoLL(readFile, sortedNums);
		findMMM(sortedNums);
	}
	
	public static LinkedList<Integer> intoLL(Scanner readFile, LinkedList<Integer> sortedNums) {
		Set<Integer> sort = new TreeSet<>();
		
		while (readFile.hasNext()) {
			int curr = readFile.nextInt();
			sort.add(curr);
			
		}
		
		for (Integer num : sort) {
			sortedNums.add(num);
		}
		System.out.println(sortedNums);
		return sortedNums;
	}
	
	public static void findMMM(LinkedList<Integer> sortedNums) {
		int max = sortedNums.getLast();
		int min = sortedNums.getFirst();
		int median = 0;
		int size = sortedNums.size();
		
		if (size  % 2 == 0) {
			for (int i = 0; i <= (size / 2 - 1); i++) {
				if (i == size / 2 - 1) {
					median = (sortedNums.get(i) + sortedNums.get(i - 1)) / 2;
				}
			}
		} else {
			median = sortedNums.get(size / 2);
		}
		System.out.println(max + ", " + min + ", " + median);
	}
	
//	private static class LinkedIntNode {
//		public LinkedIntNode next;
//		public int data;
//		
//		public LinkedIntNode(int data) {
//			this.data = data;
//		}
//		
//		public LinkedIntNode(int data, LinkedIntNode node) {
//			this.data = data;
//			this.next = node;
//		}
//		
//		public static void add(LinkedIntNode)
//	}
}
