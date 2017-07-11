package game;

public class ReadBlock implements BlockBehavior
{
	String name = "Read block";
	
	public void block()
	{
		readBlock();
	}
	
	private void readBlock()
	{
		System.out.println(name);
	}

}
