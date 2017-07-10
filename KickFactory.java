package game;

import java.util.HashMap;

class KickFactory
{
	private static final HashMap<String, KickBehavior> kickMap = new HashMap<String, KickBehavior>();

	public KickBehavior getKick(String name)
	{
		KickBehavior kick = (KickBehavior) kickMap.get(name);

		if (kick == null)
		{
			if (name.compareTo("Placed Kick") == 0)
			{
				kick = (KickBehavior) new PlacedKick();
				kickMap.put(name, kick);
				System.out.println("Creating kick: " + name);
			} 
			
			else if(name.compareTo("Power Kick") == 0)
			{
				kick = (KickBehavior) new PowerKick();
				kickMap.put(name, kick);
				System.out.println("Creating kick: " + name);
			}
			
			else if(name.compareTo("Deception Kick") == 0)
			{
				kick = (KickBehavior) new DeceptionKick();
				kickMap.put(name, kick);
				System.out.println("Creating kick " + name);
			}
			
			else
			{
				System.out.println("No Kick Behavior found");
			}
		}
		return kick;
	}
}
