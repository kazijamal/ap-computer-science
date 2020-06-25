import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Stats {

	// returns median of an array
	public static double median(int[] data) {
		Arrays.sort(data);
		int n = data.length;
		if (n % 2 != 0)
			return data[n / 2];
		return (data[n / 2] + data[n / 2 - 1]) / 2.0;
	}

	// returns median of a List
	public static double median(List<Integer> data) {
		Collections.sort(data);
		int n = data.size();
		if (n % 2 != 0)
			return data.get(n / 2);
		return (data.get(n / 2) + data.get(n / 2 - 1)) / 2.0;
	}

	// returns mode of an array
	public static double mode(int[] data) {
		Arrays.sort(data);
		int maxcount = 0;
		int currcount = 1;
		int curr = data[0];
		int max = -1;
		for (int i = 1; i < data.length; i++) {
			if (curr == data[i])
				currcount++;
			curr = data[i];
			if (currcount > maxcount) {
				maxcount = currcount;
				max = curr;
			}
		}
		return max;
	}

	// returns mode of a List
	public static double mode(List<Integer> data) {
		Collections.sort(data);
		int maxcount = 0;
		int currcount = 1;
		int curr = data.get(0);
		;
		int max = -1;
		for (int i = 1; i < data.size(); i++) {
			if (curr == data.get(i))
				currcount++;
			curr = data.get(i);
			if (currcount > maxcount) {
				maxcount = currcount;
				max = curr;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// creates 2 random sequences of integers
		// one stored in an array the other in a list
		int[] arr = new int[10];
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			int arrRandom = (int) (Math.random() * 100);
			arr[i] = arrRandom;
			int listRandom = (int) (Math.random() * 100);
			list.add(listRandom);
		}

		// prints array and its median and mode
		for (int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
		System.out.println("median: " + median(arr));
		System.out.println("mode: " + mode(arr));

		// prints list and its median and mode
		System.out.println(list);
		System.out.println("median: " + median(list));
		System.out.println("mode: " + mode(list));
	}

}
