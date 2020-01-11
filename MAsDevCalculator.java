import java.util.LinkedList;

public class MAsDevCalculator extends Thread
{
	private static double prevMA;
	private static double prevsDev;
	private static boolean valueFlag = false;
	private LinkedList<Double> data;
	
	public String text = "";
	
	public MAsDevCalculator(LinkedList<Double> data)
	{
		this.data = data;
	}
	
	public void run()
	{
		calculate();
	}
	
	private String calculate()
	{
		if(valueFlag)
		{
			double delta = Math.abs(data.getLast() - prevMA);
			
			if (delta > prevsDev)
			{
				double nsDev = delta / prevsDev;
				
				text += "px for SP500, " + data.getLast() + ", is " + nsDev + " std dev ";
				
				if (data.getLast() < prevMA)
				{
					text += "below ";
				}
				else
				{
					text += "above ";
				}
				
				text += "moving average, " + prevMA + "\n";
			}
		}
		
		prevMA = Helpers.average(data);
		prevsDev = Helpers.stdv(data);
		
		text += "MA: " + prevMA + "\n" + "sDev: " + prevsDev + "\n";
		
		valueFlag = true;
		
		return text;
	}
	
}
