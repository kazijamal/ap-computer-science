public class CommissionedEmployee extends Employee implements Payable{

    // instance variables
    private double baseSalary, commissionRate, salesVolume;

    // constructor
    public CommissionedEmployee(String name, double baseSalary, double commissionRate, double salesVolume){
	super(name);
	this.baseSalary = baseSalary;
	this.commissionRate = commissionRate;
	this.salesVolume = salesVolume;
    }

    // mutators
    public void setBaseSalary(double baseSalary){
	this.baseSalary = baseSalary;
    }
    
    public void setCommissionRate(double commissionRate){
	this.commissionRate = commissionRate;
    }

    public void setSalesVolume(double salesVolume){
	this.salesVolume = salesVolume;
    }

    @Override
    public String toString(){
	String ans = super.toString();
	ans += "\nbase salary: " + baseSalary;
	ans += "\ncommission rate: " + commissionRate;
	ans += "\nsales volume: " + salesVolume;
	return ans;
    }

    @Override
    public double getPay(){
	return baseSalary + (commissionRate * salesVolume);
    }

    @Override
    public double payCheck(){
	double payCheck = getPay() / 26;
	salesVolume = 0;
	return payCheck;
    }
    
}
