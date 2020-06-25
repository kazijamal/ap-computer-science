import java.util.ArrayList;

public class Stats {

    private ArrayList<ScoreInfo> scoreList;
    // listed in increasing score order; no two ScoreInfo objects contain the same
    // score

    public Stats() {
	scoreList = new ArrayList<ScoreInfo>();
    }

    public boolean record(int score) {
	int i = 0;
	while (i < scoreList.size()) {
	    if (scoreList.get(i).getScore() == score) {
		scoreList.get(i).increment();
		return false;
	    }
	    else if (scoreList.get(i).getScore() > score) break;
	    i++;
	}
	scoreList.add(i, new ScoreInfo(score));
	return true;
    }

    public void recordScores(int[] stuScores) {
	for (int score : stuScores) {
	    record(score);
	}
    }

    public void print() {
	for (ScoreInfo score: scoreList) {
	    System.out.printf("%4d:%4d\n", score.getScore(), score.getFrequency());
	}
    }

    @Override
    public String toString() {
	return scoreList.toString();
    }

    public static void main(String[] args) {
	Stats s = new Stats();
	System.out.println(s);
	for (int i = 100; i >= 65; i -= 5) {
	    s.record(i);
	    System.out.println(s);
	}
	for (int i = 65; i < 90; i += 5) {
	    s.record(i);
	    System.out.println(s);
	}
	int[] stuScores = { 46, 65, 24, 105, 57, 87, 99, 32 };
	s.recordScores(stuScores);
	System.out.println(s);
	s.print();
    }

}
