package game;

import blocking.BlockBehavior;
import blocking.BlockFactory;

class GoalKeeper implements Player
{
	BlockBehavior gkBhvr;
	BlockFactory blockFactory;
	
	public GoalKeeper(String name)
	{
		blockFactory = new BlockFactory();
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

}
