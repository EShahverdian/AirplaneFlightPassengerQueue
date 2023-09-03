import java.util.Comparator;

public class PassengerComparator implements Comparator <Passenger>{

	@Override
	public int compare(Passenger o1, Passenger o2) {
		if (o1.getTicketClass().equals(o2.getTicketClass()))
			return o1.getTicketNumber()-o2.getTicketNumber();
		else if( o1.getTicketClass().equals("First"))
			return -1;
		else
			return 1;
	}

}
