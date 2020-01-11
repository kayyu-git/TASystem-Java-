import java.util.LinkedList;
import java.util.Scanner;

public class Helpers
{
	public static synchronized double stdv(LinkedList<Double> numbers)
	{
		double variance = 0;
		int x, size = numbers.size();

		double mean = average(numbers);

		for (x = 0; x < size; ++x) 
	    {
			variance += Math.pow(numbers.get(x) - mean, 2);
		}
		variance = variance / size;

		return Math.sqrt(variance);
	}
	
	public static synchronized double average(LinkedList<Double> numbers) 
	{
		double sum = 0;
		int x, size = numbers.size();
		for (x = 0; x < size; ++x) 
	    {
			sum += numbers.get(x);
		}

		return sum / size;
	}
	
	public static synchronized double expAverage(LinkedList<Double> numbers, double prevEMA) 
	{
		double multiplier = (2.0 / (numbers.size() + 1.0));
		
		return (average(numbers) * multiplier) + (prevEMA * (1 - multiplier));
	}
	
	public static String outputData(LinkedList<Double> numbers) 
	{
		String text = "\n";
		
		for (int x = 0; x < numbers.size(); ++x) 
	  {
			text += numbers.get(x) + ", ";
		}
		text += "\n";
		
		return text;
	}
	
	public static LinkedList<Double> copyFileToList(Scanner reader)
	{
		LinkedList<Double> data = new LinkedList<Double>();
		
		while(reader.hasNextLine())
		{
			data.add(Double.parseDouble(reader.nextLine()));
		}
		
		return data;
	}
	
}
