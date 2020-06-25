// Extends Object is implied.
public class Point { 

    // public class Point extends Object {}  is understood.
    // General syntax  for class B to be a subclass of class A
    //              public class B extends A{}
  
    // instance variables (fields) : Neither will be directly accessible by clients because
    //                               of the private modifier
    private int x;
    private int y;


    // Constructors: instructs the compiler to  allocate memory for each field
    //               Generally used with the new operator. (new Point() )
    //               Constructors never have a return type
    // Default constructor: a constructor that takes no arguments.
    public Point(){
	// super();     // accesses the superclass(Object) default constructor
	this(0,0);      // refers to the Point(int,int) constructor
    }

    // An overloaded constructor: provides another version of a Construcor
    public Point(int x, int y){
	this.x = x;       // the paramters x and y overlap in scope with the fields x and y.
	this.y = y;       // Use the this reference to access the fields x and y.
    }
    // An overloaded constructor that returns a copy of the Point referred to by other.
    public Point (Point other){
	this(other.x, other.y);
    }
    

    //*********************** GETTER methods - provide read only access to the ADT's data
    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    // Post: Returns a copy of the Point object by creating a new instance of a Point
    public Point getLocation(){
	return new Point(this);
    }

    // Mutator Methods
    // Moves the point to (x,y)
    public void move (int x, int y){
	this.x = x;
	this.y = y;
    }
    // Moves the point to (x + dx, y + dy)
    public void translate(int dx, int dy){
	this.x = x + dx;
	this.y = y + dy;
    }

    // Moves the point to the location of other
    public void setLocation(Point other){
	move(other.x, other.y);
    }




    //********************* Override the method inherited from the Object class **********************
    // Often called automaically to convert a Point object to a String
    //    Point p = new Point(3,5);
    //    p  + " is a point"
    //    (3,5) + " is a point"
    //    "(3,5) is a point" 
    public String toString(){
	return "(" + x + ", " + y + ")";
    }


}
