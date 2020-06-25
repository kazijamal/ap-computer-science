import java.util.ArrayList;

public class Children{

    public static void main(String [] args){
	new Children().run();
    }

    public void run(){

	int sumchildren = 0;
	int[] frequency = new int[100];
	for (int i = 0; i < 25; i++){
	    frequency[i] = 0;
	}

	for (int family = 0; family < 1000000; family++){
	    Coin gender = new Coin();
	    String first = gender.flip();
	    int numchildren = 1;
	    while (gender.flip() == first)
		numchildren++;
	    sumchildren += numchildren;
	    frequency[numchildren-1] += 1;
	}

	int max = 0;
	int maxi = 0;
	for (int i = 0; i < 25; i++){
	    System.out.println(i+1 + " children: " + frequency[i] + " families");
	    if (frequency[i] > max){
		max = frequency[i];
		maxi = i;
	    }
	}

	System.out.println("average number of children for 1,000,000 famiies: " + sumchildren / 1000000.0);
	System.out.println("number of children with highest frequency: " + (maxi+1));

    }
}
