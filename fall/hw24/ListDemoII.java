/*
  Constructor:
         new ArrayList<E>()

 Methods

  int     size()              : returns the length of the list
  boolean isEmpty()           : returns true if empty
  E       get(int i)          : returns the element at index i
  E       set(int i,E val)    : places val at index i and 
                                returns the replaced val
  boolean add(E val)          : adds to the end
  void    add(int i, E val)   : inserts val at i
  E       remove(int i)          : returns and removes the element at i
  boolean remove(E val)       : removes the first occurrence if found
                                returns true if val is removed
  void    clear()             : removes all elements
  boolean contains(E val)     : returns true if list contains val
  int     indexOf(E val)      : returns the first index of val or -1
                                if not found
  int     lastIndexOf(E val)  : returns the last index of val or -1

 */


import java.util.ArrayList;

public class ListDemoII{

    public static void main(String [] args){
	new ListDemoII().run();
    }

    public void run(){
	ArrayList<String> list1 = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();
	String s = "abacadefg";
	for (int i = 0; i < s.length(); i++){
	    if (i % 2 == 0) list1.add(s.substring(i,i+1));
	    else list2.add(s.substring(i,i+1));
	}
	System.out.println("list 1: " + list1);
	System.out.println("list 2: " + list2);
	// Test numOccurrences
	System.out.println("a occurs " + numOccurrences(list1,"a") + " times in " + list1);
	// Test append
	System.out.println("append(" + list1 + ", " + list2 + "): " + append(list1,list2));
	System.out.println("append(" + list2 + ", " + list1 + "): " + append(list2,list1));
	// Test reverse
	System.out.println ("before reversing: " + list1);
	reverse(list1);
	System.out.println ("after reversing: " + list1);
	// Test isSorted
	System.out.println(list1 + " is sorted " + isSorted(list1));
	System.out.println(list2 + " is sorted " + isSorted(list2));
	// Test removeAll -- version 1
	System.out.println(list1 + " remove all \"a\" " + removeAll("a", list1));
	// Test slice
	System.out.println(list1 +  " slice 0 3 2 " + slice(list1,0,3,2));
      	System.out.println(list2 +  " slice 1 3 1 " + slice(list2,1,3,1));
	System.out.println("before removing a from list1: " + list1);
	removeAll(list1,"a");
	System.out.println("remove a from list1: " + list1);
	list1.remove("g");
	list1.add("g");
	System.out.println(list1);
	System.out.println(list2);
	System.out.println(merge(list1,list2));
    }


    private int numOccurrences(ArrayList<String> list, String x){
	int ans = 0;
	for (String a : list)
	    if (a.equals(x)) ans++;
	return ans;
    }
     // Pre:   list1 and list2 are lists.
     // Post:  Returns a new list by appending the elements of list2 to the
     //        end of list1. NO SIDE EFFECTS ARE PRODUCED.
    private ArrayList<String> append(ArrayList<String> list1, ArrayList<String> list2){
	ArrayList<String> ans = new ArrayList<String>();
	for (String x: list1)
	    ans.add(x);
	for (String x : list2)
	    ans.add(x);
	return ans;
	
    }
     // Pre:  list != null
     // Post: Reverses the order of the elments of list 
    private void reverse(ArrayList<String> list){
	final int N = list.size();
	for (int i = 0; i < N/2; i++)
	    list.set(i,list.set(N-i-1,list.get(i)));
    }


    //  ********************** PROBLEM #1 ********************************************
    // Pre: list != null
    // Post: returns true if list is sorted in increasing order; false otherwise
    //       isSorted([a,a,b,c]) -> true
    //       isSorted([c,b,a,a]) -> false
    private boolean isSorted(ArrayList<String> list){
	for (int i = 0; i < list.size() - 1; i++){
	    if (list.get(i).compareTo(list.get(i+1)) > 0)
		return false;
	}
	return true;
    }

    //  ********************** PROBLEM #2 ********************************************
    // Pre: list != null
    // Post : Returns a new list by removing all occurrences of x from list.
    private ArrayList<String> removeAll(String x, ArrayList<String> list){
	ArrayList<String> ans = new ArrayList<String>();
	for (String a : list){
	    if (!a.equals(x)) ans.add(a);
	}
	return ans;
    }

    //  ********************** PROBLEM #3 ********************************************
    //  Pre: list != null, from <= to, step > 0
    //  Post: returns a new list that contains the elements from list starting  
    //        at index from up to but not including the element at index to.
    //       slice([a,b,c], 0,1,1) -> [a]
    //       slice([a,b,c], 0,2,1) -> [a, b]
    //       silce([a,b,c,d,e], 1, 5, 2) -> [b,d] 
    private ArrayList<String> slice(ArrayList<String> list, int from , int to, int step){
	ArrayList<String> ans = new ArrayList<String>();
	for (int i = from ; i < to ; i += step)
	    ans.add(list.get(i));
	return ans;
    }

    //  ********************** PROBLEM #4 ********************************************
    // Pre: list1 and list2 are both sorted in increasing order
    // Post: returns a new sorted list, in increasing order, by merging
    //       list1 and list2. NO SIDE EFFECTS ARE PRODUCED.
    private ArrayList<String> merge1(ArrayList<String> list1, ArrayList<String> list2){
	ArrayList<String> ans = new ArrayList<String>();
	int i1, i2;
	i2 = i1 = 0;
	while (i1 < list1.size() && i2 < list2.size()){
	    if (list1.get(i1).compareTo(list2.get(i2)) < 0){
		ans.add(list1.get(i1));
		i1++;
	    }
	    else{
		ans.add(list2.get(i2));
		i2++;
	    }
	}
	if (i1 < list1.size()){
	    while (i1 < list1.size()){
		ans.add(list1.get(i1));
		i1++;
	    }
	}
	else if (i2 < list2.size()){
	    while (i2 < list2.size()){
		ans.add(list2.get(i2));
		i2++;
	    }
	}
	return ans;
    }

    private ArrayList<String> merge(ArrayList<String> list1, ArrayList<String> list2){
	ArrayList<String> ans = new ArrayList<String>();
	int i = 0, j = 0;
	while (true){
	    if (i >= list1.size() || j >= list2.size())
		break;
	    if (list1.get(i).compareTo(list2.get(j)) < 0){
		ans.add(list1.get(i));
		i++;
	    }
	    else{
		ans.add(list2.get(j));
		j++;
	    }
	}
	while (i < list1.size()) ans.add(list1.get(i++));
	while (j < list2.size()) ans.add(list2.get(j++));
	return ans;
    }

    //  ********************** PROBLEM #5 ********************************************
    // Pre: list != null
    // Post: Produces the side effect that all occurrences of x are removed from list.
    private void removeAll1(ArrayList<String> list, String x){
	int len = list.size();
	for (int i = 0; i < len; i++){
	    if (list.get(i).equals(x)){
		list.remove(i);
		i--;
		len--;
	    }
	}
    }

    private void removeAll(ArrayList<String> list, String x){
	while (list.contains(x)) list.remove(x);
    }
    
}
