/* 
 * Chase Conaway
 * CptS 233: Programming Assignment: Benchmarking.java
 * Date September 16nd, 2020
 * git repo url: https://github.com/Chase1242/Benchmarking.git
 * Takes a a file full of integers and finds the min, max, and median,
 * as well as the time it takes to find those things and the time it takes to sort all the numbers.
 */

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
	
	// Uses a scanner to read a file into a sorted linked list. Notable to mention it
	// can only handle a LL of ints
	// Parameters:
		// Scanner readFile: The file to read from
		// The linked list to sort the numbers into
	// Returns: LinkedList<Integer>: the sorted LinkedList
	public static LinkedList<Integer> intoLL(Scanner readFile, LinkedList<Integer> sortedNums) {
		long startTime = System.nanoTime(); // start timer
		
		while (readFile.hasNext()) {
			int curr = readFile.nextInt();
			
			if (sortedNums.isEmpty()) { // case: if LL is empty
				sortedNums.add(curr);
					
			} else {
				int index = -1; // setting the index to a random value
				boolean found = false;
				
				for (Integer temp : sortedNums) {
					if (!found) {
						if (curr < sortedNums.getFirst()) { 
							// checking if it should go in the first spot
							index = 0;
							found = true;
							
						} else if (curr < temp) {
							// checking if it should go somewhere in the middle of the list
							index = sortedNums.indexOf(temp);
							found = true;
							
						} else if (curr > sortedNums.getLast()) {
							// checking if it should go in the last spot
							index = sortedNums.size();
							found = true;
							
						}
					}
				}
				sortedNums.add(index, curr);
			}
		}
		long endTime = System.nanoTime(); // end time
		
		System.out.println("Time to insert in sorted order in nanoseconds is "
		+ (endTime - startTime));
		
		System.out.println("Time converted from nanoseconds to seconds is " + 
		(double)(endTime - startTime) / 1000000000 + " seconds");
		
		return sortedNums;
	}
	
	// Finds the min, median, and max of the whole list, as well as how
	// long it takes to find each of those things. Notable that it can only handle
	// integer linked lists.
	// Parameters:
		// LinkedList<Integer> sortedNums: the sorted list to find the min, median, and max from.
	// Returns: N/A
	public static void findMMM(LinkedList<Integer> sortedNums) {
		long startTime = System.nanoTime();
		
		int max = sortedNums.getLast(); // I know I sorted the list woth the max being at the end
		long findMax = System.nanoTime();
		
		int min = sortedNums.getFirst();// min is at front
		long findMin = System.nanoTime();
		
		double median = 0.0;
		int size = sortedNums.size();
		
		if (size  % 2 == 0) { 
			// when size is even, there is no distinct middle, take the two on either side and 
			// average the two
			median = (double)(sortedNums.get(size / 2) + sortedNums.get(size / 2 + 1)) / 2;
			
		} else {
			// when size is odd, there is a distinct middle
			median = (sortedNums.get(size / 2));
			
		}
		
		long findMedian = System.nanoTime();
		
		System.out.println("The max is " + max + ", "+ "The min is " +  + min + ", " 
		+ "The median is " +  + median);
		
		System.out.println("Time to find max is " + (findMax - startTime)
				+ " nanoseconds");
		
		System.out.println("Time to find min is " + (findMin - findMax)
				+ " nanoseconds");
		
		System.out.println("Time to find median is " + (findMedian - findMin)
				+ " nanoseconds");
	}
	
}
