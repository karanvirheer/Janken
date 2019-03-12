/**
 * 
 */
package rockpaperscissors;

/**
 * Contains methods that will be used to prompt the user to pick a weapon, and
 * the ability to save the weapon choosed.
 * 
 * @author Karanvir
 *
 */
public class User {

	// Calling the other classes
	private Interface io;
	public Weapon weapon;

	// Constructor
	public User() {
		io = new Interface();
	}

	/**
	 * Prompts user to select a weapon and makes the weapon equal to whatever the
	 * user has chosen
	 * 
	 * @return userWeapon The weapon that the user chose.
	 */
	public String pickWeapon() {

		String userWeapon = io.getInput("---- Pick your weapon: | Rock " + "| Paper | Scissors | -----", "Rock",
				"Paper", "Scissors");

		// Makes the users weapon equal to whichever weapon they inputed
		switch (userWeapon) {
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
		return userWeapon;

	}

	/**
	 * Gets the weapon that the user has chosen.
	 * 
	 * @return weapon The weapon that was chosen.
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * Assigns io the attributes of the Interface class
	 * 
	 * @param io
	 *            The interface object.
	 */
	public User(Interface io) {
		this.io = io;
	}
}
