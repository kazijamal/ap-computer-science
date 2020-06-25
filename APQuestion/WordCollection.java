import java.util.ArrayList;

public class WordCollection {

    private ArrayList<String> collection;

    // constructor
    // postcondition: creates an empty WordCollection
    public WordCollection() {
        collection = new ArrayList<String>();
    }

    // postcondition: Copys from the String[] to the WordCollection
    // O(N^2)
    public WordCollection(String[] words) {
        this();
        for (String word : words) {
            insert(word); // O(N)
        }
    }

    // returns the total number of items stored in the collection
    public int size() {
        return collection.size();
    }

    // returns kth word in alphabetical order, where
    // 0 ≤ k < size()
    // O(1)
    public String findKth(int k) {
        return collection.get(k);
    }

    // adds word to the collection (duplicates allowed) by maintaining
    // a sorted(ascending) list of words.
    // O(N)
    public void insert(String word) {
        for (int i = 0; i < size(); i++) {
            if (findKth(i).compareTo(word) >= 0) {
                collection.add(i, word);
                return;
            }
        }
        collection.add(word);
    }

    // returns the index of the first occurrence of word in the collection
    // returns -1 if not found.
    // O(N)
    public int indexOf(String word) {
        for (int i = 0; i < size(); i++) {
            if (findKth(i).equals(word))
                return i;
        }
        return -1;
    }

    // uses binary search
    public int indexOf2(String word) {
        int lo = 0;
        int hi = size(); // [lo, hi)
        int m = lo + (hi - lo) / 2;
        while (!(word.equals(collection.get(m)))) {
            if (word.compareTo(collection.get(m)) > 0)
                lo = m + 1;
            else
                hi = m;
            m = lo + (hi - lo) / 2;
        }
        if (hi - lo == 0)
            return -1;
        while (m > 0 && word.equals(collection.get(m))) {
            m--;
        }
        return m;
    }

    // removes one instance of word from the collection if word is
    // present; otherwise, does nothing
    // O(N)
    public void remove(String word) {
        if (indexOf(word) != -1)
            collection.remove(indexOf(word));
    }

    public String toString() {
        return collection.toString();
    }

    public static void main(String[] args) {
        WordCollection w = new WordCollection();
        System.out.println(w);
        String[] words = { "apple", "dog", "turtle", "zebra", "blue", "bagel" };
        for (String word : words) {
            w.insert(word);
            System.out.println(w);
        }
        System.out.println("\nindexOf blue: " + w.indexOf("blue"));
        w.remove("blue");
        System.out.println("\nremove blue: ");
        System.out.println(w);
        WordCollection w2 = new WordCollection(words);
        System.out.println("\n" + w2);
    }

}
