import java.util.ArrayList;

public class Josephus {

	public static<E> MyQueue<E> buildQueue(ArrayList<E> players) {
		MyQueue<E> ans = new ArrayQueue<E>(players.size());
		for (E player : players)
			ans.add(player);
		return ans;
	}

	// Pre: k > 0
	// Post: Uses a round robin scheduler to determine the winner.
	public static<E> E josephus(MyQueue<E> q, int k) {
		while (q.size() > 1) {
			System.out.println("Children: " + q);
			for (int i = 0; i < k; i++) {
				q.add(q.remove());
			}
			System.out.println("Remove: " + q.remove());
		}
		return q.peek();
	}

	public static void main(String[] args) {
		ArrayList<String> players = new ArrayList<String>();
		players.add("Bobby");
		players.add("Sue");
		players.add("Amy");
		players.add("Mark");
		players.add("Danny");
		players.add("Kelly");
		players.add("Yuki");
		MyQueue<String> q = buildQueue(players);
		System.out.println(josephus(q, 2) + " is the WINNER!!!!!!");
	}

}
