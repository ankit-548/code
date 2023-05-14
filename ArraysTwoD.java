import java.util.*;

public class ArraysTwoD {
    
/*public static void main(String args[]) {
    int matrix[][] = new int[3][3];
    int n = 3, m = 3;

    Scanner sc = new Scanner(System.in);
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            matrix[i][j] = sc.nextInt();
        }
    }
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
    }
}*/

//2. spiral matrix
public static void spiral(int matrix[][]) {
    int startrow=0, startcol=0;
    int endrow=matrix.length-1, endcol=matrix[0].length-1;

    while(startrow <= endrow && startcol <= endcol) {
        for(int j=startcol; j<=endcol; j++) {
            System.out.print(matrix[startrow][j] + " ");
        }
        for(int i=startrow+1; i<=endrow; i++) {
            System.out.print(matrix[i][endcol] + " ");
            
            }
        for(int j=endcol-1; j>=startcol; j--) {
           if(startrow==endrow) {
              break;
        }
            System.out.print(matrix[endrow][j] + " ");
        }
        for(int i=endrow-1; i>=startrow+1; i--) {
             if(startcol==endcol) {
                break;
            }
            System.out.print(matrix[i][startcol] + " ");
           
        }
        startrow++;
        endrow--;
        startcol++;
        endcol--;
    }
}
//3. diagonal sum
/*public static void diagonalsum(int matrix[][]) {
    int sum = 0;
    for(int i=0; i<matrix.length; i++) {
        sum += matrix[i][i];
        if(i != matrix.length-i-1) {
        sum += matrix[i][matrix.length-i-1];
            }
    }
            System.out.print(sum);
}*/
//search in 2d array staircase
/*public static boolean search2d(int matrix[][], int key) {
    int row = 0, col = matrix[0].length-1;
    while(row < matrix.length && col >= 0) {
        if(matrix[row][col] == key) {
            System.out.print("The key index is: " + "(" + row + "," + col + ")");
            return true;
        } else if(matrix[row][col] > key) {
            col--;
        } else {
            row++;
        }
    }
    return false;
}
public static void main(String args[]) {
    int matrix[][] = {{10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
                    // diagonalsum(matrix);
                    int key = 60;
                    search2d(matrix, key);
}*/
// 1.search no of repitition of key
/*public static int search(int matrix[][], int key) {
   int sum = 0;
   for(int i=0; i<matrix.length; i++) {
    for(int j=0; j<matrix[0].length; j++) {
        if(matrix[i][j] == key) {
            sum++;
        }
    }
   }
   return sum;
}*/
//2. second row sum
/*public static int secondrowsum(int matrix[][], int row) {
    int sum = 0;
    for(int i=0; i<matrix[0].length; i++) {
        sum+=matrix[row][i];
    }
    return sum;
}*/
//3. transpose of a matrix
/*public static void transpose(int matrix[][]) {
    int temp = 0;
    for(int i=0; i<matrix.length; i++) {
        for(int j=0; j<matrix[0].length; j++) {
            if(j>i) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }
    }
}*/
/*public static void main(String args[]) {
    int matrix[][] = {{1 ,4, 9},{11, 4, 3},{2, 2, 3}};
    int transpose[][] = new int [matrix.length][matrix[0].length];

    for(int i=0; i<matrix.length; i++) {
        for(int j=0; j<matrix[0].length; j++) {
            transpose[j][i]  = matrix[i][j];
        }
    }
    printmatrix(transpose);
}
public static void printmatrix(int matrix[][]) {
for(int i=0; i<matrix.length; i++) {
        for(int j=0; j<matrix[0].length; j++) {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
    }
}*/
public static void main(String args[]) {
    //int matrix[][] = {{1 ,4, 9},{11, 4, 3},{2, 2, 3}};
    int matrix[][] = {{10, 20, 30},
                      {15, 25, 35},
                      {27, 29, 37},
                      {32, 33, 39},
                      {45, 67, 7}};
    int row = 1;
    spiral(matrix);
    
}
}
