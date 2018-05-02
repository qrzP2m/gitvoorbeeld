import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Hangman {

	static int remainingGuesses = 6;	
	
	static String solution = "linux"; //this is the solution of the game.
	static ArrayList<Character> solutionArr = new ArrayList<Character>();

	static int correctGuesses;
	
	static ArrayList<Character> solutionList = new ArrayList<Character>(solution.length()); //dit zijn de correct geraden letters
	
	public static void main(String[] args) {

		System.out.println("Welcome to a game of hangman. You have 6 guesses to guess the word.");
	
		nextRound();

	}
	
	static void nextRound() {
		if(remainingGuesses > 0) {
			System.out.println("Guess a character");
			registerInput();
		} else {
			System.out.println("You have lost.");
		}


	}

	static void registerInput() {
		Scanner input = new Scanner(System.in);
		
		char guess = input.next().charAt(0);

		vergelijking(guess, solution);
	}

	static void vergelijking(char guess, String solution) {
		if((solution.indexOf(guess)) != -1) {
			System.out.println("That is correct.");
			solutionList.add(guess);
			System.out.println("Your correct guesses are:" );
			System.out.println(Arrays.toString(solutionList.toArray()));
			correctGuesses++;

		} else {
			System.out.println("That is wrong!");
			remainingGuesses--;
			System.out.println("You have " + remainingGuesses + " remaining guesses.");
	}	
		winCheck();	
	}

	static void winCheck() {
		if(correctGuesses > 4) {
			endGame();
		} else {
			nextRound();
	}
	}

	static void endGame() {
		System.out.println("Congratulations! You have finished the game!");
		System.out.println("The correct word was linux!");

	}
}
