/**
 * 
 */
package rockpaperscissors;

import java.util.Scanner;

/**
 * Contains methods that will prevent the user from inputing incorrect
 * information into the scanner and the console.
 * 
 * @author Karanvir
 *
 */
public class Interface {

	private Scanner scanner = new Scanner(System.in);

	/**
	 * Receive input from the user, and check the input against all of the allowed
	 * inputs.
	 *
	 * @param message
	 *            The message to show the user before taking input.
	 * @param possibleInputs
	 *            All of the allowed inputs.
	 * @return Returns the first allowed input made by the user.
	 */
	public String getInput(String message, String... possibleInputs) {
		// Show the message
		printLine(message);

		// Loop as long as the user haven't entered an allowed input
		String input;
		while (true) {
			// Read input from our scanner
			input = scanner.nextLine();

			// If the input is allowed then break out of the while loop
			if (isAllowedInput(input, possibleInputs))
				break;
			else
				printLine("Invalid input!\n" + message);
		}

		return input;
	}

	/**
	 * Checks if 'input' is equal to one of the allowed inputs.
	 *
	 * @param input
	 *            Input made by the user.
	 * @param possibleInputs
	 *            All allowed inputs.
	 * @return Returns true if the input is allowed.
	 */
	private boolean isAllowedInput(String input, String[] possibleInputs) {
		for (int i = 0; i < possibleInputs.length; i++)
			if (input.equals(possibleInputs[i]))
				return true;
		return false;
	}

	/**
	 * Shows a message to the user through the console.
	 *
	 * @param line
	 *            The message to show.
	 */
	public void printLine(String line) {
		System.out.println(line);
	}

}
