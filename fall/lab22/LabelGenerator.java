public class LabelGenerator{

    // instance variables
    private String prefix;
    private int index;

    // Constructor
    public LabelGenerator(String prefix, int init){
	this.prefix = prefix;
	index = init;
    }

    // Mutator
    public String nextLabel(){
	return prefix + index++;
    }

}
