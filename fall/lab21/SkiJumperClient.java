import java.util.ArrayList;
import java.util.Collections;

public class SkiJumperClient{


    public static void main(String [] args){
	new SkiJumperClient().run();
    }

    public void run(){
	SkiJumper sj1 = new SkiJumper("Bill", "Joy");
	SkiJumper sj2 = new SkiJumper("Mary", "Jane");
	SkiJumper sj3 = new SkiJumper("Jue", "Lee");
	ArrayList<SkiJumper> jumpers = new ArrayList<SkiJumper>();
	jumpers.add(sj1);
	jumpers.add(sj2);
	jumpers.add(sj3);
	
	System.out.println("jumpers: " + jumpers);
	System.out.println();
       

	for(SkiJumper s : jumpers){
	    s.train(100 * Math.random());
	    int jumps = (int)(Math.random() * 10);
	    while (jumps-- > 0) s.fly();

	}
	System.out.println("jumpers: " + jumpers);
	System.out.println();
	Collections.sort(jumpers);
	System.out.println("jumpers: " + jumpers);
    }


}
