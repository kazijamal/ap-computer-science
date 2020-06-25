public class IntDemo{

    public static void main(String [] args){
	int a = Integer.MAX_VALUE;
	System.out.println(a); // 2147483647
	System.out.println(a + 1); // -2147483648
	System.out.println(2 - a); // -2147483645
	System.out.println(-2 - a); // 2147483647
	System.out.println(2 * a); // -2
	System.out.println(4 * a); // -4
	System.out.println(Math.abs(Integer.MIN_VALUE)); // -2147483648
	int x = 011;
	System.out.println(x); // 9
	x = 0x11;
	System.out.println(x); // 17
	x= 010 + 0x20;
	System.out.println(x); // 40
    }

}
