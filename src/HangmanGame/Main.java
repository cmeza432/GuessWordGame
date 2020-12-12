package HangmanGame;

import java.util.Scanner;

public class Main {
	
	// Function to check if letter is present in guess word
	public static boolean checkLetter(char input, String guessWord) {
		boolean isPresent = false;
		// Loop and check if input is present in temp word
		for(int i = 0; i < guessWord.length(); i++) {
			if(input == guessWord.charAt(i)) {
				isPresent = true;
			}
		}
		return isPresent;
	}
	
	public static void main(String[] args) {
		// Word to be guess word, user has to find all correct letters
		String guessWord = "Vizient";
		// Check if user has won
		boolean isWinner = false;
		// Create a board instance
		Board board = new Board(guessWord.length(), guessWord);
		
		// Build the user interface with Scanner
		Scanner in = new Scanner(System.in);
		// Output hello message for beginning of game
		board.getHelloMessage();
		
		// Loop game until user presses q or Q
		while(board.getNumberOfTries() >= 0) {
			// Get the letter pressed by user from input
			char input = in.next().charAt(0);
			input = Character.toLowerCase(input);
			
			// Check if user request exit game 
			if(input == 'q') {
				System.out.println("Nice Try! Play again soon.");
				break;
			}
			
			// Check if letter is Present
			boolean isPresent = checkLetter(input, board.getTempGuessWord());
			// If letter is present update the board, if not then increment wrong tries
			if(isPresent) {
				board.updateBoard(guessWord, input);
			} else {
				// Update number of tries
				board.setNumberOfTries();
			}
			
			// Check if user won game
			if(guessWord.equals(board.getBoard().replaceAll("\\s", ""))) {
				isWinner = true;
				break;
			}
		}
		
		// Check result of match, and display if user won or not
		if(isWinner) {
			System.out.println("Congratulations!! You Won!!! Try again.");
		} else {
			System.out.println("Oh no! You Lost!!! Try again.");
		}
	}
}
