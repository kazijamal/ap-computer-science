public class LFSR {

    private String register;
    private int tap;
    private final int N;

    // creates an LFSR with the specified seed and tap
    public LFSR(String seed, int tap) {
        register = seed;
        this.tap = tap;
        N = seed.length();
    }
  
    // returns the number of bits in this LFSR
    public int length()  {
        return N;
    }

    // returns the ith bit of this LFSR (as 0 or 1)
    public int bitAt(int i)  {
        return Integer.parseInt(register.substring(N-i-1,N-i));
    }

    // returns a string representation of this LFSR
    public String toString()  {
        return register;
    }
   
    // simulates one step of this LFSR and returns the new bit (as 0 or 1)
    public int step() {
        int last = bitAt(N-1);
        int tapVal = bitAt(tap);
        if (last + tapVal == 1) {
            register += "1";
        }
        else {
            register += "0";
        }
        register = register.substring(1);
        return bitAt(0);
    }
  
    // simulates k steps of this LFSR and returns the k bits as a k-bit integer
    public int generate(int k) {
        int ans = 0;
        for (int i = 0; i < k; i++) {
            int bit = step();
            ans *= 2;
            ans += bit;
        }
        return ans;
    }

    // tests this class by directly calling all instance methods
    public static void main(String[] args) {
        LFSR lfsr = new LFSR("01101000010", 8);
        System.out.println("lfsr: " + lfsr);
        System.out.println();
        System.out.println("testing step:");
        for (int i = 0; i < 10; i++) {
            int bit = lfsr.step();
            System.out.println(lfsr + " " + bit);
        }
        System.out.println();
        System.out.println("testing generate:");
        lfsr = new LFSR("01101000010", 8);
        for (int i = 0; i < 10; i++) {
            int r = lfsr.generate(5);
            System.out.println(lfsr + " " + r);
        }
    }

}
