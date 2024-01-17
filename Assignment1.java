import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
/*
 * Owen Millspaugh
 * CS1450-003
 * Assignment #: 1
 * Due date : 01/29/24
 * Program Overview: Program used to create an file and generate 100 random numbers to
 * write onto the file, then reopen the file and display the values in different formats
  */

public class Assignment1 {

	public static void main(String[] args) throws IOException {
		
//Task 1 - Writing random numbers to a file and displaying the values
		
		System.out.println("Starting Task 1...");
		System.out.println("");
		
		//Create a file called assignment1
		File fileName = new File("assignment1.txt");
		
		//Create a printWrite object to write to file
		PrintWriter fileWriter = new PrintWriter(fileName);
		
		//Create Random object to generate random numbers
		Random rand = new Random();
		
		//Create int variable to hold random number generated
		int randInt = 0;
		
		//Create for loop to handle number generation, file write and display values
		for(int i = 0; i < 25; i++) {
			randInt = rand.nextInt(101);
			fileWriter.println(randInt);
			System.out.println("Written to File: " + randInt);
		}
		
		//close the file after writing to file
		fileWriter.close();
		
		System.out.println("");
		System.out.println("Task 1 complete. Starting Task 2...");
		System.out.println("");
		
		
		//Task 2 - Manipulate values placed in an array then display values
		
		//Create a scanner to read the closed file
		Scanner inputFile = new Scanner(fileName);
		
		//Create an array to hold the values read from the file
		int[] randIntArray = new int[25];
		
		//for loop to read values in from file and assign to array
		for(int i = 0; i < 25; i++) {
			randIntArray[i] = inputFile.nextInt();
			System.out.println("Value at [" + i + "]: " + randIntArray[i]);
		}
		
		//Find the two largest distinct numbers
		int largestNum = 0;
		int secondNum = 0;
		int compareVal = 0;
		
		//Create for loop to sort through array values to find largest numbers
		for (int i = 0; i < randIntArray.length; i++) {
		    compareVal = randIntArray[i];
		    if (compareVal > largestNum) {
		        secondNum = largestNum;
		        largestNum = compareVal;
		    } else if (compareVal > secondNum && compareVal != largestNum) {
		        secondNum = compareVal;
		    }
		}

		
		//Display largest numbers
		System.out.println("");
		System.out.println("The Largest Number in Array is: " + largestNum);
		System.out.println("The Second Largest Number is: " + secondNum);
		System.out.println("");
		
		//Sort the array from largest to smallest
		Arrays.sort(randIntArray);
		
		System.out.println("Displaying Values in Descending Order...");
		
		//create temp array to sort numbers
		int[] sortArray = new int[25];
		int arrayIndex = 24;
		
		//Sort randIntArray into descending order
		for(int i = 0; i < randIntArray.length; i++) {
			sortArray[i] = randIntArray[arrayIndex];
			arrayIndex -= 1;
		}
		
		//Copy descending order array back into original array
		for(int i = 0; i < randIntArray.length; i++) {
			randIntArray[i] = sortArray[i];
		}
		
		//Display sorted Array
 			for(int i = 0; i < randIntArray.length; i++) {
			System.out.println("RandIntArray[" + i + "]: " + randIntArray[i]);
		}
		
		
		inputFile.close();
		
	}

}
