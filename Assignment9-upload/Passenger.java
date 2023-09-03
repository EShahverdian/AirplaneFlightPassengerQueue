
public class Passenger {
	private String passengerID;
	private String ticketClass;
	private int ticketNumber;
	static int ticketCounter = 0;
	
	Passenger(String ticketClass){
		setTicketNumber();
		setTicketClass(ticketClass);
		setPassengerID( );
		
	}
	//acessors
	public String getPassengerID() {
		return passengerID;
	}
	public String getTicketClass() {
		return ticketClass;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	
	
	void setTicketNumber( ) {
		ticketCounter++;
		ticketNumber= ticketCounter;
	}
	
	void setTicketClass(String tClass) {
		ticketClass = tClass;
	}
	
	void setPassengerID() {
		passengerID = ("PID_ " + ticketClass+" " + ticketNumber);
		
	}
	
	
	public String toString( ){
		return String.format("%s " , getPassengerID());
	}
}
