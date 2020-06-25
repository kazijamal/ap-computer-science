import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;


public class JumpingLeprechauns{

  private static Map<int[], double[]> map;
  private static int[] gold;
  private static double[] horizonPos;

  public static void init(int n){
    gold = new int[n];
    horizonPos = new double[n];
    Map map = new TreeMap<int[], double[]>();
    for (int i = 0; i < n; i++){
      gold[i] = 1000000;
      horizonPos[i] = 1000000;
    }
  }

  // Linear-search function to find the index of an element
   private static int indexOf(double arr[], double t){
      if (arr == null) return -1;
      for (int i = 0; i < arr.length; i++){
        if (arr[i] == t) return i;
      }
      return -1;
   }

   private static int indexOf(int arr[], int t){
      if (arr == null) return -1;
      for (int i = 0; i < arr.length; i++){
        if (arr[i] == t) return i;
      }
      return -1;
   }

  public static void iterate(int m){
    for (int i = 0; i < m; i++){
      int l = (int) Math.random() * gold.length + 1;
      float r = -1 + ( (float) Math.random()) * 2;
      horizonPos[l] = horizonPos[l] + ((double) r * gold[l]);
      double temp = horizonPos[l];
      Arrays.sort(horizonPos);
      if((gold[indexOf(horizonPos,temp)]-gold[indexOf(horizonPos,temp)-1]) < (gold[indexOf(horizonPos,temp)]-gold[indexOf(horizonPos,temp)+1])){
        gold[indexOf(horizonPos,temp)] += gold[indexOf(horizonPos,temp)-1]/2;
        gold[indexOf(horizonPos,temp)-1] = gold[indexOf(horizonPos,temp)-1]/2;
      }
      else{
        gold[indexOf(horizonPos,temp)] += gold[indexOf(horizonPos,temp)+1]/2;
        gold[indexOf(horizonPos,temp)+1] = gold[indexOf(horizonPos,temp)+1]/2;
      }
    }
  }



}
