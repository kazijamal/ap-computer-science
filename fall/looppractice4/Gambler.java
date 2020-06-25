/* 3. Write the program Gambler.java that takes 3 integer command-line arguments:
   stake, goal and trials. The program simulates a gambler with $stake who
   makes a series of $1 bets, continuing until going broke or reaching $goal.
   Make each bet fair; 50% of winning.

   Repeat the above experiment trials times, recording how many times the
   gambler reached the goal and the number of bets placed in a trial.

   
   This simulation should verify the following results:
     
       i.The probability of success is the ratio of the stake to the goal.
      ii.The expected number of bets is the product of the stake and the 
         desired gain (the difference between the goal and stake).  
	 
  Example, if you go to Monte Carlo to turn $500 to $2500 you have 
  a 20% of success but you should expect to make a million $1 bets.
  If you try to turn $1 to $1000, you have a 0.1% chance and can expect
  to be done (ruined, most likely) in about 999 bets.


  
    Sample Runs:
    ===========
   $ java Gambler 10 20 1000
     50% wins
     Avg # bets: 100
   
   $ java Gambler 10 20 1000
     51% wins
     Avg # bets: 98

   $ javac Gambler.java
   $ java Gambler stake goal trials
*/

public class Gambler{

    public static void main(String [] args){
	int stake = Integer.parseInt(args[0]);
	int goal = Integer.parseInt(args[1]);
	int trials = Integer.parseInt(args[2]);
	int sumbets = 0;
	int wins = 0;
	for (int i = 0; i <= trials; i++){
	    int money = stake;
	    int bets = 0;
	    while(money > 0 && money < goal){
		double r = Math.random();
		if ((r >= 0) && (r < 1/2.0)){
		    money --;
		}
		if ((r >= 1/2.0) && (r < 1)){
		    money ++;
		}
		bets ++;
	    }
	    if (money == goal) wins++;
	    sumbets += bets;
	}
	double winrate = wins / (double) trials * 100;
	double avgbets = sumbets / (double) trials;
	System.out.println(winrate + "% wins");
	System.out.println("Avg # bets: " + (int) avgbets);
    }

}
