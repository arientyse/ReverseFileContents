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
		
		
		//Input 
		
		
		//Computation
		
		boolean done = false;
		
		//Output
		
		while(!done)
		{
			
			try {
				
				System.out.print("Please enter the file name for input: ");
				inputFileName = in.next();
				
				ArrayList<String> lines = readFile(inputFileName);
				
				System.out.print("Please enter file name for output: ");
				outputFileName = in.next();
				
				writeInReverse(outputFileName, lines);
				
				done = true;
				
				in.close();
								
			}
			
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
	
	public static ArrayList<String> readFile(String filename) throws IOException
	
	{
		File inFile = new File(filename);
		try (Scanner in = new Scanner(inFile))
		{
				
			return readLinesOfArray(in);
			
		}
		
		
	}
	
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
