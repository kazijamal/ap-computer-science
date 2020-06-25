public final class Domino{

    private final int L; // left side
    private final int R; // right side

    // Constructors
    // Default Constructor
    public Domino(){
	this(0,0);
    }
    // Constructor
    public Domino(int l, int r){
	L = l;
	R = r;
    }

    // Getters
    public int getLeftDots(){
	return L;
    }

    public int getRightDots(){
	return R;
    }

    @Override
    public String toString(){
	return "|" + L + "-" + R + "|";
    }
    
    @Override
    public boolean equals(Object rhs){
	if (!(rhs instanceof Domino)) return false;
	Domino r = (Domino) rhs;
	return Math.max(L,R) == Math.max(r.L,r.R) && Math.min(L,R) == Math.min(r.L,r.R);
    }	

}
