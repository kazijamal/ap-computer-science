import java.util.ArrayList;

public class ListDemo{

    public static void main(String [] args){
	new ListDemo().run();

    }

    public void run(){
	ArrayList<String> list = new ArrayList<String>();
	System.out.println ("empty?: " + list.isEmpty());
	System.out.println("empty list: " + list + " size: " + list.size());
	list.add("a");	     	   
	System.out.println("add a: " + list + " size: " + list.size());  
	list.add("b");
	System.out.println("add b: " + list + " size: " + list.size());  
	list.add("d");
	System.out.println("add d: " + list + " size: " + list.size());  
	list.add(2,"c");
	System.out.println("add c at 2: " + list + " size: " + list.size());
	System.out.println("value at index 1: " + list.get(1));
	list.set(1,"B");
	System.out.println("set B at 1: " + list + " size: " + list.size());
	list.remove("c");
	System.out.println("remove first occurence of c: " + list + " size: " + list.size());
	System.out.println("contains b? " + list.contains("b"));
	System.out.println("index of d: " + list.indexOf("d"));
	list.add("d");
	System.out.println("add d: " + list + " size: " + list.size());
	System.out.println("last index of d: " + list.lastIndexOf("d"));
	list.clear();
	System.out.println("clear list: " + list + " size: " + list.size());
    }
}
