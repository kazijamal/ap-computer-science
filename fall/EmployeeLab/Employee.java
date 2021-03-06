public abstract class Employee{

    // instance variables
    private String name;

    // constructor
    public Employee(String name){
	this.name = name;
    }

    // getters
    public String getName(){
	return name;
    }

    public abstract double getPay();

    @Override
    public String toString(){
	return "Name: " + name;
    }

}
