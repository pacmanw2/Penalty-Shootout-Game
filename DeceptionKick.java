package game;

class DeceptionKick implements KickBehavior
{
	String name = "Deception Kick";
	
	public void kick()
	{
		deceptionKick(); 
	}
	
	private void deceptionKick()
	{
		System.out.println(name);
	}

}
