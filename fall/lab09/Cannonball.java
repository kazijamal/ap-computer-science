public class Cannonball{

    public int cannonball(int h){
	if (h == 1)
	    return 1;
	return (int) Math.pow(h,2) + cannonball(h-1);
    }
    
    public void run(int h){
	System.out.println(cannonball(h));
    }
    
    public static void main(String [] args){
	int h = Integer.parseInt(args[0]);
	new Cannonball().run(h);
    }

}
