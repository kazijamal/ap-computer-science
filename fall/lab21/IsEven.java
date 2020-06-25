public class IsEven implements PredicateFunction{

    @Override
    public boolean evaluate(int x){
	return x % 2 == 0;
    }

}
