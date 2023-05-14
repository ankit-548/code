import java.util.Arrays;
import java.util.HashSet;
public class DP {
    //Q.1 climbStairs
    // method 1. recursion O(2^n)
    public static int climbStairs(int n) {
       if(n==0) {
        return 1;
       }
       if(n<0) {
        return 0;
       }
       return climbStairs(n-1)+climbStairs(n-2);
    }
    //method 2.  memoization O(n)
    public static int climbStMemo(int n, int arr[]) {
        if(n==0) {
            return 1;
           }
           if(n<0) {
            return 0;
           }
           if(arr[n]!=-1) {
             return arr[n];
           }
           return climbStairs(n-1)+climbStairs(n-2);
    }
    // method 3. tabulation O(n)
    public static int climbStTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++) {
            if(i==1) {
                dp[i] = dp[i-1] + 0;
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    // Q.2 0-1 Knapsack
    //m-1 recursion
    public static int knapSack(int var[], int wt[], int w, int i) {
      if(w==0 || i==0) {
        return 0;
      }
      if(wt[i-1]<=w)  {
        int max1 = var[i-1]+knapSack(var, wt, w-wt[i-1], i-1);
        int max2 = knapSack(var, wt, w, i-1);
        return Math.max(max1, max2);
      } else {
        return knapSack(var, wt, w, i-1);
      }
    }
    // m-2 memoization
    public static int knapSackmemo(int var[], int wt[], int w, int n, int[][] dp) {
        if(w==0 || n==0) {
          return 0;
        }
        if(dp[n][w]!=-1) {
          return dp[n][w];
        }
        if(wt[n-1]<=w) {
          int max1 = var[n-1]+knapSackmemo(var, wt, w-wt[n-1], n-1, dp);
          int max2 = knapSackmemo(var, wt, w, n-1, dp);
          dp[n][w] = Math.max(max1, max2);
          return Math.max(max1, max2);
        } else {
          dp[n][w] = knapSackmemo(var, wt, w, n-1, dp);
          return dp[n][w];
        }
    }
    // m-3 tabulation 
    public static int knapsackTab(int var[], int wt[], int W) {
      int n=var.length;
      int[][] dp = new int[n+1][W+1];
      for(int i=0; i<n+1; i++) {
        dp[i][0] = 0;
      }
      for(int i=0; i<W+1; i++) {
        dp[0][i] = 0;
      }
      for(int i=1; i<n+1; i++) {
        for(int j=1; j<W+1; j++) {
          int w = wt[i-1];
          int v = var[i-1];
          if(w<=j) { // validity
            int incprofit = v+dp[i-1][j-w];
            int excprofit = dp[i-1][j];
            dp[i][j] = Math.max(incprofit, excprofit);
          } else { // invalid
            int excprofit = dp[i-1][j];
            dp[i][j] = excprofit;
          }
        }
      }
      return dp[n][W];
    }
    // Q. 3 Target sum subset O(nxsum) 
    public static boolean targetSubset(int[] var, int W) {
      int n = var.length;
      boolean[][] dp = new boolean[n+1][W+1];
      for(int i=0; i<n+1; i++) {
        dp[i][0] = true;
      }
      for(int i=1; i<n+1; i++) {
        for(int j=1; j<W+1; j++) {
          int v = var[i-1];
          // include
          if(v<=j && dp[i-1][j-v]==true) {
            dp[i][j] = true;
          }
          //exclude
          else if(dp[i-1][j]==true) {
            dp[i][j] = true;
          }
        }
      }
      // print(dp);
      return dp[n][W];
    }
    // public static void print(boolean[][] dp) {
    public static void print(int[][] dp) {
      for(int i=0; i<dp.length; i++) {
        for(int j=0; j<dp[0].length; j++) {
          System.out.print(dp[i][j]+ " ");
        }
        System.out.println();
      }
      System.out.println();
    }
    // Q4. Unbounded knapsack    
    public static void Unbounded(int val[], int wt[], int w) {
      int m = val.length;
      int dp[][] = new int[m+1][w+1];
      for(int i=1; i<m+1; i++) {
        for(int j=1; j<w+1; j++) {
          if(wt[i-1]<=j) {// valid
            dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
          } else {
            dp[i][j] = dp[i-1][j];
          }
        }
      }
      print(dp);
    }
    // Q.4 Coin change variation of unbounded Knapsack O(n*sum)
    public static void coinchange(int coins[], int sum) {
      int n = coins.length;
      int dp[][] = new int[n+1][sum+1];
      for(int i=0; i<n+1; i++) {
        dp[i][0] = 1;
      }
      for(int i=1; i<n+1; i++) {
        for(int j=1; j<sum+1; j++) {
          if(coins[i-1]<=j) { // valid
            dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
          } else {
            dp[i][j] = dp[i-1][j];
          }
        }
      }
      print(dp);
    }
    public static void main(String args[])     {
        //  int n = 8;
        //  System.out.print(climbStairs(n));
        // int arr[] = new int[n+1];
        // Arrays.fill(arr, -1);
        // System.out.print(climbStMemo(n, arr));
        // System.out.print(climbStTab(n));
        // int var[] = {15, 14, 10, 45, 30};
        // int wt[] = {2, 5, 1, 3, 4};
        // System.out.print(knapSack(var, wt, 7, 5));
        // int var[] = {15, 14, 10, 45, 30};
        // int wt[] = {2, 5, 1, 3, 4};
        // int n=5; int w = 7;
        // int[][] dp = new int[n+1][w+1];
        // for(int[]row : dp) {
        //   Arrays.fill(row, -1);
        // }
        // System.out.print(knapSackmemo(var, wt, w, n, dp));
        // System.out.print(knapsackTab(var, wt, w));
        // Unbounded(var, wt, w);
        // int numbers[] = {4, 2, 7, 1, 3};
        // int target = 10;
        // System.out.print(targetSubset(numbers, target));
        // int coins[] = {2, 5, 3, 6};
        // int sum = 10;
        // coinchange(coins, sum);
        char ch = '5';
        // System.out.print(0%5);        
        int arr[] = circularGameLosers(4, 4);
        for(int i=0; i<arr.length; i++) {
          System.out.print(arr[i]+" ");
        }
        
    }
    public static int[] circularGameLosers(int n, int k) {
        HashSet<Integer> hs = new HashSet<>();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        int i=0, idx = 0; 
        while(!hs.contains(arr[(idx+i*k)%n])) {
            hs.add(arr[(idx+i*k)%n]);
            i++;
            idx = (idx+i*k)%n;
        }
        int m = hs.size();
        int[] arr2 = new int[n-m];
        int j=0;
        for(int p=0; p<n; p++) {
            if(!hs.contains(arr[p])) {
                arr2[j++] = arr[p];
            }
        }
       return arr2; 
    }
}
