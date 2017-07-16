package game;

import java.util.Scanner;

class UserInput
{
	//private static UserInput keyboardIn = new UserInput();
	private static Scanner kb = new Scanner(System.in);
	
	private UserInput(){}
	
	/*
	public static UserInput getInstance()
	{
		return keyboardIn;
	}
	*/
	protected static int getUserInput()
	{
		int option = kb.nextInt();
		return option;
	}
}
