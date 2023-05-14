import java.util.Arrays;
public class BackTracking {
    //1. example;
    public static void changeArr(int arr[], int i, int value) {
        if(i == arr.length) {
            printArr(arr);
            return;
        }
        arr[i] = value;
        changeArr(arr, i+1, value+1);
        arr[i] -= 2;
    }
    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
        System.out.print(arr[i]+ " ");
        }
         System.out.println();
    }
    //2. subset of string
    public static void subset(String str, String ans, int i) {
        if(i == str.length()) {
            System.out.println(ans);
            return;
        }
        subset(str, ans+str.charAt(i), i+1);
        subset(str, ans, i+1);
        return;
    }
    //3. permutation of a string 
    public static void permutation(String str, String ans) {
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for(int i=0; i<str.length(); i++) {
            String newS = str.substring(0, i)+str.substring(i+1);
            permutation(newS, ans+str.charAt(i));
        }
    }
    
    /*public static void main(String args[]) {
        //int arr[] = new int[5];
        //changeArr(arr, 0, 1);
        //printArr(arr);
        String str = "abc";
        //subset(str, "", 0);
        permutation(str, "");
    }*/
    // 4. place queen 
    // public static boolean nqueen(char board[][], int row) {
    //     if(row == board.length) {
    //         printBoard(board);
    //         //count++;
    //         return true;
    //     }
    //     for(int j=0; j<board.length; j++) {
    //         if(isSafe(board, row, j)) {
    //             board[row][j] = 'Q';
    //            if(nqueen(board, row+1)) {
    //             return true;
    //            } else {
    //             board[row][j] = '.';
    //            }
    //         }
    //     }
    //        return false;
    // }
    // public static boolean isSafe(char board[][], int row, int col) {
    //     for(int i=row-1; i>=0; i--) {
    //         if(board[i][col] == 'Q') { 
    //             return false;
    //         }
    //     }
    //     for(int i=row-1, j=col-1; j>=0 && i>=0; j--,i--) {
    //         if(board[i][j] == 'Q') {
    //             return false;
    //         }
    //     }

    //     for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++) {
    //         if(board[i][j] == 'Q') {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public static void  printBoard(char board[][]) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static int count = 0;
    // 5. grid ways
    public static int gridWays(int i, int j, int n, int m) {
        if(i==n-1 && j==m-1) {
            return 1;
        }
        if(i==n || j==m) {
            return 0;
        }
        return gridWays(i+1, j, n, m)+gridWays(i, j+1, n, m);
    }
    /*public static void main(String args[]) {
        /*int n = 10;
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        if(nqueen(board, 0)) {
        System.out.print("solution is possible");
        } else {
            System.out.print("solution is  not possible");
        }
        int n = 4, m = 3;
        System.out.print(gridWays(0, 0, n, m));
    }*/
    //6..  sudoku solver
    public static boolean sudokusolver(int sudoku[][], int row, int col) {
        if(row == 9) {
           return true;
        }
        int newrow = row, newcol = col+1;
        if(col+1 == 9) {
            newrow = row+1;
            newcol = 0;
        }
        if(sudoku[row][col] != 0) {
            return sudokusolver(sudoku, newrow, newcol);
        }
            for(int digit=1; digit<=9; digit++) {
            if(check(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if(sudokusolver(sudoku, newrow, newcol)) {
                    return true;
                } else {
                    sudoku[row][col] = 0;
                }
            }
            }
        return false;
    }
    public static boolean check(int sudoku[][], int row, int col, int digit) {
        for(int i=0; i<=8; i++) {
            if(sudoku[i][col] == digit) {
                return false;
            }
            if(sudoku[row][i] == digit) {
                return false;
            } 
        }  
        int sr = (row/3)*3; int sc = (col/3)*3;
        for(int i=sr; i<sr+3; i++) {
            for(int j=sc; j<sc+3; j++) {
                if(sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void printsudoku(int sudoku[][]) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
               System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    // public static void main(String args[]) {
    //     int sudoku[][] = {{0, 0, 8, 0, 0, 0, 0, 0, 0},
    //     {4, 9, 0, 1, 5, 7, 0, 0, 2},
    //     {0, 0, 3, 0, 0, 4, 1, 9, 0},
    //     {1, 8, 5, 0, 6, 0, 0, 2, 0},
    //     {0, 0, 0, 0, 2, 0, 0, 6, 0},
    //     {9, 6, 0, 4, 0, 5, 3, 0, 0},
    //     {0, 3, 0, 0, 7, 2, 0, 0, 4},
    //     {0, 4, 9, 0, 3, 0, 0, 5, 7},
    //     {8, 2, 7, 0, 0, 9, 0, 1, 3}};
    //     if(sudokusolver(sudoku, 0, 0)) {
    //         System.out.println("solution exists");
    //     printsudoku(sudoku);

    //     } else {
    //         System.out.println("solution doesn't exist");
    //     }

    // }
    // Assignment 
    // 1.mouse in maze
    /*public static void mazesolver(int maze[][]) {
        int n = maze.length;
        int sol[][] = new int[n][n];
        if(mazesolveUtil(maze, sol, 0, 0) == false) {
            System.out.println("solution is not possible");
            return;
        }
        printpath(sol);
        return;
    }
    public static boolean mazesolveUtil(int maze[][], int sol[][], int x, int y) {
        if(x==maze.length-1 && y==maze.length-1 && maze[x][y]==1) {
            sol[x][y] = 1;
            return true;
        }
        if(isSafe(maze, x, y)) {
            if(sol[x][y] == 1)  {
                return false;
            }
            sol[x][y] = 1;
            if(mazesolveUtil(maze, sol, x+1, y)) {
                return true;
            }
            if(mazesolveUtil(maze, sol, x, y+1)) {
                return true;
            }
            sol[x][y] = 0;
            return false;
        }
        return false;
    }
    public static boolean isSafe(int maze[][], int x, int y) {
        return (x>=0 && y>=0 && x<=maze.length-1 && y<=maze.length-1 && maze[x][y]==1);
    }
    public static void printpath(int path[][]) {
        for(int i=0; i<path.length; i++) {
            for(int j=0; j<path.length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int maze[][] = {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {0, 1, 0, 0},
                        {1, 1, 1, 1}};
        mazesolver(maze);
    }*/
    // 2. keypad combination
    // array of size row = 9, col = 1;
    // final static char l[][] = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
    //                             {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
    //                             {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    // public static void lettercombination(String d) {
    //     int len = d.length();
    //     if(len == 0) {
    //         System.out.print("");
    //     }
    //     combination(d, new StringBuilder(), 0, len);
    // }
    // public static void combination(String d, StringBuilder s, int pos, int len) {
    //     if(pos == len) {
    //         System.out.print(s.toString() + " ");
    //         return;
    //     }                   // this finction convert char to int i.e. '2' -  2;
    //     char letters[] = l[Character.getNumericValue(d.charAt(pos))]; // this step is not understood 
    //     for(int i=0; i<letters.length; i++) {            // use Hashmap to solve as leetcode
    //         combination(d, new StringBuilder(s).append(letters[i]), pos+1, len);
    //     }
    // }
    // public static void main(String args[]) {
    //   String d = "23";
    //    lettercombination(d);
    //    char letters[] = l[Character.getNumericValue(d.charAt(0))];// this is not understood
    //    for(int i=0; i<letters.length; i++) {
    //        System.out.println(letters[i]);
    //    }
    // }
    //3. knights tour
    /*public static boolean issafe(int x, int y, int sol[][]) {
        return (x>=0 && x<N && y>=0 && y<N && sol[x][y]==-1);
    }
    public static boolean ks(int x, int y, int movei, int sol[][], int movex[], int movey[]) {
        if(movei == N*N) {
            return true;
        }
        for(int i=0; i<N; i++) {
            int nextx = x + movex[i];
            int nexty = y + movey[i];
            if(issafe(nextx, nexty, sol)) {
                sol[nextx][nexty] = movei;
                if(ks(nextx, nexty, movei+1, sol, movex, movey)) {
                    return true;
                } else {
                    sol[nextx][nexty] = -1;
                }
            }
        }
        return false;
    }
    public static void knightsolver(int N) {
        int sol[][] = new int[N][N];
        for(int i=0; i<N; i++)  {
        for(int j=0; j<N; j++) {
            sol[i][j] = -1;
        }
       }
        int movex[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int movey[] = {1, 2, 2, 1, -1, -2, -2, -1};
        sol[0][0] = 0;
        if(!ks(0, 0, 1, sol, movex, movey)) {
            System.out.print("solution is not possible");
            return;
        }
        knightrider(sol);
    }
    public static void knightrider(int sol[][]) {
       for(int i=0; i<N; i++)  {
        for(int j=0; j<N; j++) {
            System.out.print(sol[i][j]+" ");
        }
        System.out.println();
       }
    }
    public static void main(String args[]) {
        knightsolver(N);
    }
    public static int N = 8;*/
    // practice n queens 
    public static void main(String args[]) {
        int m=4, n=4;
        char[][] board = new char[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = 'X';
            }
        }
        placeQueens(board, 0, 0);
    }
}
