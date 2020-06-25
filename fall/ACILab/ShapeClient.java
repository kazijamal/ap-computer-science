import java.util.List;
import java.util.ArrayList;

public class ShapeClient{

    public static void main(String [] args){
	new ShapeClient().run();
    }

    public void run(){
	Rectangle r = new Rectangle(2,3);
	System.out.println("rectangle r: w = 2; h = 3");
	System.out.println("area r: " + r.getArea());
	System.out.println("perimeter r: " + r.getPerimeter());
	System.out.println();
	
	r.resize(2);
	System.out.println("resized rectangle r by factor 2");
	System.out.println("area r: " + r.getArea());
	System.out.println("perimeter r: " + r.getPerimeter());
	System.out.println();
	
	RtTriangle rt = new RtTriangle(3,4);
	System.out.println("right triangle rt: w = 3; h = 4");
	System.out.println("area rt: " + rt.getArea());
	System.out.println("perimeter rt: " + rt.getPerimeter());
	System.out.println();

	List<Shape> shapes = new ArrayList<Shape>();
	shapes.add(new Rectangle(2,4));
	shapes.add(new RtTriangle(3,4));
	for (Shape s : shapes){
	    if (s instanceof Rectangle){
		Rectangle resizable = (Rectangle) s;
		resizable.resize(0.5);
		System.out.println("area: " + resizable.getArea());
		System.out.println("perimeter: " + resizable.getPerimeter());
	    }
	}
    }

}
