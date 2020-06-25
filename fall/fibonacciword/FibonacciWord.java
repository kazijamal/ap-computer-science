java import.util.Scanner;

public class FibonacciWord{

    public string fibonacciWord(int n, string a, string b){
	if (n == 0) return a;
	if (n == 1) return b;
	return (fibonacciWord(n-1) + fibonacciWord(n-2));
    }
