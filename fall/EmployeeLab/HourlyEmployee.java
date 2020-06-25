public class HourlyEmployee extends Employee implements Payable{

    // instance variables
    private double hourlyRate, hoursWorked;

    // constructor
    public HourlyEmployee(String name, double hourlyRate, double hoursWorked){
	super(name);
	this.hourlyRate = hourlyRate;
	this.hoursWorked = hoursWorked;
    }

    // mutators
    public void setHourlyRate(double hourlyRate){
	this.hourlyRate = hourlyRate;
    }

    public void setHoursWorked(double hoursWorked){
	this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString(){
	String ans = super.toString();
	ans += "\nhourly rate: " + hourlyRate;
	ans += "\nhours worked: " + hoursWorked;
	return ans;
    }

    @Override
    public double getPay(){
	return hoursWorked * hourlyRate;
    }

    @Override
    public double payCheck(){
	double payCheck = hoursWorked * hourlyRate;
	hoursWorked = 0;
	return payCheck;
    }

}
