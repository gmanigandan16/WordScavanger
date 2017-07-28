package com.pramati.wordscavanger.functionalities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functionalities {

	Scanner input;

	public int countNoOfChars(File file) throws FileNotFoundException {
		int charsCount = 0;
		input = new Scanner(file);
		while (input.hasNextLine()) {
			String line = input.nextLine();

			charsCount = charsCount + line.replaceAll("\\s", "").length();
		}
		return charsCount;
	}

	public int countNoOfWords(File file) throws FileNotFoundException {
		int wordsCount = 0;
		input = new Scanner(file);
		while (input.hasNext()) {
			input.next();
			wordsCount++;
		}
		return wordsCount;
	}

	public int countNoOfSentences(File file) throws FileNotFoundException {
		int SentencesCount = 0;
		input = new Scanner(file);
		while (input.hasNextLine()) {
			String value = input.nextLine();
			SentencesCount = SentencesCount + value.split("[!?.:]+").length;
		}
		return SentencesCount;
	}

	public void printOccurancesOfPattern(File file, String pattern) throws FileNotFoundException {
		input = new Scanner(file);
		int lineNo = 0, count = 0;
		Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

		while (input.hasNextLine()) {
			lineNo++;
			Matcher m = p.matcher(input.nextLine());
			while (m.find()) {
				System.out.println("Pattern found at position : " + m.start() + " line No: " + lineNo);
				count++;
			}
		}
		if (count == 0)
			System.out.println("Pattern is not present in the file");
	}

}
