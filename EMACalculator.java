import java.util.LinkedList;

public class EMACalculator extends Thread
{
	private static int counter = 0;
	private static double prevEMA;
	private LinkedList<Double> data;
	
	public String text = "";
	
	public EMACalculator(LinkedList<Double> data)
	{
		this.data = data;
	}
	
	public void run()
	{
		calculate();
	}
	
	private String calculate()
	{
		if(counter == 0)
		{
			text += "EMA: " + Helpers.average(data) + "\n";
			
			prevEMA = Helpers.average(data);
			
			++counter;
		}
		else
		{
			double temp = Helpers.expAverage(data, prevEMA);
			prevEMA = temp;
			
			text += "EMA: " + prevEMA + "\n";
		}
		
		return text;
	}
	
}
