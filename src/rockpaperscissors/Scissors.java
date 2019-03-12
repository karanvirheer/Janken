/**
 * 
 */
package rockpaperscissors;

/**
 * Contains the hierarchy of power for Scissors.
 * 
 * @author Karanvir
 *
 */
public class Scissors extends Weapon {

	@Override
	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object) This methods compares
	 *      the weapons to see which is stronger.
	 * @return Return 0 if we are equally strong. Return 1 if we are stronger.
	 *         Return -1 if we are weaker
	 */
	public int compareTo(Weapon o) {
		// TODO Auto-generated method stub

		if (o instanceof Scissors)
			return 0;

		else if (o instanceof Paper)
			return 1;

		return -1;
	}

	/**
	 * Converts weapon to String
	 * 
	 * @return Returns the word scissors
	 */
	public String toString() {

		return "Scissors";

	}
}
