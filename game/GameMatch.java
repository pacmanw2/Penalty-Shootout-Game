package game;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*at round 4, if there is diff of 2, game over*/
class GameMatch
{
	Team homeTeam;
	Team awayTeam;
	private boolean suddenDeath;
	private boolean test = false;
	private int homeScore = 0;
	private int awayScore = 0;
	int round = 1;
	private List<Character> homeDisplay;
	private List<Character> awayDisplay;
	private ListIterator<Character> homeIt;
    private ListIterator<Character> awayIt;

    /*First team kicks, second team blocks
	 * mode determines who is kicking.
	 * 	0 - Home team is kicking
	 *  1 - Away team is kicking 
	 *  Will implement coin toss later. . .*/
	int mode = 0; 
	
	public void run()
	{
        initTeams();
        initScore();
        setSuddenDeath(false);
        playGame();
	}

	private void setSuddenDeath(boolean sd)
    {
        suddenDeath = sd;
    }
	
	private void playGame()
	{
		for(;round < 4; round++)
		{
			runPlay();
			printScore();
		}

		if(gameStatus() != -1)
		{
			while(round < 6 )
			{	
				runPlay();
				printScore();
				round++;
			}
		}
		/*Sudden death*/
		if(homeScore == awayScore)
		{
		    setSuddenDeath(true);
			while(gameStatus() != -1)
			{
				runPlay();
				printScore();
				round++;	
			}
		}

		System.out.println("-------------Game Over-------------\nFinal Score: \n");
		printScore();
		System.out.println("\nWinner: " + winner);
	}
	
	private void runPlay()
	{
		Player homeGK = homeTeam.team[0];
		Player awayGK = awayTeam.team[0];
		Player homeKicker = homeTeam.team[round % 10];
		Player awayKicker = awayTeam.team[round % 10];
		boolean home = false;
		boolean away = false;

		if(goalScored(homeKicker, awayGK))
		{
			homeScore += 1;
			updateScoreDisplay(0,'O');
			home = true;
		}
			
		if(goalScored(awayKicker, homeGK))
		{
			awayScore += 1;
            updateScoreDisplay(1,'O');
            away = true;
		}

		if(!home)
		    updateScoreDisplay(0,'X');
		if(!away)
		    updateScoreDisplay(1, 'X');
			
	}

	private boolean goalScored(Player kicker, Player keeper)
	{
		/*Attempt to read eyes before asking where to block
		 * ReadBlock will become a random occurrence*/

        /*Choose where to kick/block*/
        int kickerLocation = kicker.actionMenu();
        int blockLocation = keeper.actionMenu();

        if(kickerLocation == blockLocation)
        {
            System.out.println("Kick was blocked!\n");
            return false;
        }
        else
        {
            System.out.println("GOOOOOOOOOOOOOOOOOOOOOL!\n");
            return true;
        }
	}
	
	private void initTeams()
	{
		homeTeam = new Team();
		awayTeam = new Team();
		homeTeam.name = "Team A";
		awayTeam.name = "Team B";
	}
	
	private void initScore()
	{
	    homeDisplay = new ArrayList<>();
	    awayDisplay = new ArrayList<>();
	    homeIt = homeDisplay.listIterator();
        awayIt = awayDisplay.listIterator();


	}
	
	/*Game Status:
	 * -1: game is over
	 * 0: game will continue
	 * 1: Sudden Death */
	
	/*If game is not into sudden death, the match is concluded by
	 * a team having a goal difference of 3, or having a goal difference
	 * of 1 at the end of the round 5 or sudden death.
	 */
	private int gameStatus()
	{
	    if(!suddenDeath)
        {
            if(round == 4 && goalDifference() == 2)
                return -1;
            else if (goalDifference() == 3)
                return -1;
            else if (round == 5 && goalDifference() == 1)
                return -1;
            else
                return 0;
        }
        else
        {
            if(goalDifference() == 1)
                return -1;
            else
                return 0;
        }

	}
	
	private int goalDifference()
	{
		return Math.abs(homeScore - awayScore);
	}
	
	private void printScore()
	{
		printScoreDisplay();
		System.out.print("\n\nHome: " + homeScore + "\nAway: " + awayScore);
		System.out.println("\t\tRound: " + round + "\n");
	}
	
	/*Use StringBuilder to build String display that is called
	instead of iterating through the list
	Every time we need to print. */
	private void printScoreDisplay()
    	{
		System.out.print("Home: ");
		for(Character it : homeDisplay)
		{
		    System.out.print(it + " ");
		}

		System.out.print("\nAway: ");
		for(Character it : awayDisplay)
		{
		    System.out.print(it + " ");
		}
    	}

    private void updateScoreDisplay(int row, char result)
    {

        if(row == 0)
        {
            homeDisplay.add(round-1, result);
        }
        else
        {
            awayDisplay.add(round-1, result);
        }

    }

}
