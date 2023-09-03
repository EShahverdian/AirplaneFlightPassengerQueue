import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;


public class OperateAirline {

	public static void main(String [] args) throws IOException {
		ArrayList <Flight>  flightList = new ArrayList <>()	;
		Scanner kb = new Scanner(System.in);
		String fliteName;
		int seed;
		
		
		
		for (int i = 0; i < 3; i ++) {
			System.out.printf("Please enter the name of the flight: \n");
			
			
			fliteName= kb.nextLine();
			
			System.out.printf("Please enter a seed from 1 to 50: \n");
			seed = kb.nextInt();
			flightList.add(new Flight(fliteName, seed));
			kb.nextLine();
	
			
			
			
			
		}
		
		System.out.printf("Please enter the name of the output file:\n"	);
		String fileOutName = kb.next();
		File outputFile = new File (fileOutName);
		PrintWriter printWriter = new PrintWriter(outputFile);
		
		
		for( Flight a: flightList)
		{
			a.sellSeats();
			a.lineUpCall();
			a.boarding(printWriter);
			printWriter.printf("\n\n");
			
		}
		kb.close();
		printWriter.close();
		
		
		
	}
	
}
