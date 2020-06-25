public class Rectangle extends Shape implements Resizable{

    // data members;
    private double width;
    private double height;

    // constructor
    public Rectangle(double width, double height){
	super(4);
	this.width = width;
	this.height = height;
    }

    // getters
    @Override
    public double getArea(){
	return width * height;
    }

    @Override
    public double getPerimeter(){
	return 2 * (width + height);
    }

    @Override
    public void resize(double x){
	width = width * x;
	height = height * x;
    }

}
