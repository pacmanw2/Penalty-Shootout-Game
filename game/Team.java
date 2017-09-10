package game;
/*This class should ONLY contain info relating to the team.
 * No stats will be held here.
 * Stats should go into their own class to avoid dependencies.*/
class Team
{
	String name;
	Player[] team;
	TeamFactory teamFactory;

	public Team()
	{
		teamFactory = new TeamFactory();
		team = teamFactory.createTeam();
	}	

}
