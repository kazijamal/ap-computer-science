public class Athlete implements Trainable{

    private String firstname, lastname;
    private double hours;

    // constructor
    public Athlete(String firstname, String lastname){
	this.firstname = firstname;
	this.lastname = lastname;
    }

    // accessor
    public double getHoursTrained(){
	return hours;
    }

    @Override
    public void train(double hours){
	this.hours += hours;
    }

    @Override
    public String toString(){
	return "\n" + lastname + ", " + firstname + "\nHours trained: " + hours + "\n";
    }

    public static void main(String [] args){
	Athlete kj = new Athlete("Kazi", "Jamal");
	System.out.println(kj.getHoursTrained() + " hours trained");
	System.out.println(kj);
	kj.train(24.0);
	System.out.println(kj.getHoursTrained() + " hours trained");
	System.out.println(kj);
    }

}
