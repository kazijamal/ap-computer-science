public class TitiusBodeLaw{

    public int b_i(int i){
	if (i == 1)
	    return 1;
	if (i == 2)
	    return 3;
	return 2 * b_i(i-1);
    }

    public double getTitiusBodeDistance(int k){
	return (4 + b_i(k))/10.0;
    }

    public void run(){
	for (int k = 1; k <= 8; k++){
	    switch (k){
	    case 1: System.out.println("Mercury \t" + getTitiusBodeDistance(k) + "AU");
		break;
	    case 2: System.out.println("Venus \t\t" + getTitiusBodeDistance(k) + "AU");
		break;
	    case 3: System.out.println("Earth \t\t" + getTitiusBodeDistance(k) + "AU");
		break;
	    case 4: System.out.println("Mars \t\t" + getTitiusBodeDistance(k) + "AU");
		break;
	    case 5: System.out.println("? \t\t" + getTitiusBodeDistance(k) + "AU");
		break;
	    case 6: System.out.println("Jupiter \t" + getTitiusBodeDistance(k) + "AU");
		break;
	    case 7: System.out.println("Saturn \t\t" + getTitiusBodeDistance(k) + "AU");
		break;
	    case 8: System.out.println("Uranus \t\t" + getTitiusBodeDistance(k) + "AU");
		break;
	    }
	}
    }

    public static void main(String [] args){
	new TitusBodeLaw().run();
    }

}
