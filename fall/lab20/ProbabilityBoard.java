// Kazi Jamal and Sunan Tajwar Period 1

import java.util.Scanner;

public class ProbabilityBoard{

    public static void main(String [] args){
	new ProbabilityBoard().run();
    }

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("Enter number of marbles: ");
	int n = sys.nextInt();
	marbles(n);
    }

    private void marbles(int n){
	int[] channels = new int[10];
	for (int x = 0; x < n; x++){
	    int channel = 0;
	    for (int row = 0; row < 9; row++){
		int dir = (int) (Math.random() * 2);
		if (dir == 1){
		    channel += 1;
		}
	    }
	    channels[channel] += 1;
	}
	System.out.println("Channel        Marbles  ");
	System.out.println("------------------------");
	for (int i = 0; i < channels.length; i++){
	    String marbles = "";
	    for (int m = channels[i]; m > 0; m--){
		marbles += "*";
	    }
	    System.out.printf("%-15d%-9s",i,marbles);
	    System.out.println();
	}
    }

}
