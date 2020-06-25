import java.util.List;
import java.util.ArrayList;

public class SchoolTransport{

    /** List of all bus routes for this school **/
    private List<SchoolBus> buses;

    // constructor
    public SchoolTransport(){
	buses = new ArrayList<SchoolBus>();
    }

    public void addBus(SchoolBus b){
	buses.add(b);
    }

    public boolean enroll(Student student){
	int mindist = 9999;
	int minbus = 0;
	int busno = 0;
	for (SchoolBus b : buses){
	    if (!(b.isFull())){
		for (Student s : b){
		    int dist = student.distance(s);
		    if (dist == 0){
			b.add(student);
			return true;
		    }
		    if (dist <= mindist){
			mindist = dist;
			minbus = busno;
		    }
		}
	    }
	    busno++;
	}
	return buses.get(minbus).add(student);
    }

    public static void main(String [] args){
	SchoolTransport t = new SchoolTransport();
	t.addBus(new SchoolBus(2));
	t.buses.get(0).add(new Student("Bob", "East", 8));
	t.addBus(new SchoolBus(3));
	t.buses.get(1).add(new Student("Jordan", "South", 4));
	t.buses.get(1).add(new Student("Jeff", "West", 4));
	t.addBus(new SchoolBus(2));
	t.buses.get(2).add(new Student("Jesse", "East", 4));
	t.enroll(new Student("Ed", "East", 9));
	int busno = 0;
	for (SchoolBus b : t.buses){
	    System.out.println("Bus Number " + busno + ": ");
	    for (Student s : b){
		System.out.println(s);
	    }
	    System.out.println();
	    busno++;
	}
    }

}
