/**
 * 
 */
package rockpaperscissors;

/**
 * Contains the hierarchy of power for Paper.
 * 
 * @author Karanvir
 *
 */
public class Paper extends Weapon {

	@Override
	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object) This method compares
	 *      the weapons to see which is stronger.
	 * @return Return 0 if we are equally strong. Return 1 if we are stronger.
	 *         Return -1 if we are weaker
	 */
	public int compareTo(Weapon o) {
		// TODO Auto-generated method stub

		if (o instanceof Paper)
			return 0;

		else if (o instanceof Rock)
			return 1;

		return -1;

	}

	/**
	 * Converts weapon to String
	 * 
	 * @return The word Paper is returned
	 */
	public String toString() {
		return "Paper";
	}

}
