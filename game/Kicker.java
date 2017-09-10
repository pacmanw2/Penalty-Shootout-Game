package game;

import kicking.KickBehavior;
import kicking.KickFactory;

class Kicker implements Player
{
	KickBehavior kickBhvr;
	KickFactory kickFactory;
	Kicker teamName;

	public Kicker(String name)
	{
		kickFactory = new KickFactory();
	}

	protected void kickOptions()
	{
		int option;
		do
		{
			option = UserInput.getUserInput();
			System.out.println("Kick Options\n-------------------------");
			System.out.println("1. Placed Kick\n2. Power Kick\n3. Deception Kick");
		}while(option > 3 || option < 1);
		setKickBehavior(option);
	}

	private void setKickBehavior(int option)
	{
		switch (option)
		{
		case 1:
			kickBhvr = kickFactory.getKick("Placed Kick");
			break;
			
		case 2:
			kickBhvr = kickFactory.getKick("Power Kick");
			break;
			
		case 3:
			kickBhvr = kickFactory.getKick("Deception Kick");
			break;
		}
	}
	
	public void performAction()
	{
		kickOptions();
		//kickBhvr.kick();
	}

	public int actionMenu()
	{
		int location;
		do
		{
			System.out.println("Select area to kick to\n1. Top Left\n2. Top Mid\n"
					+ "3. Top Right\n4. Low Left\n5. Low Mid\n6. Low right\n");
			location = UserInput.getUserInput();
		}while(location > 6 || location < 1);
		return location;
	}
}
