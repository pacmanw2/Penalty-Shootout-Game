package game;

class PowerKick implements KickBehavior
{
	String name = "Power Kick";
	public void kick()
	{
		powerKick();
	}
	
	private void powerKick()
	{
		System.out.println(name);
	}

}
