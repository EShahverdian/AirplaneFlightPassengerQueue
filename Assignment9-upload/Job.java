public class Job implements Comparable <Job>{
	private String jobID;
	private int arrivalTime;
	private int timeForJob;
	private int priority;
	private int  startTime;
	private int waitTime;
	private int endTime;
	
	public static int seqID = 1;
	
	public Job(int priority)
	{
		getJobID(seqID);
		setPriority(priority);
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getTimeForJob() {
		return timeForJob;
	}

	public void setTimeForJob(int timeForJob) {
		this.timeForJob = timeForJob;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getWaitTime() {
		waitTime = arrivalTime- endTime;
		return waitTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Job o) {
		// TODO Auto-generated method stub
		return (priority-o.priority);
	}

	public int getJobID(int seqID) {
		int jobID = seqID + 1;
		
		return jobID;
	}
	
	
	
}