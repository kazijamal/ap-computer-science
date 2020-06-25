public class BubbleSort{

    public static void bubbleSort(int [] data){
        final int N = data.length;
        for (int p = 1; p < N; p++){
            for (int i = 0; i < N-p; i++){
                if (data[i] > data[i+1]){
                    int temp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = temp;
                }
            }
            print(data);
        }
    }

    public static int[] makeData(int lo, int hi, int n){
        int [] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans [i] = (int) (Math.random() * (hi - lo) ) + lo;
        return ans;
    }

    public static void print(int [] array){
        for (int x : array)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String [] args){
        int lo = Integer.parseInt(args[0]);
        int hi = Integer.parseInt(args[1]);
        final int N = Integer.parseInt(args[2]);
        int [] data = makeData(lo,hi,N);
        System.out.println("Before bubble sort: ");
        print(data);
        bubbleSort(data);
        System.out.println("After bubble sort: ");
        print(data);
    }

}