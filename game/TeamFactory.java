package game;

class TeamFactory
{
	Player[] team = new Player[11];
	Kicker kicker;
	GoalKeeper keeper;
	
	public Player[] createTeam()
	{
		team[0] = createKeeper();
		for(int i = 1; i < 11; i++)
		{
			team[i] = createKicker(i);
		}
		return team;
		
	}
	
	private Kicker createKicker(int i)
	{
		String name = Integer.toString(i);
		return new Kicker("Kicker " + name);
	}
	
	private GoalKeeper createKeeper()
	{
		return new GoalKeeper("GoalKeeper");
		
	}
}
