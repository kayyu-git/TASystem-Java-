import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner fileReader = null;
		
		try
		{
			fileReader = new Scanner(new File("SP500.txt"));
		} 
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		if (fileReader != null)
		{
			Scanner consoleReader = new Scanner(System.in);
			
			System.out.println("Lookback days:");
			
			String inputString = consoleReader.nextLine();
				
			ThreadManager threadCalc = new ThreadManager(Helpers.copyFileToList(fileReader), 
					Integer.parseInt(inputString));
			
			threadCalc.runAnalyzer();
			
			consoleReader.close();
			fileReader.close();
		}
	}

}
