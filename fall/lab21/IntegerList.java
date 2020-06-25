import java.util.ArrayList;

public class IntegerList extends ArrayList<Integer>{

    // constructor
    public IntegerList(int ... args){
	for (int x : args)
	    add(x);
    }

}
