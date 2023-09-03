
public class Employee implements Comparable <Employee> {
	
	private String name= "";
	private double salary;
	//-------------------------------------
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(double salary){
		this.salary = salary;
	}
	//-------------------------------------
	public Employee(String name, double salary) {
		
			setName(name);
			setSalary(salary);
	}
	
	//-------------------------------------
	@Override
	public boolean equals(Object Employee) {
		{
			Employee e =(Employee) Employee;
			if (Math.abs(this.salary - e.salary) == .01 && this.name.equals((e.name)))
			{
			
		return true;
		}
		{
			return false;
		}
		}
		
		
	}
	
	@Override
	public int compareTo(Employee o) {
		if (this.salary > o.salary) {
			return 1;
			
		}
		else if(this.salary < o.salary) {
			return -1;
			
		}
		else  {
			return 0;
			
		}
	
	

	}
	@Override
	public String toString()
	{
		return String.format("%8s \t$%.2f\n",getName(),getSalary());
	}
		
}
		

		
	

