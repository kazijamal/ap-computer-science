public class Student implements Person{

    // instance variables
    String name;
    String street;
    int number;

    // constructor
    public Student(String name, String street, int number){
	this.name = name;
	this.street = street;
	this.number = number;
    }

    @Override
    public String getName(){
	return name;
    }

    @Override
    public String getStreet(){
	return street;
    }

    @Override
    public int getNumber(){
	return number;
    }

    @Override
    public String toString(){
	return "name: " + name + "\tstreet: " + street + "\tnumber: " + number;
    }

    /** If this student and other live on the same street,
     *   returns the absolute value of the difference in the
     *   numbers of their houses; otherwise returns 99999.
     *   Precondition: other != null
     */
    public int distance(Student other){
	if (street.equals(other.getStreet())){
	    return Math.abs(number - other.getNumber());
	}
	return 99999;
    }

}
