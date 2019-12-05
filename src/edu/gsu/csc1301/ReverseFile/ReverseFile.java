package edu.gsu.csc1301.ReverseFile;

/**
 * 
 * This program with take in a file as input, reverse the order of the lines with in the file,
 * and produce an output file with the new order of the lines.
 * 
 * @author Ariana Tyson
 * @version 12/2/2019
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class ReverseFile {
	
	static void main(String[] args) 
	{
		
		Scanner in = new Scanner(System.in);
		
		String inputFileName;
		String outputFileName;
		
		
		//Computation
		
		boolean done = false;
		
		//Output
		
		while(!done)
		{
			
			try {
				
				System.out.print("Please enter the file name for input: "); //Prompts the user to enter a file name for input
				inputFileName = in.next();
				
				ArrayList<String> lines = readFile(inputFileName); //The system reads the input file
				
				System.out.print("Please enter file name for output: "); //Prompts the user to enter a name for output
				outputFileName = in.next();
				
				writeInReverse(outputFileName, lines); //Runs the writeInReverse() method to reverse the order of input lines
				
				done = true;
				
				in.close();
								
			}
			
			//Exception handling output statement are below
			
			catch (FileNotFoundException exception)
			{
				
				System.out.println("File not found.");
				
			}
			
			catch (NoSuchElementException exception)
			{
				
				System.out.println("File contents invalid.");
				
			}
			
			catch (IOException exception)
			{
				exception.printStackTrace();
			}
			
		}

	}
	
	/*
	 * 
	 * This method crates an ArrayList of type String for the lines of the input file to be stores in
	 * 
	 * @param filename
	 * 
	 * @return readLinesofArray()
	 * 
	 */
	
	public static ArrayList<String> readFile(String filename) throws IOException
	
	{
		File inFile = new File(filename);
		try (Scanner in = new Scanner(inFile))
		{
				
			return readLinesOfArray(in);
			
		}
		
		
	}
	
	/*
	 * 
	 * This method creates the ArrayList<String> lines and stores the lines of the input file into the list
	 * 
	 * @param in
	 * 
	 * @return lines
	 * 
	 */
	
	public static ArrayList<String> readLinesOfArray(Scanner in)
	{
		
		ArrayList<String> lines = new ArrayList<String>();
		
		while(in.hasNextLine())
		{
			lines.add(in.nextLine());
		}
		
		in.close();
		
		return lines;
		
	}

	/*
	 * 
	 * This method uses the created ArrayList to reverse the order of the lines in the original input file
	 * 
	 * @param filename, lines
	 * 
	 */
	
	public static void writeInReverse(String filename, ArrayList<String> lines)
	{
		
		try (PrintWriter out = new PrintWriter(new File(filename)))
		{
			
			for (int i = lines.size() - 1; i >= 0; i--)
			{
				out.println(lines.get(i));
			}
			
			out.close();
			
		}
		
		catch (FileNotFoundException exception)
		{
			
			System.out.println("This file could not be opened for writing. Please try again!" + filename);
			
		}
		
	}
	
	
	
}
