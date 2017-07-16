package kicking;

class PlacedKick implements KickBehavior
{
	String name = "Placed Kick";
	
	public void kick()
	{
		placedKick();
	}
	
	private void placedKick()
	{
		System.out.println(name);
	}

}
