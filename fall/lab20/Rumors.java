// Kazi Jamal and Sunan Tajwar Period 1

import java.util.Scanner;

public class Rumors{

    public static void main(String [] args){
	new Rumors().run();
    }

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("Enter number of trials: ");
	int numtrials = sys.nextInt();
	System.out.print("Enter number of guests (excluding Alice): ");
	int numguests = sys.nextInt();
	probRumor(numtrials,numguests);
    }

    private void probRumor(int numtrials, int numguests){
	int sumallheard = 0;
	int totalnumheard = 0;
	for (int trial = 0; trial < numtrials; trial++){
	    int[] guests = new int[numguests];
	    int heardfrom = -1;
	    int telling = -1;
	    while (true){
		int rand = (int) (Math.random() * numguests);
		while (rand == telling || rand == heardfrom)
		    rand = (int) (Math.random() * numguests);   
		guests[rand] += 1;
		if (guests[rand] > 1) break;
		heardfrom = telling;
		telling = rand;
	    }
	    boolean allheard = true;
	    for (int x : guests){
		if (x > 0) totalnumheard += 1;
		if (x == 0) allheard = false;
	    }
	    if (allheard) sumallheard += 1;
	}
	double probability = ((double) sumallheard) / numtrials;
	double avgnumheard = ((double) totalnumheard) / numtrials;
	System.out.println("Probability that everyone at the party will hear the rumor: " + probability);
	System.out.println("Estimate of the expected number of people to hear the rumor:" + avgnumheard);
    }

}
