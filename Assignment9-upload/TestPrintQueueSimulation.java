import java.util.Scanner;
public class TestPrintQueueSimulation
{
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.printf("Please enter the number of printers for the simulation: ");
		int numberOfPrinters = keyboard.nextInt();
		System.out.printf("Please enter the number of printer jobs for the simulation: ");
		int numberOfPrintJobs = keyboard.nextInt();
		System.out.printf("Please enter a random number seed for the simulation: ");
		int seed = keyboard.nextInt();	
		PrintQueueSimulation printQSim = new PrintQueueSimulation(numberOfPrinters, numberOfPrintJobs, seed);
		printQSim.simulate();
		keyboard.close();
	}
	
}