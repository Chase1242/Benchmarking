import java.util.*;
import java.io.*;

public class Benchmarking {
	
	public static void main(String args[]) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		String fileName = "";
		if (args == null) {
			System.out.println("What is the input file name?");
			fileName = console.next();
		} else {
			fileName = args[0];
			System.out.println(args[0]);
		}
		File inFile = new File(fileName);
		Scanner readFile = new Scanner(inFile);
	}
	
}
