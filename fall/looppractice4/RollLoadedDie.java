/* 1. Write the program RollLoadedDie.java that simulates rolling a six-sided
   die where the probability of getting a 1,2,3,4 or 5 is 1/8 and 3/8 for
   rolling a 6.

   $ javac RollLoadedDie.java
   $ java RollLoadedDie
*/

public class RollLoadedDie{
    
    public void run(){
	double r = Math.random();
	int roll = 0;
	for (int i = 0; roll == 0; i++){
	    if ((r >= i/8.0 - 1/8.0) && (r < i/8.0)){
		roll = i;
	    }
	    if (i == 6){
		roll = i;
	    }
	}
	System.out.println(roll);
    }
    public static void main(String [] args){
	new RollLoadedDie().run();
    }
    
}
