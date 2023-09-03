import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
public class PriorityQueueUserDefinedObjectExample{
	
	
	public static void main (String [] args ) throws FileNotFoundException 
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter the name of the input file\n");
		String fileName = kb.next();
		File inFile = new File(fileName);
		if(!inFile.exists()) {
		
			System.out.printf("The file does not exist\n");
			
		}
		System.out.printf("%sFile exists \n", fileName);
		Scanner fileReader = new Scanner(inFile);
		
		System.out.printf("Please enter your output file name\n");
		String outputFileName = kb.next();
		File outputFile = new File(outputFileName);
		PrintWriter writeOut = new PrintWriter(outputFile);
	
	PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>();
	String name;
	double salary;
	while (fileReader.hasNext()) {
		name = fileReader.next();
		salary = fileReader.nextDouble();
		employeePriorityQueue.add(new Employee (name, salary));
		}
	writeOut.printf("%8s\t%9s\n","NAME","SALARY"); 
	while(!employeePriorityQueue.isEmpty()){
		{
			writeOut.printf("%s", employeePriorityQueue.remove());
			
		}
	
		fileReader.close();
		writeOut.close();
		kb.close();
	}
	
	
	}
	
}
	

