// Kazi Jamal and Sunan Tajwar Period 1

import java.util.Stack;

public class Roll {

	public static void roll(Stack<String> stack, int n, int k) {
		if (n < 0 || k < 0 || n > stack.size()) {
			throw new RuntimeException("roll: argument out of range");
		}
		Stack<String> s1 = new Stack<String>();
		for (int i = 0; i < k % n; i++) {
			s1.push(stack.pop());
		}
		Stack<String> s2 = new Stack<String>();
		for (int i = 0; i < n - (k % n); i++) {
			s2.push(stack.pop());
		}
		while (!s1.empty()) {
			stack.push(s1.pop());
		}
		while (!s2.empty()) {
			stack.push(s2.pop());
		}
	}

	public static void main(String[] args) {
		Stack<String> stack1 = new Stack<String>();
		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		stack1.push("D");
		System.out.println(stack1);
		roll(stack1, 4, 1);
		System.out.println(stack1);
		System.out.println();

		Stack<String> stack2 = new Stack<String>();
		stack2.push("A");
		stack2.push("B");
		stack2.push("C");
		stack2.push("D");
		System.out.println(stack2);
		roll(stack2, 3, 2);
		System.out.println(stack2);
		System.out.println();

		Stack<String> stack3 = new Stack<String>();
		stack3.push("A");
		stack3.push("B");
		stack3.push("C");
		stack3.push("D");
		System.out.println(stack3);
		roll(stack3, 2, 4);
		System.out.println(stack3);
	}

}
