/**
 * 
 */
package rockpaperscissors;

/**
 * Contains all the strategies that the Computer will use when going up against
 * the user or another computer.
 * 
 * @author 581140
 * 
 */
public class StratOne {

	private User player;
	private Computer comp1, comp2;
	private Interface io;

	public StratOne() {
		comp1 = new Computer(io);
		comp2 = new Computer(io);
		player = new User(io);
	}

	/**
	 * Both comp1 and comp2 use a strategy. If it losses, it chooses the weapon that
	 * neither chose last round. If it wins, it chooses the weapon of the opponent
	 * from the last round. If it draws, it choose a random weapon.
	 * 
	 * @param comp1Choice
	 *            The choice of comp1 from the previous round.
	 * @param comp2Choice
	 *            The choice of comp2 from the previous round.
	 * @param win
	 *            The winner of the previous round
	 * @return String[] Returns the new weapons for both comp1 and comp2 in an
	 *         array.
	 */
	public String[] StratvStrat(String comp1Choice, String comp2Choice, int win) {

		String newComp1;
		String newComp2;

		switch (win) {
		case -1:
			newComp1 = comp1.loseWeapon(comp1Choice, comp2Choice); // newCompWeap
			newComp2 = comp2.winWeapon(comp1Choice);
			break;
		case 1:
			newComp1 = comp2.loseWeapon(comp1Choice, comp2Choice);
			newComp2 = comp1.winWeapon(comp2Choice);
			break;
		default:
			newComp1 = comp1.randWeapon();
			newComp2 = comp2.randWeapon();
			break;
		}
		return new String[] { newComp1, newComp2 };
	}

	/**
	 * Only comp1 uses a strategy. If it losses, it chooses the weapon that neither
	 * chose last round. If it wins, it chooses the weapon of the opponent from the
	 * last round. If it draws, it choose a random weapon.
	 * 
	 * @param comp1Choice
	 *            The choice of comp1 from the previous round.
	 * @param comp2Choice
	 *            The choice of comp2 from the previous round.
	 * @param win
	 *            The winner of the previous round
	 * @return String[] Returns the new weapons for both comp1 and comp2 in an
	 *         array.
	 */
	public String[] StratvRand(String comp1Choice, String comp2Choice, int win) {
		String newComp1;
		String newComp2;

		switch (win) {
		case -1:
			newComp1 = comp1.loseWeapon(comp1Choice, comp2Choice); // newCompWeap
			newComp2 = comp2.randWeapon();
			break;
		case 1:
			newComp2 = comp2.randWeapon();
			newComp1 = comp1.winWeapon(comp2Choice);
			break;
		default:
			newComp1 = comp1.randWeapon();
			newComp2 = comp2.randWeapon();
			break;
		}
		return new String[] { newComp1, newComp2 };
	}

	/**
	 * Both comp1 adn comp2 choose a random weapon.
	 */
	public void RandvRand() {
		comp1.randWeapon();
		comp2.randWeapon();
	}

	/**
	 * Player goes up against a computer that has a strategy. If it losses, it
	 * chooses the weapon that neither chose last round. If it wins, it chooses the
	 * weapon of the opponent from the last round. If it draws, it choose a random
	 * weapon.
	 * 
	 * @param playerChoice
	 *            The choice of player from the previous round.
	 * @param comp1Choice
	 *            The choice of comp1 from the previous round.
	 * @param win
	 *            The winner of the previous round
	 * @return newCompChoice Returns the new weapon for comp1.
	 */
	public String StratvPlayer(String playerChoice, String comp1Choice, int win) {

		String newCompChoice;

		switch (win) {
		case -1:
			newCompChoice = comp1.loseWeapon(comp1Choice, playerChoice); // newCompWeap

			break;
		case 1:
			newCompChoice = comp1.winWeapon(playerChoice);

			break;
		default:
			newCompChoice = comp1.randWeapon();

			break;
		}
		return newCompChoice;
	}

	/**
	 * Comp1 chooses a random weapon, and the player is prompted to pick a weapon.
	 */
	public void RandvPlayer() {
		comp1.randWeapon();
		player.pickWeapon();
	}

	/**
	 * Returns comp1 when it has the new weapon assigned to it.
	 * 
	 * @return this.comp1 Gives comp1 the attributes of the Computer class, and
	 *         returns the weapon instance from the StratOne class
	 */
	public Computer getComp1() {
		return this.comp1;
	}

	/**
	 * Returns comp2 when it has the new weapon assigned to it.
	 * 
	 * @return this.comp2 Gives comp1 the attributes of the Computer class, and
	 *         returns the weapon instance from the StratOne class
	 */
	public Computer getComp2() {
		return this.comp2;
	}
}
