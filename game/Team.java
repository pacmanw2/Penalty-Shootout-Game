package game;

class Team
{
	Player[] team;
	int goals;
	int miss;
	TeamFactory teamFactory;
	
	public Team()
	{
		teamFactory = new TeamFactory();
		team = teamFactory.createTeam();
		goals = 0;
		miss = 0;
	}	
	
	void updateScore(int flag)
	{
		if(flag == 1)
			updateGoal();
		else if(flag == 0)
			updateMiss();
		else
			System.out.println("Score update Error. . .");
	}
	
	private void updateMiss()
	{
		miss++;
	}
	
	private void updateGoal()
	{
		goals++;
	}
}
