package game;

public class SuperBlock implements BlockBehavior
{
	String name = "Super block";
	
	public void block()
	{
		superBlock();
	}
	
	private void superBlock()
	{
		System.out.println(name);
	}

}
