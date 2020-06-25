public class SalaryEmployee extends Employee implements Payable{

    // instance variables
    private double salary;

    // constructor
    public SalaryEmployee(String name, double salary){
	super(name);
	this.salary = salary;
    }

    // mutators
    public void setSalary(double salary){
	this.salary = salary;
    }

    @Override
    public String toString(){
	String ans = super.toString();
	ans += "\nsalary: " + salary;
	return ans;
    }

    @Override
    public double getPay(){
	return salary;
    }

    @Override
    public double payCheck(){
	return salary / 26;
    }
    
}
