import java.util.Comparator;
import java.util.Arrays;
import java.util.*;

//import java.util.List; in teeno ka koi kaam nhi
import java.util.Collections;
//import java.util.ArrayList;
public class GreedyAlgorithm {
   //Q1. Activity selection
    /*public static void main(String args[]) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};
        
        
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
       int maxact = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        maxact = 1;
        //ans.add(0);
        ans.add(activities[0][0]);
        //int lastend = end[0];
        int lastend = activities[0][2];
        for(int i=1; i<end.length; i++) {
            //if(start[i]>=lastend) {
                if(activities[i][1]>=lastend) {
                maxact++;
                //lastend = i;
                lastend = activities[i][2];
                // ans.add(i);
                ans.add(activities[i][0]);
            }
        }
        System.out.println("max activities : "+maxact);
        for(int i=0; i<ans.size(); i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
    }*/
    //Q2. Fractional Knapsack
    /*public static void main(String args[]) {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        double ratio[][] = new double[value.length][2];
        for(int i=0; i<value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (value[i]/(double)weight[i]);
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity=50;
        int ans=0;
        for(int i=ratio.length-1; i>=0; i--) {
             int idx = (int)(ratio[i][0]);
            if(capacity >= weight[idx]) {
                capacity -= weight[idx];
                ans += value[idx];
            } else {
                ans += ratio[i][1]*capacity;
                break;
            }

        }
        System.out.println("maximum total value in knapsack: " + ans);
    }*/
    // Q3. Min Absolute diff. pairs
    /*public static void main(String args[]) {
        int A[] = {1 ,2, 3};
        int B[] = {2, 1, 3};
        Arrays.sort(A);
        Arrays.sort(B);
        int ans=0;
        for(int i=0; i<A.length; i++) {
           ans += A[i]-B[i];
        }
        System.out.print(ans);
    }*/
    // Q4.  Indian coins
    /*public static void main(String args[]) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int value = 1059;
        Arrays.sort(coins, Comparator.reverseOrder());
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<coins.length; i++) {
            if(coins[i]<=value) {
                while(coins[i]<=value) {
                    count++;
                    value -= coins[i];
                    arr.add(coins[i]);
                }
            }
        }
        System.out.println(arr);
        System.out.print(count);
    }*/
    //Q5. Longest Length
    /*public static void main(String args[]) {
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int chainLen = 1;
        int lastend = pairs[0][1];
        for(int i=0; i<pairs.length; i++) {
            if(pairs[i][0] >= lastend) {
                chainLen++;
                lastend = pairs[i][1];
            }
        }
        System.out.println("Longest length: " + chainLen);
    }*/
    //Q6. Job Sequencing problem;
    /*public static class Job {
        int id;
        int deadline;
        int profit;
        public Job(int i, int d, int p) {
            this.id = i;
            this.deadline = d;
            this.profit = p;
        }
    }
    public static void main(String args[]) {
        int prob[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        ArrayList<Job> jobs = new ArrayList<>();
         for(int i=0; i<prob.length; i++) {
            jobs.add(new Job(i, prob[i][0], prob[i][1]));
         }
         Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit);
         ArrayList<Integer> res = new ArrayList<>();
         int time = 0;
         int p = 0;
         for(int i=0; i<jobs.size(); i++) {
            Job curr = jobs.get(i);
            if(curr.deadline>time)  {
                time++;
                p += curr.profit;
                res.add(curr.id);
            }
         }
         System.out.println(res);
         System.out.println(p);
    }*/
    //Q7. Chocola problem
    /*public static void main(String args[]) {
        int n = 4; int m = 6;
        Integer vercut[] = {2, 1, 3, 1, 4};
        Integer horcut[] = {4, 1, 2};
        Arrays.sort(vercut, Collections.reverseOrder());
        Arrays.sort(horcut, Collections.reverseOrder());
        int h = 0; int v = 0;
        int hp = 1; int vp = 1; int finalcost = 0;
        while(h<horcut.length && v<vercut.length) {
            if(vercut[v] <= horcut[h]) {
                 finalcost += vp*(horcut[h]);
                 h++;
                 hp++;
            } else {
                finalcost += hp*(vercut[v]);
                v++;
                vp++;
            }
        }
        while(h<horcut.length) {
            finalcost += vp*(horcut[h]);
                 h++;
                 hp++;
        }
        while(v<vercut.length) {
            finalcost += hp*(vercut[v]);
                v++;
                vp++;
        }
        System.out.println("total cost: " + finalcost);
    }*/
    // Q1. Maximum balanced String partitions
    public static int balancedSubStr(String str) {
        int count = 0; int left = 0; int right = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'L') {
                left++;
            }
            if(str.charAt(i) == 'R') {
                right++;
            }
            if(left == right) {
                count++;
            }
        }
            return count;
    }
    // Q2. kth Largest odd number
    // t.c.- O(n)
    public static int kthlargest(int l, int r, int k) {// wrong sol
        int n=1;
        while(r!=l) {
            if(r%2==1 && n==k) {
                return r;
            }
            r--;
            n++;
        }
        return 0;
    }
    // M-2 t.c. - O(1)
    public static int kthLargest(int arr[], int k) {
        double l = arr[0];
        double r = arr[1];
        if((r%2)!=0) {
            int count = (int)Math.ceil((r-l+1)/2);
            if(k>count) {
                return 0;
            }
            return (int)(r-2*k+2);
        } else {
            int count = (int)(r-l+1)/2;
            if(k>count) {
                return 0;
            }
            return (int)(r-2*k+1);
        }
    }
    // Q3. lexicographically smallest string of length n and sum k
    public static void charString(int n, int k) {
        char arr[] = new char[n];
        Arrays.fill(arr, 'a');
        for(int i=n-1; i>=0; i--) {
            k-=i;
            if(k>=0) {
                if(k>=26) {
                    arr[i] = 'z';
                    k-=26;
                } else {
                    arr[i] = (char)(k+97-1);
                    k-=arr[i]-'a'+1;
                }
            } else {
                break;
            }
            k+=i;
        }
        String st = new String(arr);
        for(int i=0; i<st.length(); i++) {
          System.out.print(st.charAt(i));
        }
        
    }
    public static void main(String args[]) {
        String str = "LRRRRLLRLLRL";
        //System.out.print(balancedSubStr(str));
        //System.out.println(kthlargest(-3, 3, 4));
        int arr[] = {-3, 3};
       // System.out.println(kthLargest(arr, 4));
        int r=3; int l=-3;// make them double
        //System.out.print((int)Math.ceil((r-l+1)/2));
        charString(5, 42);
        
    }

}