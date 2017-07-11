package game;

public class DivingBlock implements BlockBehavior
{
	String name = "Diving block";
	
	public void block()
	{
		divingBlock();
	}
	
	private void divingBlock()
	{
		System.out.println(name);
	}

}
