public abstract class Shape{

    // data members
    private int numSides;

    // constructor
    public Shape(int numSides){
	this.numSides = numSides;
    }

    // getters
    public int getNumSides(){
	return numSides;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

}
