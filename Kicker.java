package game;

import java.util.Scanner;

class Kicker implements Player
{
	KickBehavior kickBhvr;
	KickFactory kickFactory;

	public Kicker(String name)
	{
		kickFactory = new KickFactory();
	}

	protected void kickOptions()
	{
		
		System.out.println("Kick Options\n-------------------------");
		System.out.println("1. Placed Kick\n2. Power Kick\n3. Deception Kick");
		try(Scanner kb = new Scanner(System.in))
		{
			int option = kb.nextInt();
			setKickBehavior(option);
		}
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
		kickBhvr.kick();
	}
}
