 public class RecursionBasics {
    //1.   1-10
    public static void printDec(int n) {
        if(n==1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n-1);
    }
    //2.  10-1
    public static void printInc(int n) {
        if(n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }
    //3.  factorial
    public static int factorial(int n) {
        if(n==0) {
            return 1;
        }
        int factor = n*factorial(n-1);
       return factor;
    }
    //4, sum of n natural numbers
    public static int natSum(int n) {
        if(n==0) {
            return 0;
        }
        int sum = n+natSum(n-1);
        return sum;
    }
    //5.   fibonacci
    public static int fibonacci(int n) {
        if(n==0 || n==1) {
            return n;
        }
        int fibn = fibonacci(n-1)+fibonacci(n-2);
        return fibn;
    }
    //6.  is sorted
    public static boolean isSorted(int arr[], int i) {
        if(i==arr.length-1) {
            return true;
        }
        if(arr[i]>arr[i+1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }
    // 7. Find occurance
    public static int firstOccur(int arr[], int key, int i) {
        if(i==arr.length-1) {
            return -1;
        }
        if(arr[i]==key) {
            return i;
        }
        return firstOccur(arr, key, i+1);
    }
    // 8  .Last occurance
    public static int lastOccur(int arr[], int key, int i) {
        if(i==arr.length) {
            return -1;
        }
        int isFound=lastOccur(arr, key, i+1);
        if(isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }
    // 9.v  print power
    public static int power(int x, int n) {
        if(n == 1) {
            return x;
        }
        int p = x * power(x, n-1);
        return p;
    }
    //10.  optimised power
    public static int optimisedPower(int x, int n) {
        if(n==0) {
            return 1; 
        }
        int square = optimisedPower(x, n/2);
        int power = square*square;
        if(n%2 != 0) {
            power = power*x;
        }
        return power;
    }
    //Tiling Problem
    public static int tilingProblem(int n) {
        if(n == 0  || n == 1) {//if(n == 0  || n == 3 || n == 2 || n == 1) {
            return 1;            // return n;}
        }
        int fnm1 = tilingProblem(n-1);
        int fnm2 = tilingProblem(n-2);
        int totalways = fnm1+fnm2;
        return totalways;
    }
    // 11.  removeduplicate
    public static void removeDupli(String str, int idx, StringBuilder newstr, boolean map[]) {
        if(idx == str.length()) {
            System.out.print(newstr);
            return;
        }
        char currchar = str.charAt(idx);
        if(map[currchar-'a'] == true) {
            removeDupli(str, idx+1, newstr, map);
        } else {
            map[currchar-'a'] = true;
            removeDupli(str, idx+1, newstr.append(currchar), map);
        }
    }
    //friends pairing problem
    public static int friendPair(int n) {
        if(n == 1 || n==2) {
            return n;
        }
        int totalPair = friendPair(n-1) + (n-1) * friendPair(n-2);
        return totalPair;
    }
    // binary string problem
    public static void binarySP(int n, int lastdigit, String str) {
        if(n==0) {
            System.out.println(str);
            return;
        }
            binarySP(n-1, 0, str+"0");
            if(lastdigit != 1) {
              binarySP(n-1, 1, str+"1");  
            }
            return;
    }
    //assignment 1. find indecesof occurance
    public static void indiofocc(int arr[], int key, int idx) {
        if(idx == arr.length) {
            return;
        }
        if(arr[idx] == key) {
            System.out.print(idx+ " ");
        }
            indiofocc(arr, key, idx+1);        
        return;
    }
    // 2. ass. number to charac.
    /*public static void nToStr(String str, int key, int idx, String arr[], StringBuilder sb) {
        if(key == str.length()){
            System.out.print(sb);
            return; 
        }
        if(str.charAt(key) != idx && idx < 11) {
            nToStr(str, key, idx+1, arr, sb);
        }
        nToStr(str, key+1, idx, arr, sb.append(arr[idx]));
        return;
    }*/
    static String digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static void printDigits(int n) {
        if(n == 0) {
            return;
        }
        int lastDigit = n%10;
        printDigits(n/10);
        System.out.print(digits[lastDigit] + " ");
        return;
    }
    // 3. length of a string
    public static int stLength(String str) {
        if(str.length() == 0) {
            return 0; 
        }
        //if(idx == str.length()-1) {
          // int n = idx;
          //  return n;
        //}
        
        //return stLength(str, idx+1);
       return stLength(str.substring(1))+1;
    }
    //4. count subarrays starting and ending same letters 
    public static int countsame(String str, int i, int j, int n) {
        if(n==1) {
            return 1;
        }
        if(n==0) {
            return 0;
        }
        int ip1 = countsame(str, i+1, j, n-1);
        int jm1 = countsame(str, i, j-1, n-1);
        int ip1jm1 = countsame(str, i+1, j-1, n-2);
        int count = ip1+jm1-ip1jm1;
        if(str.charAt(i)==str.charAt(j)) {
            count++;
        }
        return count;
    }
    //5. tower of hanoi
    // public static void towerOfHanoi(int n, String src, String helper, String destination) {
    //     if(n==1) {
    //       System.out.println("transfer disk " + n + " from " + src + " to " + destination); 
    //       return; 
    //     }
    //     //1. transfer top n-1 disks from S to H with help of D
    //     towerOfHanoi(n-1, src, destination, helper);
    //     //2. transfer last one from S to D
    //     System.out.println("transfer disk " + n + " from "  + src + " to " + destination);
    //     //3. transfer n-1 from H to D with help of S
    //    towerOfHanoi(n-1, helper, src, destination);
    // } 
    //if diff. subset != k then it is beautiful
    public static int count = 0;
    public int beautifulSubsets(int[] nums, int k) {
        helper(nums, k, 0, nums.length-1);
        return count;
    }
    
    public static void helper(int nums[], int k, int st, int end) {
        if(st>end) {
            return ;
        }
        if(nums[end]-nums[st]!=k) {
          count++;  
        }
        helper(nums, k, st, end-1);
        helper(nums, k, st+1, end-1);
        helper(nums, k, st+1, end);
        
    }
    public static String getString(String[] str, int n, String s, int last) {
        if(n==0) {
            return "";
        }
        return getString(str, n/10, s, n%10)+" "+str[n%10];
    }
    public static int getCount(String str, int st, int end, int count) {
        if(st>end) {
            return 0;
        }
        if(st==end) {
            return 1;
        }
        count = getCount(str, st+1, end, count)
            +  getCount(str, st, end-1, count)
            - getCount(str, st+1, end-1, count);

        if(str.charAt(st) == str.charAt(end)) {
            count++;
        }
        return count;
    }
    public static void main(String args[]) {
        //int n = 10;
        //printDec(n);
        //printInc(n);
        //System.out.print(factorial(5));
        //System.out.print(natSum(5));
        //System.out.print(fibonacci(7));
        //int arr[] = {1, 2, 3, 4, 5 ,2};
        //System.out.print(isSorted(arr, 0));
        //int key = 3;
        //System.out.print(lastOccur(arr, key, 0));
        //System.out.print(power(2, 10));
        //System.out.print(optimisedPower(2, 5));
        //System.out.print(tilingProblem(5));
        //removeDupli("sumitraghuwanshi", 0, new StringBuilder(""), new boolean[26]);
        //System.out.print(friendPair(3));
        //binarySP(5, 0, "");
        //int ar[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        //indiofocc(ar, 2, 0);
        //String arr[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        //StringBuilder sb = new StringBuilder("");
        //nToStr("1947", 0, 0, arr, sb);
        //printDigits(1947);
        //System.out.print(stLength("ankit raghuwanshi", 0));
        //System.out.print(stLength("an"));
        //String str = "abcab";
        //System.out.print(countsame(str, 0, str.length()-1, str.length()));
        towerOfHanoi(4, "S", "H", "D");
        System.out.println(counter);
        // String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
               // System.out.print(getString(str, 2019, "", 0));
            //    System.out.print(getCount("abcab", 0, 4, 0));
    }
    static int counter=0;
    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if(n==1) {
            counter++;
            System.out.println("transfer disk "+n+" from "+src+" to "+dest);
            return;
        }
        towerOfHanoi(n-1, src, dest, helper);
        counter++;
        System.out.println("transfer disk "+n+" from "+src+" to "+dest);
        towerOfHanoi(n-1, helper, src, dest);
    }
}