public class SchoolBusClient{

    public static void main(String[] args){
	new SchoolBusClient().run();
    }

    public void run(){
	SchoolBus a = new SchoolBus(3);
	a.add(new Student("Bob", "East", 8));
	System.out.println(a + "\n");
	a.add(new Student("Jeffrey", "West", 7));
	System.out.println(a + "\n");
	a.add(new Student("Amy", "East", 5));
	System.out.println(a + "\n");
	a.add(new Student("John", "Court", 18));
	System.out.println(a + "\n");
	a.remove(1);
	System.out.println(a + "\n");
	a.add(1, new Student("John", "Court", 18));
	System.out.println(a);
    }
    
}
