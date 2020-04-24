package yodafy;

import java.util.*;
import java.io.*;

public class Yodafy 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		//declare variables
		int location = 0;		   //location of the phrases place in the sentence
		String sentence;			 //User entered sentence
		String sentenceTo_lowercase;//Sentence to lowercase
		String firstPart;		   //First part of final_yodafied
		String secondPart;		   //Second part of final_yodafied
		String endingPart;		   //holds hmm? yes? or no?
		String firstLetter;		   //First letter to uppercase
		String final_yodafied;      //Sentence that yoda would say
		int random_num = 0;		   //Random number for Ending number
		int number = 0; 		   //holds the position of a certain phrase

		//Scanner
		Scanner input = new Scanner (new File("userInput.txt"));

		//phrases in the sentence
		String [] phrases = {" is not "," is "," are not "," are ", " will not be ", " will not "," will "," was not ","  was "};

		//loops through the array
		while (input.hasNext())
		{
			sentence = input.nextLine();

			//check for the phrase
			while (number < phrases.length && sentence.indexOf(phrases[number]) == -1)
			{
				number++;
			}

			if (number == phrases.length)
			{
				System.out.print(sentence+ " - this is non-yodafiable\n");
			}
			//Ending String
			else 
			{
				random_num = (int)(Math.random() * 3) + 1;
				if (random_num == 1)
				{
					endingPart = "hmm?";
				}	
				else if (random_num == 2)
				{
					endingPart = "yes?";
				}	
				else
				{
					endingPart = "no?";
				}

				location = sentence.indexOf(phrases[number]);
				sentenceTo_lowercase = sentence.toLowerCase();
				
				//rearrange the sentence to what yoda would say
				firstPart = sentenceTo_lowercase.substring(0, location + phrases[number].length() - 1);
				secondPart = sentenceTo_lowercase.substring(location + phrases[number].length() ,sentenceTo_lowercase.length());
				final_yodafied = secondPart.substring(1 , secondPart.length()) + " " + firstPart;

				//first letter uppercase
				firstLetter = secondPart.substring(0,1);

				//Output
				System.out.println(sentence.toLowerCase());
				System.out.println(firstLetter.toUpperCase() + final_yodafied+ ", " + endingPart+ "\n");
			}
		}
	}
}
/*
Example Output:

this sentence is yodafiable
Yodafiable this sentence is, yes?

rudra is amazing
Amazing rudra is, yes?

we will rock you
Rock you we will, no?

astrology is not a valid way of thinking
A valid way of thinking astrology is not, hmm??

we are the champions
The champions we are, yes?

I want to be a cowboy - this is non-yodafiable

-------------------------------------------------------
Contents in the text file: 

thIs sentenCe is yoDafiAble
Rudra is amazing
We will rock you
Astrology is not a valid way of thinking
We are the champions
I want to be a cowboy
*/