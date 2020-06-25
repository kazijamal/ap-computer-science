public class Table{

    public void run(){
	for (int i = 1000; i < 2000; i++){
	    if (i % 5 == 0){
		System.out.println(i + "\t" + (i+1) + "\t" + (i+2) + "\t" + (i+3) + "\t" + (i+4));
	    }
	}
    }

    public static void main(String [] args){
	new Table().run();
    }

}
