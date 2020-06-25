package bridge;

/* 
   David Goldshteyn and Kazi Jamal Period 1
   Instructions to run code:
    javac Bridge.java
    java Bridge
   Output:
    experimental probability of 5-3-3-2 : *calculated probability from 1000 trials*
    experimental probability of 4-4-3-2 : *calculated probability from 1000 trials*
    experimental probability of 4-3-3-3 : *calculated probability from 1000 trials*
*/

public class Bridge{

    public static void main(String [] args){
	new Bridge().run();
    }

    public void run(){
	testing();
    }

    private void testing(){
	int prob5332 = 0, prob4432 = 0, prob4333 = 0;
	for (int trial = 0; trial < 1000; trial++){
	    int[] suits = new int[4];
	    for (int card = 0; card < 13; card++){
		int randsuit = (int) (Math.random() * 4);
		suits[randsuit] += 1;
	    }
	    if (suits[0] * suits[1] * suits[2] * suits[3] == 90)
		prob5332 += 1;
	    if (suits[0] * suits[1] * suits[2] * suits[3] == 96)
		prob4432 += 1;
	    if (suits[0] * suits[1] * suits[2] * suits[3] == 108)
		prob4333 += 1;
	}
	System.out.println("experimental probability of 5-3-3-2: " + prob5332/1000.0);
	System.out.println("experimental probability of 4-4-3-2: " + prob4432/1000.0);
	System.out.println("experimental probability of 4-3-3-3: " + prob4333/1000.0);
    }

}

