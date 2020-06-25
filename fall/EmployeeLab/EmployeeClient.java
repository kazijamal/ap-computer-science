import java.util.List;
import java.util.ArrayList;

public class EmployeeClient{

    public static void main(String[] args){
	new EmployeeClient().run();
    }

    public void run(){
	HourlyEmployee s = new HourlyEmployee("James Reese", 15.50, 20);
	System.out.println(s);
	System.out.println("pay: " + s.getPay());
	s.setHourlyRate(20);
	s.setHoursWorked(100);
	System.out.println("after raise:\n" + s);
	System.out.println("pay: " + s.getPay());
	System.out.println();

	List<Employee> employees = new ArrayList<Employee>();
	employees.add(new HourlyEmployee("Hourly Employee", 13, 8));
        employees.add(new SalaryEmployee("Salary Employee", 80000));
	employees.add(new CommissionedEmployee("Commissioned Employee", 60000, 0.05, 30000));
	for (Employee e : employees){
	    System.out.println(e);
	    System.out.println("pay: " + e.getPay());
	    if (e instanceof Payable){
		Payable p = (Payable) e;
		System.out.println("paycheck: " + p.payCheck());
	    }
	    System.out.println();
	}
    }

}
