
/*
  Reduction to Sorting
  =====================

  A problem A reduces to a problem B if we can use a solution to B
  to solve A.

  Given a new problem, ask yourself how you would solove it if the
  data were sorted.

  Consider the problem of determining  element distinctness in a
  sequence. To solve the problem, it is easier to first sort
  the sequence efficiently, O(NlogN),  then use a linear pass.
  Thus the element distinctness problem reduces to sorting.

  Java Classes
  ============
  Both Arrays.sort()  and Collections.sort() use the merge sort
  algorithm which is linearithmic, O(NlogN).


  Exercises:
  ==========
  1. Write Stats.java, a program that creates 2 random sequence
  of integers one stored in an array the other in a list.
   
  2. Add to Stats.java the methods median(int[] data) and
  median(List<Integer> data) that computes in lineararithmic time
  the median of n integers. Hint: Reduce to sorting.


  3. Add to Stat.java the methods mode(int[] data) and mode(List<Integer> data)
  to compute the mode. Hint: Reduce to sorting.
*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Stats {
    // pre: n > 0, lo <= hi
    // post: returns a n element array of random integers
    // each element is within [lo,hi).
    public static int[] randomArray(int n, int lo, int hi) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = lo + (int) (Math.random() * (hi - lo));
        return ans;
    }

    // post: prints an array
    public static void print(int[] data) {
        for (int x : data)
            System.out.print(x + " ");
        System.out.println();
    }

    // O(NlogN)
    public static double median(int[] data) {
	Arrays.sort(data);
	int n = data.length;
	if (n % 2 != 0)
	    return data[n / 2];
	return (data[n / 2] + data[n / 2 - 1]) / 2.0;
    }

    // O(NlogN)
    public static double median(List<Integer> data) {
	Collections.sort(data);
	int n = data.size();
	if (n % 2 != 0)
	    return data.get(n / 2);
	return (data.get(n / 2) + data.get(n / 2 - 1)) / 2.0;
    }

    // O(NlogN)
    public static int mode(int[] data){
        Arrays.sort(data);
        int maxcount = 0;
        int mode = -1;
        for (int i = 1; i < data.length; i++){
            int currcount = 0;
            while (data[i] == data[i-1]){
                i++;
                if (i >= data.length) break;
                currcount++;
            }
            if (currcount > maxcount){
                maxcount = currcount;
                mode = data[i-1];
            }
        }
        return mode;
    }

    // O(NlogN)
    public static int mode1(List<Integer> data) {
        Collections.sort(data);
        int maxcount = 0;
        int mode = -1;
        for (int i = 1; i < data.size(); i++){
            int currcount = 0;
            while (data.get(i) == data.get(i-1)){
                i++;
                if (i >= data.size()) break;
                currcount++;
            }
            if (currcount > maxcount){
                maxcount = currcount;
                mode = data.get(i-1);
            }
        }
        return mode;
    }

    public static int mode(List<Integer> data){
	Collections.sort(data);
	int currentFreq, maxFreq, maxFreqNumber;
	currentFreq = maxFreq = 1;
	maxFreqNumber = data.get(0);
	for (int i = 1; i < data.size(); i++){
	    if (data.get(i).equals(data.get(i-1)))
		currentFreq++;
	    else
		if (maxFreq < currentFreq){
		    maxFreq = currentFreq;
		    maxFreqNumber = data.get(i);
		}
	    currentFreq = 1;
	}
	return maxFreqNumber;
    }

    // pre: data != null
    // post: returns a list whose elements are chosen from data
    public static List<Integer> toList(int[] data) {
        List<Integer> ans = new ArrayList<Integer>();
        for (Integer x : data)
            ans.add(x);
        return ans;
    }

    public static void main(String[] args) {
        int[] data = randomArray(10, 1, 10);
        List<Integer> dataList = toList(data);

        // array version
        System.out.println("testing with arrays");
        print(data);
        System.out.println("median: " + median(data));
        System.out.println("mode: " + mode(data));
        print(data);
        System.out.println();

        // list version
        System.out.println("testing with lists");
        System.out.println(dataList);
        System.out.println("median: " + median(dataList));
        System.out.println("mode: " + mode(data));
        System.out.println(dataList);
    }

}
