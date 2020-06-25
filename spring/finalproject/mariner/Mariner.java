import java.util.Scanner;

public class Mariner {

    public static int[][] hadamard(int n) {
        int[][] ans = new int[n][n];
        ans[0][0] = 1;
        for (int k = 1; k < n; k += k) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    ans[i+k][j] = ans[i][j];
                    ans[i][j+k] = ans [i][j];
                    ans[i+k][j+k] = Math.abs(ans[i][j] - 1);
                }
            }
        }
        return ans;
    }

    public static String closestCode(String code) {
        int[][] hadamard = hadamard(32);
        int minErrors = 32;
        String rowMinErrors = "";
        for (int[] row : hadamard) {
            String rowStr = "";
            int numErrors = 0;
            for (int j = 0; j < row.length; j++) {
                rowStr += Integer.valueOf(row[j]);
                if (rowStr.charAt(j) != code.charAt(j))
                    numErrors++;
            }
            if (numErrors == 0) return code;
            if (numErrors < minErrors) {
                minErrors = numErrors;
                rowMinErrors = rowStr;
            }
        }
        return rowMinErrors;
    }

    public static void main(String[] args) {
        Scanner sys = new Scanner(System.in);
        System.out.print("enter a 32 bit codeword: ");
        String code = sys.nextLine();
        while (code.length() != 32) {
            System.out.println("entered codeword is not a 32 bit codeword");
            System.out.print("enter a 32 bit codeword: ");
            code = sys.nextLine();
        }
        String closest = closestCode(code);
        if (closest.equals(code)) {
            System.out.println("codeword does not have errors");
        }
        else {
            System.out.println("codeword has errors");
            System.out.println("codeword most closely resembles " + closest);
        }
        sys.close();
    }

}