/**
 * 
 */
package rockpaperscissors;

/**
 * Ties all the methods and variables that will be used to run the game itself
 * into one class.
 * 
 * @author Karanvir
 *
 */
public class Game {

	private User player;
	private Computer comp1, comp2;
	private Interface io;
	private StratOne strat;
	private ConsolePrompts prompt;

	public double win = 0;
	public double draw = 0;
	public double lose = 0;

	// Constructor
	public Game() {
		io = new Interface();
		strat = new StratOne();
		comp1 = new Computer(io);
		comp2 = new Computer(io);
		prompt = new ConsolePrompts();
	}

	/**
	 * Contains all the console prompts and methods that build the basis of the game
	 * 
	 * @param start
	 *            Boolean that is TRUE if game is starting, or FALSE when not
	 */
	public void startRound(boolean start) {

		player = new User(io);

		int opponent;

		try {

			// Prompts user whether they want to do Player vs Computer
			// or Computer vs Computer
			int choice = prompt.PlyrOrComp();

			// Prompts user to input how many rounds they want to play
			int rounds = prompt.rndPrompt();

			switch (choice) {

			// Player vs Computer methods
			case 0:

				// Prompts the User if they want to play again the following:
				// Computer w/ Strategy
				// Randomly Generating Computer
				opponent = prompt.playerPrompt();

				switch (opponent) {

				// Player Vs Computer with Strategy
				case 0:
					StratvsPlayer(rounds, choice);
					findStats(rounds);
					break;

				// Player Vs Randomly generating Computer
				case 1:
					RandvsPlayer(rounds);
					findStats(rounds);
					break;

				default:
					break;
				}
				break;

			// Computer vs Computer methods
			case 1:

				// Prompts the user if they want to simulate the following:
				// Computer w/ Strategy vs Computer w/ Strategy
				// Computer w/ Strategy vs Randomly Generating Computer
				// Randomly Generating Computer vs Randomly Generating Computer
				opponent = prompt.compPrompt();

				switch (opponent) {

				// Computer w/ Strategy vs Computer w/ Strategy
				case 0:
					StratvsStrat(rounds, choice);
					findStats(rounds);
					break;

				// Computer w/ Strategy vs Randomly Generating Computer
				case 1:
					StratvsRand(rounds, choice);
					findStats(rounds);
					break;

				// Randomly Generating Computer vs Randomly Generating Computer
				case 2:
					RandvsRand(rounds, choice);
					findStats(rounds);
					break;

				default:
					break;
				}
				break;

			default:
				break;
			}
		} catch (Exception e) {

			System.out.println("Incorrect value. \nPlease restart.");
		}
	}

	/**
	 * Method that determines who the winner is. Capable of switching between
	 * comparing Computer vs Computer games AND Player vs Computer games If -1,
	 * Player/Computer 2 wins If 1, Computer wins If 0, Draw
	 * 
	 * @param PlayerOrComp
	 *            The choice the user made, for whether they want to play as the
	 *            Player or watch Computer vs Computer
	 * @return winner The integer value that determines who won
	 *
	 */
	public int findWinner(int PlayerOrComp) {
		int winner = 0;
		String prompt = "";

		// If the player chose to play against the computer, we now
		// compare the Computers weapon against the Players
		switch (PlayerOrComp) {

		// Computer vs Player matches
		case 0:
			winner = comp1.getWeapon().compareTo(player.getWeapon());
			prompt = "\nPlayer wins!";
			break;

		// Computer vs Computer matches
		case 1:
			winner = comp1.getWeapon().compareTo(comp2.getWeapon());
			prompt = "\nComputer 2 wins!";
			break;

		}

		// Depending on the result of the weapon comparison, different prompts are
		// printed
		// If -1, Player/Computer wins
		// If 1, Computer 1 wins
		// If 0, Draw
		switch (winner) {
		case -1: // Player wins
			System.out.println(prompt);
			break;
		case 1: // Computer wins
			System.out.println("\nComputer 1 wins!");
			break;
		case 0: // Draw
			System.out.println("\nNobody wins!");
			break;
		}

		// Tallies up the Wins | Draws | Losses
		if (winner == -1) {
			win++;
		}

		if (winner == 0) {
			draw++;
		}

		if (winner == 1) {
			lose++;
		}

		return winner;
	}

	/**
	 * Prints out the statistics of the game. This includes: Wins, Losses, and
	 * Draws, and the percentage of each.
	 * 
	 * @param rounds
	 *            The amount of rounds that the user inputed to be played
	 */
	public void findStats(int rounds) {

		System.out.println("\n     GAME STATISTICS");
		System.out.println("--------------------------");

		// GAMES PLAYED
		System.out.println("GAMES PLAYED");
		System.out.println("\nWINS:" + win + "");
		System.out.println("DRAWS:" + draw + "");
		System.out.println("LOSSES:" + lose + "");
		System.out.println("--------------------------");

		// WIN | DRAW | LOSS PERCENTAGES
		System.out.println("PERCENTAGES");
		System.out.println("\nWin:" + (win / rounds) * 100 + "%");
		System.out.println("Draw:" + (draw / rounds) * 100 + "%");
		System.out.println("Lose:" + (lose / rounds) * 100 + "%");

	}

	/**
	 * Iterates through the amount of rounds inputted, prints out the computer's
	 * choice, and runs the method.
	 * 
	 * @param rounds
	 *            An int that gives how many rounds that the game should be played
	 * @param choice
	 *            An int showing whether the player choose to play against a
	 *            Computer, or just do AI vs AI
	 */
	public void StratvsPlayer(int rounds, int choice) {

		String playerChoice = player.pickWeapon();

		// Computer chooses a random weapon here and is saved in comp1Choice
		String comp1Choice = comp1.randWeapon();

		for (int min = 0; min < rounds; min++) {

			String holder = comp1Choice;

			System.out.println("Computer Choice: " + comp1Choice);

			comp1Choice = strat.StratvPlayer(playerChoice, holder, findWinner(choice));

			comp1 = strat.getComp1();

			playerChoice = player.pickWeapon();

		}
	}

	/**
	 * Iterates through the amount of rounds inputed, and runs the method.
	 * 
	 * @param rounds
	 *            An int that gives how many rounds that the game should be played
	 */
	public void RandvsPlayer(int rounds) {
		for (int min = 0; min < rounds; min++) {
			strat.RandvPlayer();
		}
	}

	/**
	 * Iterates through the amount of rounds chosen, and then runs the method.
	 * 
	 * @param rounds
	 *            An int that gives how many rounds that the game should be played
	 * @param choice
	 *            An int showing whether the player choose to play against a
	 *            Computer, or just do AI vs AI
	 */
	public void StratvsStrat(int rounds, int choice) {

		// First round, both computers play random weapons
		String comp1Choice = comp1.randWeapon();
		String comp2Choice = comp2.randWeapon();

		// Initialize an array to hold both weapons from the SvS method
		String results[] = new String[2];

		// Fills the results[] array with the weapons for the first round ONLY
		results[0] = comp1Choice;
		results[1] = comp2Choice;

		for (int min = 0; min < rounds; min++) {

			System.out.println("Computer1 Choice: " + results[0]);
			System.out.println("Computer2 Choice: " + results[1]);

			// Fills the results[] array with the NEW weapons based on strategy
			results = strat.StratvStrat(results[0], results[1], findWinner(choice));

			// Gets the new weapons for each Computer
			comp1 = strat.getComp1();
			comp2 = strat.getComp2();

		}
	}

	/**
	 * Iterates through the amount of rounds chosen, and then runs the method.
	 * 
	 * @param rounds
	 *            An int that gives how many rounds that the game should be played
	 * @param choice
	 *            An int showing whether the player choose to play against a
	 *            Computer, or just do AI vs AI
	 */
	public void StratvsRand(int rounds, int choice) {

		// First round, both computers play random weapons
		String comp1Choice = comp1.randWeapon();
		String comp2Choice = comp2.randWeapon();

		// Initialize an array to hold both weapons from the SvS method
		String results[] = new String[2];

		// Fills the results[] array with the weapons for the first round ONLY
		results[0] = comp1Choice;
		results[1] = comp2Choice;

		for (int min = 0; min < rounds; min++) {

			System.out.println("--------------------------------");

			System.out.println("Computer1 Choice: " + results[0]);
			System.out.println("Computer2 Choice: " + results[1]);

			// Fills the results[] array with the NEW weapons based on strategy
			results = strat.StratvRand(results[0], results[1], findWinner(choice));

			// Gets the new weapons for each Computer
			comp1 = strat.getComp1();
			comp2 = strat.getComp2();

		}
	}

	/**
	 * Iterates through the amount of rounds chosen, and then runs the method.
	 * 
	 * @param rounds
	 *            An int that gives how many rounds that the game should be played
	 * @param choice
	 *            An int showing whether the player choose to play against a
	 *            Computer, or just do AI vs AI
	 */
	public void RandvsRand(int rounds, int choice) {

		comp1.randWeapon();
		comp2.randWeapon();

		for (int min = 0; min < rounds; min++) {
			strat.RandvRand();
			findWinner(choice);
			comp1 = strat.getComp1();
			comp2 = strat.getComp2();
		}
	}
}