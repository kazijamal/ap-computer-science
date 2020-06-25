import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class VoterBallots {

	private Map<String, Integer> voteCount;
	// key is the candidate name, value is the
	// number of votes received by that candidate.

	// precondition: each entry in ballotList is a Set representing
	// one voter's ballot.
	// postcondition: voteCount.get(candidate) is the total number of
	// times candidate appears on ballots in ballotList.
	public VoterBallots(List<Set<String>> ballotList) {
		voteCount = new HashMap<String, Integer>();
		for (Set<String> set : ballotList) {
			for (String str : set) {
				if (!voteCount.containsKey(str))
					voteCount.put(str, 1);
				else
					voteCount.put(str, voteCount.get(str) + 1);
			}
		}
	}

	// postcondition: returns an Integer object with value equal
	// to the key in the Map voteCount.
	private Integer maxVotes() {
		Set<String> candidates = voteCount.keySet();
		int max = 0;
		for (String candidate : candidates) {
			if (voteCount.get(candidate) > max) {
				max = voteCount.get(candidate);
			}
		}
		return max;
	}

	// postcondition: returns the set containing the candidate(s)
	// with the most votes
	public Set<String> candidatesWithMost() {
		Set<String> candidates = voteCount.keySet();
		int max = maxVotes();
		Iterator<String> itr = candidates.iterator();
		while (itr.hasNext()) {
			if (voteCount.get(itr.next()) != max) {
				itr.remove();
			}
		}
		return candidates;
	}

	// other methods not shown

	public static void main(String[] args) {
		List ballotList = new LinkedList<Set<String>>();
		Set a = new HashSet<String>();
		a.add("Chris");
		a.add("Jamie");
		Set b = new HashSet<String>();
		b.add("Chris");
		b.add("Sandy");
		Set c = new HashSet<String>();
		c.add("Chris");
		c.add("Sandy");
		c.add("Pat");
		c.add("Jamie");
		Set d = new HashSet<String>();
		d.add("Pat");
		d.add("Chris");
		Set e = new HashSet<String>();
		e.add("Sandy");
		e.add("Jamie");
		Set f = new HashSet<String>();
		f.add("Sandy");
		f.add("Pat");
		f.add("Jamie");
		Set g = new HashSet<String>();
		g.add("Jamie");
		g.add("Chris");
		ballotList.add(a);
		ballotList.add(b);
		ballotList.add(c);
		ballotList.add(d);
		ballotList.add(e);
		ballotList.add(f);
		ballotList.add(g);
		VoterBallots v = new VoterBallots(ballotList);
		System.out.println(v.voteCount);
		System.out.println(v.maxVotes());
		System.out.println(v.candidatesWithMost());
	}

}
