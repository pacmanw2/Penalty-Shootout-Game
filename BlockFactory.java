package game;

import java.util.HashMap;

public class BlockFactory
{
	private static final HashMap<String, BlockBehavior> blockMap = new HashMap<String, BlockBehavior>();

	public BlockBehavior getBlock(String name)
	{
		BlockBehavior block = (BlockBehavior) blockMap.get(name);

		if (block == null)
		{
			if (name.compareTo("Super Block") == 0)
			{
				block = (BlockBehavior) new SuperBlock();
				blockMap.put(name, block);
				System.out.println("Creating block: " + name);
			} 
			
			else if(name.compareTo("Read Block") == 0)
			{
				block = (BlockBehavior) new ReadBlock();
				blockMap.put(name, block);
				System.out.println("Creating kick: " + name);
			}
			
			else if(name.compareTo("Standing Block") == 0)
			{
				block = (BlockBehavior) new StandingBlock();
				blockMap.put(name, block);
				System.out.println("Creating kick " + name);
			}
			
			else if(name.compareTo("Diving Block") == 0)
			{
				block = (BlockBehavior) new DivingBlock();
				blockMap.put(name, block);
				System.out.println("Creating kick " + name);
			}
			
			else
			{
				System.out.println("No Kick Behavior found");
			}
		}
		return block;
	}
}
