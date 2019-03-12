/**
 * 
 */
package rockpaperscissors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Contains methods for the Computer for all  possible outcomes of the match, from winning, losing, and drawing. 
 * 
 * @author Karanvir
 *
 */
public class Computer {

	private User player;
	public Weapon weapon;
	private Interface io;

	// Array containing every possible weapon
	public String[] weapArray = { "Rock", "Paper", "Scissors" };

	// Constructor
	public Computer() {
		player = new User(io);
		io = new Interface();
	}

	/**
	 * Randomly chooses a number between 0 and 2, then finds the weapon in that
	 * index from the weapArray, and then assigns that new weapon to the computer.
	 * 
	 * @return compChoice The new weapon that the computer is assigned
	 */
	public String randWeapon() {

		// Generates a random number.
		Random rand = new Random();

		// A random number between 0 and 2 is generated, and the value at that index in
		// the Choice array is then saved to the variable compChoice
		String compChoice = weapArray[rand.nextInt(3)];

		// Makes the users weapon equal to whichever weapon they inputed
		switch (compChoice) {

		case "Rock":
			weapon = new Rock();
			break;
		case "Paper":
			weapon = new Paper();
			break;
		case "Scissors":
			weapon = new Scissors();
			break;

		}
		return compChoice;
	}

	/**
	 * In case the Computer wins, the next weapon of the Computer will be the opponents last weapon 
	 * 
	 * @param comp2Choice
	 *            The weapon of the opponent
	 */
	public String winWeapon(String comp2Choice) {

		switch (comp2Choice) {

		case "Rock":
			weapon = new Rock();
			break;
		case "Paper":
			weapon = new Paper();
			break;
		case "Scissors":
			weapon = new Scissors();
			break;
		}
		return comp2Choice;
	}

	/**
	 * Takes both the players' choices from the last round, and chooses the weapon
	 * that neither played.
	 * 
	 * @param comp1Choice
	 *            The weapon of computer1
	 * @param comp2Choice
	 *            The weapon of computer2
	 * @return newCompWeap The new weapon that has been assigned to the computer
	 */
	public String loseWeapon(String comp1Choice, String comp2Choice) {

		// Make two lists, one that contains the choices made and other with all weapons
		List<String> chosenWeaps = Arrays.asList(comp1Choice, comp2Choice);
		List<String> allWeaps = Arrays.asList("Rock", "Paper", "Scissors");

		// Combine the two lists together in a union
		List<String> union = new ArrayList<String>(chosenWeaps);
		union.addAll(allWeaps);

		// Find where they intersect, aka find where they both have the same
		// variables inside
		List<String> intersection = new ArrayList<String>(chosenWeaps);
		intersection.retainAll(allWeaps);

		// Remove everything that matches
		union.removeAll(intersection);

		String newCompWeap = "";

		// Iterating through the union array
		for (String newWeapon : union) {

			switch (newWeapon) {
			case "Rock":
				weapon = new Rock();
				break;
			case "Paper":
				weapon = new Paper();
				break;
			default:
				weapon = new Scissors();
				break;
			}
			newCompWeap = newWeapon;
		}

		return newCompWeap;
	}

	/**
	 * Gets the weapon that the user has chosen.
	 * @return weapon The weapon that was chosen.
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * Assigns io the attributes of the Interface class
	 * @param io The interface object.
	 */
	public Computer(Interface io) {
		this.io = io;

	}

}
