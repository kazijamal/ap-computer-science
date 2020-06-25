import java.util.ArrayList;

public class SSearchStats extends Stopwatch{

  public static int binarySearch(int [] data, int key, int lo, int hi){
    while (lo < hi){
      int m = lo + (hi - lo) / 2;
	    if (data[m] == key) return m;
	    if (key < data[m]) hi = m;
	    else lo = m + 1;
		     }
	return -1;
    }

  public static int ModifiedBinarySearch(int [] data, int key, int lo, int hi){
    if (lo >= hi) return -1;
    int m = lo + (hi - lo) / 2;
    if (data[m] == key) return m;
    if (key < data[m])
    return ModifiedBinarySearch(data,key, lo, m);
    return ModifiedBinarySearch(data,key, m, hi);
  }

  public static int LinearSearch(int [] data, int key){
    for (int i = 0; i < data.length; i++){
      if (data[i] == key) return data[i];
    }
    return -1;
  }

  public static int[][] createArray(){
    int arr[][] = new int[9][100000];
    int n = 166660;
    int m = 10;
    int l = 0;
    while (m <= 100000){
      for (int i = 0; i < m; i++){
        arr[l][i] = n;
        n--;
      }
      if (l % 2 == 0) m *= 5;
      else m *= 2;
      l++;
    }
    return arr;
  }

  public static void main(String [] args){
    Stopwatch timer = new Stopwatch();
    int data[][] = createArray();
    System.out.printf("   %-9s|%10s%n|%10s%n", "N", "Linear", "Binary");
    System.out.println("-------------------------------------");
    for (int i = 0; i < data[i].indexOf(0); i++){
      System.out.println();
      int key = data[i][0] + (data[i][data[i].length-1] - data[i][0]) / 2;
      timer.start();
      ModifiedBinarySearch(data[i], key, data[i][0], data[i][data[i].length-1]);
      timer.stop();
      long time1 = timer.elapsedTime() / 1000;
      timer.start();
      LinearSearch(data[i], key);
      timer.stop();
      long time2 = timer.elapsedTime() / 1000;
      System.out.printf("%9d   |%15.8f%n   |%15.8f%n", "N", "Linear", "Binary");
    }
  }

}
