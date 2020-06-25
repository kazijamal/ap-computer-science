import java.util.ArrayList;

public class PointClient{

    public static void main(String [] args){
	new PointClient().run();

    }
    public void run(){
	Point p1 = new Point();
	Point p2 = new Point(2,5);
       
	// testing the toString methods
	System.out.println("p1 : " + p1);
	System.out.println("p2 : " + p2);
	// testing getX() and getY() methods
	System.out.println(p1 + " p1.getX() " + p1.getX());
	System.out.println(p1 + " p1.getY() " + p1.getY());
	System.out.println(p2 + " p2.getX() " + p2.getX());
	System.out.println(p2 + " p2.getY() " + p2.getY());
	// Test the Constructor Point(Point other)
	Point p3 = new Point(p2);
	System.out.println("p3 : " + p3);

	// Test the method getLocation
	Point p4 = p3.getLocation();
	System.out.println(p3 + " get location " + p4); 


	// Testing mutability
	Point x = new Point(1,1);
	System.out.println("Before moving: " + x);
	x.move(2,3);
	System.out.println("After x.move(2,3) : " + x);
	x.translate(-1,1);
	System.out.println("After x.translate(-1,1): " + x);
	x.setLocation(new Point());
	System.out.println("After x.setLocation(new Point()): " + x);

	// Create a collection of random points
	ArrayList<Point> pts = randomPoints(3,0,5);
	System.out.println("random points: " + pts);

	// Translates each point by 1 (dx) and -1 (dy)
	q2(pts);
	System.out.println("translated points: " + pts);

	// Test q3
	q3(pts);
	System.out.println("points: " + pts);
	System.out.println("length of list: " + pts.size());

	// Test dist
	Point a = new Point(2,5);
	Point b = new Point(4,9);
	System.out.println("distance between " + a + " and " + b + ": " + dist(a,b));

    }

    // Pre: n > 0, from < to
    // Post : Returns a list containing n random points
    //        both x and y are within [from, to).
    private static ArrayList<Point> randomPoints(int n, int from, int to){
	ArrayList<Point> ans = new ArrayList<Point>();
	for (int i = 0; i < n ; i++){
	    Integer x = from + (int) (Math.random() * (to - from));
	    Integer y = from + (int) (Math.random() * (to - from));
	    ans.add(new Point(x,y));
	}
	return ans;
    }

    private void q2(ArrayList<Point> pts){
	for (Point p : pts)
	    p.translate(1,-1);
    }

    private void q3(ArrayList<Point> pts){
	pts.clear();
	Point p = new Point(1,1);
	for (int t = 0; t < 5; t++)
	    pts.add(p);
	pts.get(0).translate(1,-1);
    }

    private static double dist(Point a, Point b){
	return Math.sqrt(Math.pow((b.getX() - a.getX()),2) + Math.pow((b.getY() - a.getY()),2));
    }

}
