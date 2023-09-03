import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Iterator;

public class Flight {
	private String flightName;
	private int seats;
	private int seatsSold;
	Random randy;
	
	private LinkedList <Passenger> passBooked = new LinkedList <> ();
	private PriorityQueue <Passenger> boardingQueue = new PriorityQueue <> (new PassengerComparator());
	
	
	Flight(String flightName, int seed){
		setFlightName(flightName);
		randy = new Random(seed);
		setSeats();
	}
	
	
	void setFlightName(String fName) {
		fName= flightName;
	}
	
	void setSeats() {
		seats = randy.nextInt(76) + 75;
		}
	
	void sellSeats() {
		seatsSold = ((seats/2) + randy.nextInt(1+ seats/2));
		int sold;
		FirstClassPassenger firstTicket;
		CoachPassenger coTicket;
		for(int i = 0; i < seatsSold ; i ++)
		{
			sold = randy.nextInt(5);
			if (sold == 0 ) {
				firstTicket = new FirstClassPassenger();
				passBooked.add(firstTicket);
				
			}
			else
			{
				coTicket = new CoachPassenger();
				passBooked.add(coTicket);
			}
		}
		
	}
	void lineUpCall() {
		Iterator <Passenger> i = passBooked.iterator();
		while (i.hasNext()) {
			boardingQueue.add(passBooked.remove());
		}
	}
	
	
	void boarding(PrintWriter outputWriter) throws IOException{
		outputWriter.printf("The boarding order for Flight " , flightName , " with " + seats + " and " + seatsSold + "Seats sold is  \n");
		for (int i =0; !boardingQueue.isEmpty(); i++ )
		{
			if(i == 3) {
				outputWriter.printf("\n");
				i = -1;
			}
			else {
				outputWriter.printf("%s" , boardingQueue.remove());
			}
		}
		
	}
	
	
}