public class SkiJumper extends Athlete implements Flier,Trainable,Comparable<SkiJumper>{

    private int jumps;

    // constructor
    public SkiJumper(String first, String last){
	super(first,last);
    }

    @Override
    public void fly(){
	jumps++;
    }

    @Override
    public int compareTo(SkiJumper other){
	return jumps - other.jumps;
    }

    // accessor
    public int getJumps(){
	return jumps;
    }

    @Override
    public String toString(){
	return super.toString() + "Jumps: " + jumps + "\n";
    }

}
