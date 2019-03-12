package rockpaperscissors;

import java.util.Scanner;

/**
 * Contains all the prompts that allow the user to control the program to their
 * choosing.
 * 
 * @author Karanvir
 *
 */

public class ConsolePrompts {

	/**
	 * Prompts the user to input how many rounds they would like to play.
	 * 
	 * @return rounds The amount of rounds inputed by the user.
	 */
	public int rndPrompt() {

		int rounds = 0;

		Scanner reader = new Scanner(System.in);

		System.out.println("\nROUND SELECTION---------------- " + "\nInput Amount of Rounds to Play:");

		rounds = reader.nextInt();

		reader.nextLine();

		return rounds;
	}

	/**
	 * Prompts the user to choose whether they would like to play against a computer
	 * themselves, or have the computer go up against another computer and watch the
	 * match between the two AI.
	 * 
	 * @return choice The choice that the user made for this prompt.
	 */
	public int PlyrOrComp() {

		int choice = 0;

		Scanner reader = new Scanner(System.in);

		System.out.println("\nTYPE OF GAME ---------------- " + "\n0. Play against Computer"
				+ "\n1. Simulate Computer vs Computer");

		choice = reader.nextInt();

		reader.nextLine();

		return choice;
	}

	/**
	 * Prompts the user to choose whether they would like to play against a computer
	 * with a strategy, or a computer that randomly makes its choices.
	 * 
	 * @return choice The choice that the user made for this prompt.
	 */
	public int playerPrompt() {

		int choice = 0;

		Scanner reader = new Scanner(System.in);

		System.out.println(
				"\nPICK YOUR OPPONENT ---------------- " + "\n0. VS Strategic Computer" + "\n1. VS Random Computer");

		choice = reader.nextInt();

		reader.nextLine();

		return choice;

	}

	/**
	 * Prompts the user if they would like to see two computers with strategies
	 * fight, one computer with a strategy and one that chooses random weapons
	 * fight, or two computers that both choose random weapons fight.
	 * 
	 * @return choice The choice that the user made for this prompt.
	 */
	public int compPrompt() {
		int choice = 0;

		Scanner reader = new Scanner(System.in);

		System.out.println("\nPICK YOUR SIMULATION ---------------- " + "\n0. Strategic Computer VS Strategic Computer"
				+ "\n1. Strategic Computer VS Random Computer" + "\n2. Random vs Random");

		choice = reader.nextInt();

		reader.nextLine();

		return choice;
	}

}
