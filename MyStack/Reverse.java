import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		MyStack<Integer> s = new NodeStack<Integer>();
		Scanner sys = new Scanner(System.in);
		System.out.println("Enter a list of integers, ending with 0:");
		System.out.print("? ");
		int n = sys.nextInt();
		while (n != 0) {
			s.push(n);
			System.out.print("? ");
			n = sys.nextInt();
		}
		System.out.println("Those integers in reverse order are:");
		while (!s.empty()) {
			System.out.println(s.pop());
		}
	}

}
