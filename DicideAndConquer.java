import java.util.*;
import java.util.Arrays;
public class DicideAndConquer {
    //1. merge sort
    public static void print(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void mergesort(int arr[], int si, int ei) {
        if(si>=ei) {
            return;
        }
        int mid = si + (ei - si)/2;
        mergesort(arr, si, mid);   // tc:workdone =     no. of calls    *   work in eack call
        mergesort(arr, mid+1, ei);  //(since each time n reduced to n/2)logn   *  n
        merge(arr, si, mid, ei);  // O(nlogn)
    }
    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[]= new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=ei) {
            if(arr[i]<arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }   
        while(i<=mid) {
            temp[k++] = arr[i++];
            } 
            while(j<=ei) {
                temp[k++] = arr[j++];
            }  
            for(k=0, i=si; k<temp.length; i++, k++) {
                arr[i] = temp[k];
            }  
    }
    //2. Quick sort
    public static void quickSort(int arr[], int si, int ei) {
        if(si>=ei) {
            return;
        }
        int pT = partition(arr, si, ei);
        quickSort(arr, si, pT-1);
        quickSort(arr, pT+1, ei);
    }
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1;
        for(int j=si; j<ei; j++) {
            if(arr[j]<=pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }
    // 3. modified binary search/Search in rotated Sorted Array    
    public static int search(int arr[], int si, int ei, int key) {
        if(si > ei) {
            return -1;
        }
        int mid = si + (ei-si)/2;
        if(arr[mid] == key) {
            return mid;
            }
        if(arr[mid] >= arr[si]) {
            if(key >= arr[si] && key <= arr[mid]) {
                return search(arr, si, mid, key);
            } else {
                return search(arr, mid+1, ei, key);
            }            
         } else {
            if(key >= arr[mid] && key <=ei) {
               return search(arr, mid, ei, key);
            } else {
                return search(arr, si, mid-1, key);
            }
         }
    }
    public static int binarysearch(int arr[], int si,int ei, int key) {
        int i=si, j= ei;

        while(i <= j) {
            int mid = i + (j - i)/2;
            if(arr[mid] == key) {
                return mid;
            } 
            if(arr[mid] >= arr[si]) {
            if(arr[mid] > key && key >= arr[si]) {
                j = mid-1;
            } else {
                i = mid+1;
            }
            } else {
                if(key > arr[mid] && key <= arr[ei]) {
                    i = mid+1;
                } else {
                    j = mid-1;
                }
            }
        }
        return -1;
    }
    // 1. assignment mergesort a string array
    public static void mergesortS(String arrS[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int mid = si + (ei-si)/2;
        mergesortS(arrS, si, mid);
        mergesortS(arrS, mid+1, ei);
        mergeS(arrS, si, mid, ei);
        return;
    }
    public static void mergeS(String arrS[], int si, int mid, int ei) {
        int i = si, j = mid+1, k = 0;
        String temp[] = new String[ei-si+1];
        while(i <= mid && j <= ei) {
            if(iflessthan(arrS[i], arrS[j])) {
                temp[k++] = arrS[i++];
            } else {
                temp[k++] = arrS[j++];
            }
        }
        while(i <= mid) {
            temp[k++] = arrS[i++];
        }  
        while(j <= ei) {
            temp[k++] = arrS[j++];
        }
        for(k=0, i=si; i<=ei; i++, k++) {
            arrS[i] = temp[k];
        }
        return;
    }
    public static boolean iflessthan(String str1, String str2) {
        if(str1.compareTo(str2) < 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void printS(String arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    // 2. ass. majority element // O(n) ultimatly yhi hogi 
     public static int majorityelement(int nums[], int si, int ei) {
        if(si>=ei) {
            return nums[si];
        }
        int mid = si + (ei-si)/2;
        int left = majorityelement(nums, si, mid);// O(logn)
        int right = majorityelement(nums, mid+1, ei);
        if(right == left) {// most of time ye case satisfied hoga
            return left;
        }
        int leftcount = countelement(nums, left);// O(n)  ye few no. of times hi chalega
        int rightcount = countelement(nums, right);// O(n)
        return leftcount>rightcount ? left : right;
     } 
     public static int countelement(int nums[], int left) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == left) {
                count++;
            }
        }
        return count;
     }
     // 3.  inversion count of an array
     //(a) using nested loop 
     public static int inversioncount1(int arr[]) {
        int count = 0;
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i]>arr[j]) {
                    count++;
                }
            }
        }
        return count;
     }
     //(b) using mergesort
     public static int mergesortinv(int arr[], int si, int ei) {
        if(si>=ei) {
            return 0;
        }
        int invcount=0;
        int mid = si+(ei-si)/2;
        invcount = mergesortinv(arr, si, mid)+
                   mergesortinv(arr, mid+1, ei)+
                   mergeinv(arr, si, mid, ei);
        return invcount;           
        
     }
     public static int mergeinv(int arr[], int si, int mid, int ei) {
        int temp[] = new int [ei-si+1];
        int invcount = 0;
        int i=si, j=mid+1, k=0;
        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
               temp[k++] = arr[j++];
               invcount += mid+1-i;
            }
        }
        while(i<=mid) {
            temp[k++] = arr[i++];
        }
        while(j<=ei) {
            temp[k++] = arr[j++];
        }
        for(k=0, i=si; i<=ei; i++, k++) {
            arr[i] = temp[k];
        }
        return invcount;
     }
     // Quick sort
     public static void quickSort1(int arr[], int si, int ei) {
        if(si>=ei) {
            return ;
        }
        int pt = partition1(arr, si, ei);
        quickSort(arr, si, pt-1);
        quickSort(arr, pt+1, ei);
     }
     public static int partition1(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i=si-1;
        for(int j=0; j<=ei; j++) {
            if(arr[j]<=pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
     }
    public static void main(String args[]) {
        // int arr[]= {-2, 0, 9, -10, 2, -9};
        //mergesort(arr, 0, arr.length-1);
        // quickSort1(arr, 0, arr.length-1);
        // print(arr);
        //int arr[] = {4, 5, 6, 7, 0, 1, 2};
        //System.out.print(binarysearch(arr, 0, arr.length-1, 0));
        // String arrS[] = {"sun", "earth", "mars", "mercury", "sumit", "ankit", "vishal", "everyone"};
        // mergesortS1(arrS, 0, arrS.length-1);
        // printS(arrS);
        // int nums[] = {3, 2, 3};
        // System.out.print(majorityelement(nums, 0, nums.length-1));
        //int arr[] = {2, 3, 4, 5, 6, 5 ,6, 7, 8, 2, 9, 3, 4, 1, 0, 43, 56, 12, 7, 87, 345, 22 ,0, 1, 9};
        //System.out.print("inversion count of array: " + inversioncount1(arr));
        // int arr[] = {2, 4, 1, 3, 5};
        //System.out.println("inversion count of array: " + mergesortinv(arr, 0, arr.length-1));
        //print(arr);
        int arr[] = {2, 4, 1, 3, 5};
        System.out.println(getInversionCount(arr, 0, 4));

    }   
    public static void mergesortS1(String arr[], int si, int ei)  {
        if(si>=ei) {
            return ;
        }
        int mid = si + (ei-si)/2;
        mergesortS1(arr, si, mid);
        mergesortS1(arr, mid+1, ei);
        merges1(arr, si, mid, ei);
    }
    public static void merges1(String arr[], int si, int mid, int ei) {
        int i = si; int j = mid+1; int k=0;
        String newArr[] = new String[ei-si+1];
        while(i<=mid && j<=ei) {
         if(arr[i].compareTo(arr[j]) <= 0)  {
             newArr[k++] = arr[i++];
         } else {
            newArr[k++] = arr[j++];
         }
        }
        while(i<=mid) {
            newArr[k++] = arr[i++];
        }
        while(j<=ei) {
            newArr[k++] = arr[j++];
        }
        for(k=0; k<newArr.length; k++) {
            arr[si++] = newArr[k];
        }        
    }
    public static int getInversionCount(int arr[], int si, int ei) { 
        if(si==ei) {
            return 0;
        }
        int mid = si + (ei-si)/2;
        int left = getInversionCount(arr, si, mid);
        int right = getInversionCount(arr, mid+1, ei);
        return left+right+getCount(arr, mid);
    }
    public static int getCount(int[] arr, int mid) {
        int count = 0;
        while(arr[mid-1]>arr[mid] || ) {
          if(arr[mid-1]>arr[mid]) {
            int temp = arr[mid-1];
            arr[mid-1] = arr[mid];
            arr[mid] = temp;
            System.out.println(arr[mid-1]+", " + arr[mid]);
            System.out.println(count++);
          } else if(arr[mid+1]<arr[mid]) {
            int temp = arr[mid+1];
            arr[mid+1] = arr[mid];
            arr[mid] = temp;
            System.out.println(arr[mid+1]+", " + arr[mid]);
            System.out.println(count++);
          }
        }
        return count;
    }
}
