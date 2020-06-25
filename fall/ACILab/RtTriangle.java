public class RtTriangle extends Shape{

    // data members
    private double width;
    private double height;

    // constructor
    public RtTriangle(double width, double height){
	super(3);
	this.width = width;
	this.height = height;
    }

    // getters
    @Override
    public double getArea(){
	return 0.5 * width * height;
    }

    @Override
    public double getPerimeter(){
	double c = Math.sqrt(Math.pow(width,2) + Math.pow(height,2));
	return width + height + c;
    }

}
