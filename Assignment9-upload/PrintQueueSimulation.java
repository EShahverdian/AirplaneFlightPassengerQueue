import java.util.*;
public class PrintQueueSimulation
{ 
	int numberOfPrinters;
	int numberOfPrintJobs;
	int seed;
	Queue<Job> waitQueue;
	int totalWaitTime;
	Queue<Job> finishedQueue;
	int currentTime = 0;
	Printer [] printer;
	Random randy;

	public PrintQueueSimulation (int numberOfPrinters,int numberOfPrintJobs, int seed)
	{
		randy = new Random(seed);
		this.numberOfPrintJobs = numberOfPrintJobs;
		waitQueue = new PriorityQueue<>(numberOfPrintJobs);
		finishedQueue = new PriorityQueue<>(numberOfPrintJobs);
		this.numberOfPrinters = numberOfPrinters;
		printer = new Printer[numberOfPrinters];
		for(int i = 0; i < numberOfPrinters; i++)
			printer[i] = new Printer("Printer" +i);	
	}
	
	public void simulate()
	{
		int jobTime;
		int priority;
		int jobNumber = 1;
		Job jobTemp;
		boolean flagDone = false;

		while (flagDone == false)
		{
			

			if(currentTime%100 == 0 && jobNumber <= numberOfPrintJobs)
			{
				jobTime = randy.nextInt(991) +10;
				priority = randy.nextInt(10) + 1;
				jobTemp = new Job(jobNumber);
				waitQueue.add(jobTemp);
				jobNumber++;
			}

			for(int i = 0; i <numberOfPrinters; i++)
			{
				jobTemp = printer[i].getJob();
				if(jobTemp != null)
				{
					if((currentTime - jobTemp.getStartTime()) == jobTemp.getTimeForJob())
					{
						jobTemp.setEndTime(currentTime);
						finishedQueue.add(jobTemp);
						printer[i].setJob(null);
						printer[i].setStartIdleTime(currentTime);
					}
				}
			}
	
			for(int i = 0; i< numberOfPrinters; i++)
			{
				if(printer[i].getJob() == null) 
				{
					if(!waitQueue.isEmpty())
					{
						jobTemp = waitQueue.remove(); 
						jobTemp.setStartTime(currentTime);
						printer[i].setJob(jobTemp); 						printer[i].setStartInUseTime(currentTime);
						totalWaitTime = totalWaitTime + (currentTime - jobTemp.getArrivalTime());
					}
				}
			}
			currentTime = currentTime + 1;
			if((jobNumber > numberOfPrintJobs) & waitQueue.isEmpty())
			{
				flagDone = true;
				for(int i = 0; i <numberOfPrinters; i++)
				{
					if(printer[i].getJob() != null)
						flagDone = false;
				}
			}
		}
		displayStatistics();
	}
    
	public void displayStatistics()
	{
		System.out.printf("Simulation Results\nSimulation with %d printers lasted %d seconds processed %d jobs\n", numberOfPrinters, currentTime, numberOfPrintJobs);
		double averageTimeInQueue = (double)totalWaitTime/numberOfPrintJobs;
		System.out.printf("The average time in the wait queue for a job is %4.2f seconds\n", averageTimeInQueue);
		
		System.out.printf("\nPrinter Statistics\n%16s%9s%9s\n    Name  Processed  In Use   Idle ","Jobs", "Time", "Time");
		for(int i = 0; i < numberOfPrinters; i++)
		{
			System.out.printf("\n%7s%7d%12d%7d", printer[i].getPrinterName(), printer[i].getTotalJobsProcessed(), printer[i].getTotalInUseTime(), printer[i].getTotalIdleTime(currentTime));
		}	
		Job jobTemp;
		System.out.printf("\n\nJob Statistics\nJob No. Priority  Wait Time Length Of Job\n");
		for(int i = 0; i < numberOfPrintJobs; i++)
		{
			jobTemp = finishedQueue.remove();
			System.out.printf("%4d%8d%11d%12d\n", jobTemp.getJobID(i), jobTemp.getPriority(),jobTemp.getWaitTime(), jobTemp.getTimeForJob());
		}
	}
}	