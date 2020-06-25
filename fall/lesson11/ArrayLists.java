import java.util.ArrayList;

public class ArrayLists{

    public static void main(String [] args){
	new ArrayLists().run();
    }

    public void run(){
	ArrayList<String> list1 = new ArrayList<String>();
	list1.add("test");
	list1.add("no");
	list1.add("test");
	// list1 = {"test","no","test")
	ArrayList<String> list2 = new ArrayList<String>();
	list2.add("list2");
	list2.add("more");
	list2.add("testing");
	list2.add("anotherone");
	// list2 = {"list2","more","testing","anotherone"}
	System.out.println(numOccurrences(list1,"test")); // returns 2
	System.out.println(append(list1,list2));
	reverse(list2);
	System.out.println(list2);
    }

    private int numOccurrences(ArrayList<String> list, String x){
	int count = 0;
	for (String s : list){
	    if (s.equals(x))
		count++;
	}
	return count;
    }

    private ArrayList<String> append(ArrayList<String> list1, ArrayList<String> list2){
	ArrayList<String> appended = new ArrayList<String>();
	for (String s : list1)
	    appended.add(s);
	for (String s : list2)
	    appended.add(s);
	return appended;
    }

    private void reverse(ArrayList<String> list){
	int s = 0;
	for (int i = list.size() - 1; i >= s; i--){
	    list.set(s,list.set(i,list.get(s)));
	    s++;
	}
    }

    
    
}
