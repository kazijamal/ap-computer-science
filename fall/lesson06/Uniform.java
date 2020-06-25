public class Uniform{

    public static int uniform(int n){
        return (int) (Math.random() * n);
    }

    public static int uniform(int a, int b){
	return (int) (Math.random() * (b-a)) + a;
    }
    
    public static void main(String [] args){
	int n = Integer.parseInt(args[1]);
	int a = Integer.parseInt(args [0]);
	int b = Integer.parseInt(args [1]);
	System.out.println(uniform(n));
	System.out.println(uniform(a, b));
    }

}
