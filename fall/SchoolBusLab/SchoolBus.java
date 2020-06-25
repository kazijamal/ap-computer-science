import java.util.ArrayList;

public class SchoolBus extends ArrayList<Student>{
    
    // instance variables
    private int numseats;

    // constructor
    public SchoolBus(int numseats){
	this.numseats = numseats;
    }

    public boolean isFull(){
	return size() == numseats;
    }

    @Override
    public boolean add(Student s){
	if (isFull()) return false;
	return super.add(s);
    }

    @Override
    public void add(int n, Student s){
	if (!(isFull()))
	    super.add(n, s);
    }
    
}
