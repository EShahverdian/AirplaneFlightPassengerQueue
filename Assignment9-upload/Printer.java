public class Printer{
	String printerName;
	Job printJob;
	int startIdleTime;
	int startInUseTime;
	int totalIdleTime;
	int totalInUseTime;
	int totalJobsProcessed;
	public Printer() {};
	
	public Printer(String printerName) {
	
		setPrinterName(printerName);
	}
	public void setPrinterName(String printerName) {
		this.printerName = printerName;

	}
	
	public String getPrinterName()
	{
		return printerName;
		
	}
	public void setJob (Job printJob) {
		this.printJob= printJob;
	}

	public Job getJob() {
		return printJob;
	}
	public void setStartInUseTime(int startInUseTime) {
		this.startInUseTime = startInUseTime;
		totalJobsProcessed = totalJobsProcessed +1;
		
	}
	public void setStartIdleTime(int startIdleTime)
	{
		this.startIdleTime = startIdleTime;
		totalInUseTime = totalInUseTime + (startIdleTime - startInUseTime);
	}
	public int getTotalIdleTime(int currentTime)
	{
		return currentTime - totalInUseTime;
	}
	public int getTotalInUseTime()
	{
		return totalInUseTime;
	}
	public int getTotalJobsProcessed()
	{
		return totalJobsProcessed;
	}
}

