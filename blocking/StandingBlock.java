package game;

public class StandingBlock implements BlockBehavior
{
	String name = "Standing block";
	
	public void block()
	{
		standingBlock();
	}
	
	private void standingBlock()
	{
		System.out.println(name);
	}

}
