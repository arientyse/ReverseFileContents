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
		
		//Input 
		
		
		//Computation
		
		
		//Output

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

}
