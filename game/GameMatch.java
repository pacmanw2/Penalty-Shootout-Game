package game;

class GameMatch
{
	Team team_1;
	Team team_2;
	int[][] goal = new int[3][3];
	
	public void play()
	{
		setUp();
	}
	
	private void setUp()
	{
		team_1 = new Team();
		team_2 = new Team();
		
		for(Player it : team_1.team)
		{
			it.performAction();
		}
	}

}
