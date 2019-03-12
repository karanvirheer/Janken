/**
 * 
 */
package rockpaperscissors;

/**
 * Contains the hierarchy of power for Rock.
 * 
 * @author Karanvir
 *
 */
public class Rock extends Weapon {

	@Override
	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object) This methods compares
	 *      the weapons to see which is stronger.
	 * @return Return 0 if we are equally strong. Return 1 if we are stronger.
	 *         Return -1 if we are weaker
	 */
	public int compareTo(Weapon o) {

		// If o (the weapon) is equal to Rock
		// then Rock has an instanceof Rock
		// thus if True, return 0
		if (o instanceof Rock)
			return 0;

		else if (o instanceof Scissors)
			return 1;

		return -1;
	}

	/**
	 * Converts weapon to String
	 * 
	 * @return Returns the word rock
	 */
	public String toString() {

		return "Rock";

	}

}
