package com.pramati.wordscavanger.console;

import java.io.File;
import java.util.Scanner;

import com.pramati.wordscavanger.functionalities.Functionalities;

public class ConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);
		Functionalities func = new Functionalities();
		File file = new File("Sample.txt");
		try {
			System.out.println("No of Characters in the file : " + func.countNoOfChars(file));
			System.out.println("No of Words in the file : " + func.countNoOfWords(file));
			System.out.println("No of sentences in the file : " + func.countNoOfSentences(file));

			System.out.println("Enter the String that you want to search in the file: ");
			String input = scr.nextLine();
			func.printOccurancesOfPattern(file, input);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
