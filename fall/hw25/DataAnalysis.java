import java.util.ArrayList;

public class DataAnalysis{

    public static void main(String [] args){
	new DataAnalysis().run();
    }

    public void run(){
	ArrayList<Integer> data = new ArrayList<Integer> ();
	data.add(3);
	data.add(5);
	data.add(9);
	data.add(10);
	data.add(12);
	data.add(11);
	data.add(9);
	data.add(4);
	System.out.println("data : " + data);
	System.out.println("k = 4 " + isMode(data,4));
	System.out.println("k = 5 " + isMode(data,5));
	System.out.println("mode index " + modeIndex(data));
	printHistogram(data, 20, "x");
    }

    // precondition: 0 < k < data.size()
    public static boolean isMode(ArrayList<Integer> data, int k){
	return data.get(k) > data.get(k-1) && data.get(k) > data.get(k+1);
    }

    // precondition:  data is unimodal and data.size() ≥ 3
    public static int modeIndex(ArrayList<Integer> data){
	for (int k = 1; k < data.size()-1; k++)
	    if (isMode(data,k)) return k;
	return -1;
    }

    // precondition:  data is unimodal and data.size() ≥ 3;
    //                data.get(k) ≥ 0 for 0 ≤ k < data.size()
    public static void printHistogram(ArrayList<Integer> data, int longestBar, String barChar){
	int mode = data.get(modeIndex(data));
	for (int k = 0; k < data.size(); k++){
	    int lenBar = (int) ((double) data.get(k) / mode * longestBar);
	    for (int ch = 0; ch < lenBar; ch++)
		System.out.print(barChar);
	    System.out.println();
	}
    }
    
}
