/* 2. A two-dimensional random walk simulates the behavior of a particle moving
   in a grid of points. At each step, ther random walker moves north, south,
   east, or west with probability equal to 1/4, independent of previous
   moves. Write a program RandomWalker.java that takes an integer command-line
   argument n nd estimates how long it will take a random walker to hit the
   boundary of a (2n+1)-by-(2n+1) square centerd at the starting point.

   $ javac RandomWalker.java
   $ java RandomWalker n numtrials
*/

public class RandomWalker{

    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	int numtrials = Integer.parseInt(args[1]);
	int xcor = 0;
	int ycor = 0;
	double maxx, maxy, minx, miny;
	maxy = maxx = (2 * n + 1) / 2.0;
	miny = minx = -1 * maxx;
	int numsteps = 0;
	int sumsteps = 0;
	for (int i = 0; i <= numtrials; i++){
	    while ((xcor > minx && xcor < maxx) && (ycor > miny && ycor < maxy)){
		double r = Math.random();
		if ((r >= 0) && (r < 1/4.0)){
		    ycor++;
		}
		if ((r >= 1/4.0) && (r < 2/4.0)){
		    xcor++;
		}
		if ((r >= 2/4.0) && (r < 3/4.0)){
		    ycor--;
		}
		if ((r >= 3/4.0) && (r < 1.0)){
		    xcor--;
		}
		numsteps++;
	    }
	    sumsteps += numsteps;
	}
	double avgsteps = sumsteps/(double) numtrials;
	System.out.println(avgsteps);
    }

}
	
	
