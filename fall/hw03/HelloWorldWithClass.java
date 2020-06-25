// package declaration
package fall.hw03;

// A class definition
public class HelloWorldWithClass{

    // a non static method
    public void run(){
	System.out.println("hello, world");

    }

    // The main method. (boilerplate)
    public static void main (String [] args){
	new HelloWorldWithClass().run();

    }

}
