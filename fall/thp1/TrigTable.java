public class TrigTable{
    
    public static void main(String [] args){
	new TrigTable().run();
    }
    
    public void run(){
	System.out.println("theta  | sin(theta) | cos(theta) |");
	System.out.println("-------+------------+------------+");
	for (double t = -90.0; t <= 90; t += 15){
	    double sin = Math.sin(t*Math.PI/180);
	    double cos = Math.cos(t*Math.PI/180);
	    System.out.printf("%7d|",(int) t);
	    System.out.printf("%12.7f|", sin);
	    System.out.printf("%12.7f|", cos);
	    System.out.println();
	}
    }
    
}
