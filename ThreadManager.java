import java.util.LinkedList;

public class ThreadManager
{
	private LinkedList<Double> workingData;
	private LinkedList<Double> rawData;
	private int lookbackDays;
	private int endPointer;
	
	public ThreadManager(LinkedList<Double> rawData, int lookbackDays)
	{
		this.rawData = rawData;
		this.lookbackDays = lookbackDays;
		workingData = new LinkedList<Double>();
		endPointer = lookbackDays - 1;
	}
	
	public void runAnalyzer()
	{
		while(endPointer < (rawData.size() - 1))
		{
			updateWorkingData();
			
			System.out.println(Helpers.outputData(workingData));
			System.out.println(runThreads(workingData));
		}
	}
	
	private void updateWorkingData()
	{
		if (workingData.isEmpty())
		{
			for (int x = 0; x < lookbackDays; x++)
			{
				workingData.add(rawData.get(x));
			}
		}
		else
		{
			++endPointer;
			workingData.add(rawData.get(endPointer));
		}
		
		while(workingData.size() > lookbackDays)
		{
			workingData.removeFirst();
		}
	}
	
	private String runThreads(LinkedList<Double> data)
	{
		String text = "";
		
		EMACalculator myEMACalc = new EMACalculator(data);
		MAsDevCalculator myMAsDevCalc = new MAsDevCalculator(data);
		
		myEMACalc.start();
		myMAsDevCalc.start();
		
		try
		{
			myEMACalc.join();
			myMAsDevCalc.join();
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		text += myEMACalc.text;
		text += myMAsDevCalc.text;
		
		return text;
	}
	
}
