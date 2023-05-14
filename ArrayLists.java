import java.util.*;
public class ArrayLists {
    /*public static void swap(ArrayList<Integer> list, int idx, int idx2) {
        int temp = list.get(idx);
        list.set(idx, list.get(idx2));
        list.set(idx2, temp);
    }
    public static void main(String args[]) {
       /* ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(10);
        list.add(3);
        // 1. reverse 
        for(int i=list.size()-1; i>=0; i--) {
            //  System.out.print(list.get(i)+ " ");
        }
        // 2. Find max in arraylist
        int max = Integer.MIN_VALUE;
        for(int i=list.size()-1; i>=0; i--) {
            if(list.get(i) > max) {
                max = list.get(i);
            }
        }
        //System.out.print(max);
        // 3. swap two values
        //System.out.println(list);
        swap(list, 1, 3);
       // System.out.println(list);
       // 4. print multidimensional array
       ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
       ArrayList<Integer> List1 = new ArrayList<>();
       ArrayList<Integer> List2 = new ArrayList<>();
       ArrayList<Integer> List3 = new ArrayList<>();
       for(int i=1; i<=5; i++) {
        List1.add(i*1);
        List2.add(i*2);
        List3.add(i*3);
       }
       mainList.add(List1);
       mainList.add(List2);
       mainList.add(List3);
       System.out.println(mainList);
       for(int i=0; i<mainList.size(); i++) {
        ArrayList<Integer> currList = mainList.get(i);
        for(int j=0; j<currList.size(); j++) {
            System.out.print(currList.get(j) + " ");
        }
        System.out.println();
       }

    }*/
    // 5. list with most water
    //Approach 1. Brute force
    /*public static int mwlist(ArrayList<Integer> list) {
        int mostwater = 0;
        for(int i=0; i<list.size()-1; i++) {
            for(int j=i+1; j<list.size(); j++) {
                int height = Math.min(list.get(i), list.get(j));
                int width = j-i;
                mostwater = Math.max(mostwater, (height*width));
            }
        }
        return mostwater;
    }*/ // Approach 2. two pointer
   /*public static int mwlist(ArrayList<Integer> list) {
        int mostwater = 0; int lp = 0; int rp = list.size()-1;
        while(lp<rp) {
            int height = Math.min(list.get(lp), list.get(rp));
            int width = rp-lp;
            mostwater = Math.max(mostwater, (height*width));
            if(lp<rp) {
                lp++;
            } else {
                rp--;
            }
        }
        
        return mostwater;
    }*/
    // 6. pair sum.
    // 2 [pointer approach]
    public static boolean pairsum(ArrayList<Integer> list, int target) {
        int lp = 0; int rp = list.size()-1; 
        while(lp<rp) {
            if(list.get(lp)+list.get(rp) == target) {
                return true;
            } 
            if(list.get(lp)+list.get(rp) < target) {
                lp++;
            }
            if(list.get(lp)+list.get(rp) > target) {
                rp--;
            }
        }
        return false;
    }
    public static boolean pairsum2(ArrayList<Integer> list, int target) {
        int breakpoint =-1; int n = list.size();
        for(int i=0; i<list.size(); i++) {
            if(list.get(i)>list.get(i+1)) {
                breakpoint = i;
                break;
            }
        }
        int lp = breakpoint+1; int rp = breakpoint;
        while(lp!=rp) {
            if(list.get(lp)+list.get(rp) == target) {
              return true;
            }
            if(list.get(lp)+list.get(rp) > target) {
                rp = (n+rp-1) % n;
            } else {
                lp = (lp+1) % n;
            }
        }
        return false;
    }
    // assignment 
    // 1. is monotone 
    public static boolean isMonotonic(ArrayList<Integer> list) {
        if(list.get(0) > list.get(1)) {
            for(int i=1; i<list.size()-1; i++) {
                if(list.get(i) < list.get(i+1)) {
                    return false;
                }
            }
        } else {
            for(int i=1; i<list.size()-1; i++) {
                if(list.get(i) > list.get(i+1)) {
                    return false;
                }
            }
        }
        return true;
    }
    //2. Lonely numbers
    public static ArrayList<Integer> lonelynums(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<Integer> sol = new ArrayList<>();
        if(nums.size()==1) {
            sol.add(nums.get(0));
        } else {
            if(nums.get(0) < (nums.get(1)-1)) {
                sol.add(nums.get(0));
            }
            for(int i=1; i<=nums.size()-2; i++) {
                int n = nums.get(i);
                if((nums.get(i-1)+1) < n && n < (nums.get(i+1)-1)) {
                    sol.add(n);
                }
            }
            if(nums.get(nums.size()-2) < (nums.get(nums.size()-1)-1)) {
                sol.add(nums.get(nums.size()-1));
            }
        }
        return sol;
    }
    // 3. Most frequent number following key
    public static int mfn(ArrayList<Integer> list, int key) {
        int arr[] = new int[1000]; int max = Integer.MIN_VALUE; int target = 0;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) == key) {
                arr[list.get(i+1)]++;
            }
        }
        for(int i=0; i<arr.length; i++) {
            if(arr[i]>max) {
                max=arr[i];
                target = i;
            }
        }
        return target;
    }
    public static void main(String args[]) {
        //ArrayList<Integer> list = new ArrayList<>();
        //list.add(1); list.add(8); list.add(6); list.add(2);
        //list.add(5); list.add(4); list.add(8); list.add(3);
        //list.add(7);
        //System.out.print(mwlist(list));
       //  list.add(1); list.add(2); list.add(3); list.add(4);
        //list.add(5);
       //System.out.print(pairsum(list, 5));
       //list.add(11); list.add(15); list.add(6); list.add(8);
        //list.add(9); list.add(10);
       //System.out.print(pairsum2(list, 100));
       /*ArrayList<Integer> list = new ArrayList<>();
       list.add(2); list.add(2); list.add(2); list.add(2); list.add(3);
       //System.out.print(isMonotonic(list));
       System.out.print(mfn(list, 2));*/
       ArrayList<Integer> list = new ArrayList<>();
       list.add(10); list.add(6); list.add(5); list.add(8);list.add(2, 9);
       //list = lonelynums(list);
       //for(int i=0; i<list.size(); i++){
        System.out.print(list);
       
    }
}