// Kazi Jamal and Sunan Tajwar Period 1

// How to run : $java  CookieMonster cookies.txt 12
// cookies.txt has entries of a 12x12 board.

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.util.Stack;

public class CookieMonster {

    public static void main(String[] args) {
        String fileIn = args[0]; // file name of the data
        final int N = Integer.parseInt(args[1]); // dimensions of the NxN board
        int[][] board = new int[N][N];
        getBoard(fileIn, board);
        print(board);
        System.out.println("Number of cookies in optimal path: " + optimize(board));

    }
    
    public static int optimize(int[][] board) {
        return optimizeHelper(board, 0, 0, board[0][0]);
    }

    public static int optimizeHelper(int[][] board, int x, int y, int cookies) {
        Stack<Integer[]> s = new Stack<Integer[]>();
        while (x != board.length - 1 || y != board.length - 1) {
            if (x >= 11) {
                cookies += board[y + 1][x];
                y++;
            } else if (y >= 11) {
                cookies += board[y][x + 1];
                x++;
            } else {
                int down = board[y + 1][x];
                int right = board[y][x + 1];
                if (down == -1 && right == -1) {
                    Integer[] pos = s.pop();
                    x = pos[0];
                    y = pos[1];
                    cookies = pos[2];
                } else if (down == -1 || y + 1 >= board.length) {
                    cookies += right;
                    x++;
                } else if (right == -1 || x + 1 >= board.length) {
                    cookies += down;
                    y++;
                } else {
                    Integer[] pos = { x, y + 1, cookies + down };
                    s.push(pos);
                    cookies += right;
                    x++;
                }
            }
        }
        int max = cookies;
        while (!s.empty()) {
            Integer[] pos = s.pop();
            x = pos[0];
            y = pos[1];
            cookies = pos[2];
            cookies = optimizeHelper(board, x, y, cookies);
            if (cookies > max)
                max = cookies;
        }
        return max;
    }

    // preconditon: rd is open for reading
    //
    // postconditon: concatenates the files read from rd1 and rd2 into the file
    // associated with wr.
    // All Readers and Writers are closed.
    private static void getBoard(String fileIn, int[][] board) {
        try {
            final int N = board.length;
            int i = 0, j = 0;
            BufferedReader rd = openFileReader(fileIn);
            while (true) {
                String line = rd.readLine();
                if (line == null)
                    break;
                Scanner sys = new Scanner(line);
                while (sys.hasNext()) {
                    board[i][j] = sys.nextInt();
                    if (j < N - 1)
                        j++;
                    else {
                        j = 0;
                        i++;
                    }
                }
            }
            rd.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        }
    }

    private static BufferedReader openFileReader(String file) {
        try {
            return new BufferedReader(new FileReader(file));

        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        }
    }

    private static void print(int[][] board) {
        final int N = board.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%3d", board[i][j]);
            }
            System.out.println();
        }
    }
}