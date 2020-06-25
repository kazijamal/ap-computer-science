public class FreeFunctions {

    // postcondition: returns the number of occurrences of word in C
    public static int occurrences(WordCollection C, String word) {
        int count = 0;
	int pos = C.indexOf(word);
	if (pos == -1)
	    return count;
        for (int i = pos; i < C.size(); i++) {
            if (word.equals(C.findKth(i))) count++;
	    else break;
        }
        return count;
    }

    // postcondition: if word is present in C, all but one occurrence
    // is removed; otherwise, C is unchanged
    public static void removeDuplicates(WordCollection C, String word) {
	int n = occurrences(C, word);
        while (n > 1) {
            C.remove(word);
	    n--;
        }
    }

    // precondition: C is not empty
    // postcondition: returns the word that appears most often in C;
    // if there is more than one such word, returns any one of those words
    public static String mostCommon(WordCollection C) {
        int max = 0;
        String ans = null;
	int freq = 1;
        for (int i = 0; i < C.size(); i += freq) {
            String current = C.findKth(i);
	    freq = occurrences(C, current);
            if (freq > max) {
                max = freq;
                ans = current;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = { "test", "one", "two", "test", "three", "test" };
        WordCollection w = new WordCollection(words);
        System.out.println(w);
        System.out.println("occurences of test: " + occurrences(w, "test"));
        System.out.println(w);
        System.out.println("most common: " + mostCommon(w));
        removeDuplicates(w, "test");
        System.out.println("remove duplicates of test");
        System.out.println(w);
    }

}
