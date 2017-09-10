package game;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import blocking.BlockBehavior;
import blocking.BlockFactory;

class GoalKeeper implements Player
{
	BlockBehavior gkBhvr;
	BlockFactory blockFactory;
	int blockChance;
	boolean eyesRead;
	
	public GoalKeeper(String name)
	{
		blockFactory = new BlockFactory();
		blockChance = 1;
	}
	
	public void blockOptions()
	{
		System.out.println("Block Options\n-------------------------");
		System.out.println("1. Super Block\n2. Read Block\n3. Standing Block\n4. Diving Block");
		
		int option;
		do
		{
			option = UserInput.getUserInput();
		}while(option > 4 || option < 1);
		
		setBlockBehavior(option);
	}
	
	private void setBlockBehavior(int option)
	{
		switch (option)
		{
		case 1:
			gkBhvr = blockFactory.getBlock("Super Block");//change to blocks, not kicks
			break;
			
		case 2:
			gkBhvr = blockFactory.getBlock("Read Block");
			break;
			
		case 3:
			gkBhvr = blockFactory.getBlock("Standing Block");
			break;
			
		case 4:
			gkBhvr = blockFactory.getBlock("Diving Block");
			break;
		}
	}
	
	public void performAction()
	{
		blockOptions();
		gkBhvr.block();
	}

	
	public void readEyes()
	{
		Random rand = new Random();
		int block = rand.nextInt(20) + 1;
		eyesRead =  block <= blockChance;
	}

	/*To be used in multiplayer*/
	public int actionMenu()
	{
		/*
		 * To be used in multiplayer
		  System.out.println("Select area to block to\n1. Top Left\n2. Top Mid\n + "
				+ "3. Top Right\n 4. Low Left\n 5. Low Mid\n 6. Low right\n");
		 */
		
		int location;
		do
		{
			//location = UserInput.getUserInput();
			location = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		}while(location > 6 || location < 1);
		return location;
	}


}
