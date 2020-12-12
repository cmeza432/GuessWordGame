package HangmanGame;

public class Board {
	
	private String board;
	private int numberOfTries = 5;
	private String tempGuessWord;

	// Constructor for creation of board
	public Board(int len, String guessWord) {
		String result = "";
		for(int i = 0; i < len; i++) {
			result += "_ ";
		}
		board = result;
		setTempGuessWord(guessWord);
	}

	// Board getter
	public String getBoard() {
		return board;
	}
	
	public String getTempGuessWord() {
		return tempGuessWord;
	}

	public void setTempGuessWord(String guessWord) {
		String lower = guessWord.toLowerCase();
		tempGuessWord = lower;
	}
	
	public void getHelloMessage() {
		System.out.println("\nWelcome to Hangman!! Please try to guess word by entering letters " +
				"then pressing Enter. Press q or Q to exit.\n" + board + "\n\nEnter Letter:  ");
	}
	
	public void wrongAnswer() {
		System.out.println("Oof! Letter is not in word. Try another one!\n" + board + 
				"\n\nEnter Letter:  ");
	}
	
	public void correctAnswer() {
		System.out.println("Correct! Try another one!\n" + board + 
				"\n\nEnter Letter:  ");
	}
	
	// Function to update board
	public void updateBoard(String guessWord, char input) {
		// Counter for board because its twice the size as guessWord
		int boardCounter = 0;
		// Convert to array to replace char
		char[] newBoard = board.toCharArray();
		
		// Loop through board and replace the letter that matches
		for(int i = 0; i < guessWord.length(); i++) {
			if(input == tempGuessWord.charAt(i)) {
				newBoard[boardCounter] = guessWord.charAt(i);
			}
			boardCounter += 2;
		}
		// Update board and print out correct answer message
		board = String.valueOf(newBoard);
		correctAnswer();
	}
	
	public int getNumberOfTries() {
		return numberOfTries;
	}

	public void setNumberOfTries() {
		numberOfTries--;
		wrongAnswer();
	}
}
