import java.util.Scanner;

/**
 * @modfied by Liz Dancy
 * Used to show how to catch multiple Exceptions and then as a base class
 * for the testing exercise with JUnit
 *
 */


import javax.swing.JOptionPane;

/**
 * Taken from Wendi Jollymore :http://www-acad.sheridanc.on.ca/~jollymor/prog24178/oop2.html
 * @modfied by Liz Dancy
 * Used  as a base class
 * for the testing exercise with JUnit
 *  Winter 2021
 */
public class Time
{
	/*
	public static void main(String[] args) 
	{
		try
		{
			
		String time = JOptionPane.showInputDialog(null,
			"Enter a time in the format hh:mm:ss", "Enter Time",
			JOptionPane.QUESTION_MESSAGE);
		
		double totalSeconds = getTotalSeconds(time);
		JOptionPane.showMessageDialog(null, totalSeconds, "Total Seconds",
			JOptionPane.INFORMATION_MESSAGE);
		}
		catch(StringIndexOutOfBoundsException e)
		{
			JOptionPane.showMessageDialog(null,
					"You entered the time in the wrong format.\n" +
					"Please enter the time in the form hh:mm:ss",
					"Invalid Time", JOptionPane.ERROR_MESSAGE);
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null,
					"You entered an invalid time.\nPlease enter numbers only.",
					"Invalid Time",	JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception e)
		{
			System.out.println("An unexpected Exception occurred");
		}
	}
	*/
	public static void main(String[] args) {

		double totalSeconds = Time.getTotalSeconds("10:10:10:99");

		System.out.println("**GH total Seconds = "+ totalSeconds);
		//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
		// to see how IntelliJ IDEA suggests fixing it.
		System.out.printf("Hello and welcome!");

		for (int i = 1; i <= 5; i++) {
			//TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
			// for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
			System.out.println("i = " + i);
		}
	}
	//hh:mm:ss:ms
	//01 2 34 5 67 8 910
	public static double getTotalSeconds(String time)throws NumberFormatException, StringIndexOutOfBoundsException {
		
		int hours = getTotalHours(time);
		//we will eventually multiply the hours by 3600 + the minutes by 60 + the seconds
		int minutes = getTotalMinutes (time);
		int seconds = getSeconds(time);
		return hours * 3600 + minutes * 60 + seconds;
	}

	public static int getMilliseconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException
	{
		if(time.length()>11)
		{
			throw new NumberFormatException("your time was too long!");
		}
		return Integer.parseInt(time.substring(9,11));
	}
	public static int getSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException 
	{
		if (time.length()>11)
		{
			throw new NumberFormatException("your time was too long!");
		}
		return Integer.parseInt(time.substring(6,8));
	}

	public static int getTotalMinutes(String time) throws NumberFormatException, StringIndexOutOfBoundsException
	{
		if (time.length()>11)
		{
			throw new NumberFormatException("your time was too long!");
		}
		return Integer.parseInt(time.substring(3,5));
	}

	public static int getTotalHours(String time)throws NumberFormatException, StringIndexOutOfBoundsException
	{
		if (time.length()>11)
		{
			throw new NumberFormatException("your time was too long!");
		}
		return Integer.parseInt(time.substring(0,2));
	}
	
}



