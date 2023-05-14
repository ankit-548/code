import java.util.*;
import java.util.Collection;
import java.util.Arrays;
public class HeapA {
    public static class Heap {
       ArrayList<Integer> arr = new ArrayList<>();
        public void add(int val) {
            arr.add(val);
            int x = arr.size()-1;
            int par = (x-1)/2;
            while(arr.get(x)<arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x-1)/2;
            }
        }
        public int peek() {
            
            return arr.get(0);
        } 
        public boolean isEmpty()  {
            return arr.size() == 0;
        }
        public int remove() {
            int data = arr.get(0);
            //1. swap first and last idx
            int temp = arr.get(arr.size()-1);
            arr.set(arr.size()-1, arr.get(0));
            arr.set(0, temp);
            //2. remove last idx
             arr.remove(arr.size()-1);
            //3. heapify
            heapify(0);
            return data;
        }
        public void heapify(int i) {
            int minIdx = i;
            int left = 2*i+1;
            int right = 2*i+2;
            // if left index is min index and exist
              if(left<arr.size() && arr.get(left)<arr.get(minIdx)) {
                minIdx = left;
              }
            // if right index is min index and exist
            if(right<arr.size() && arr.get(right)<arr.get(minIdx)) {
                minIdx = right;
            }
            // if i is not min index swap
            if(minIdx!=i) {
              int temp = arr.get(i);
              arr.set(i, arr.get(minIdx));
              arr.set(minIdx, temp);
              heapify(minIdx);
            }

        }
    }
    //Q1. heapsort
    public static void heapsort(int arr[]) {
        int n=arr.length;
        // 1. convert into max heap
        for(int i=n/2; i>=0; i--) {
            heapifyMinH(arr, i, n);
        }
        //2. push largest element to last
        for(int i=n-1; i>0; i--) {
           //swap
            int temp = arr[0];
            arr[0] = arr[i] ;
            arr[i] = temp;
           //heapify
            heapifyMinH(arr, 0, i);
        }        
    }
    // heapify max heap
    public static void heapifyMaxH(int arr[], int i, int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;
        // if left is the max index
        if(left<size && arr[left]>arr[maxIdx]) {
            maxIdx = left;
        }
        // if right is the max index
        if(right<size && arr[right]>arr[maxIdx]) {
            maxIdx = right;
        }
        // if i is not max index
        if(i!=maxIdx) {
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapifyMaxH(arr, i, size);
        }
    }
    public static void heapifyMinH(int arr[], int i, int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;
        // if left is the max index
        if(left<size && arr[left]<arr[maxIdx]) {
            maxIdx = left;
        }
        // if right is the max index
        if(right<size && arr[right]<arr[maxIdx]) {
            maxIdx = right;
        }
        // if i is not max index
        if(i!=maxIdx) {
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapifyMinH(arr, i, size);
        }
    }
    // Q2. n cars
    public static class Point implements Comparable<Point> {
        int x; int y; int idx; int dissq;
        public Point(int x, int y, int dissq, int idx) {
            this.x = x;
            this.y = y;
            this.dissq = dissq;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point p2) {
            return this.dissq-p2.dissq;
        }
    }
    // Q3. Connect n ropes
    /*public static void main(String args[]) {
        int arr[] = {4, 3, 2, 6};
        int ans=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
            pq.add(arr[i]);
        }
        while(pq.size()>1) {
            int first = pq.remove();
            int second = pq.remove();
            ans += first+second;
            pq.add(first+second);
        }
        System.out.println(ans);
    }*/
    // Q4. k weak soldier
    public static class Info implements Comparable<Info> {
        int idx; int soldier;
        public Info(int idx, int soldier) {
            this.idx = idx;
            this.soldier = soldier;
        }
        @Override
        public int compareTo(Info s2) {
            if(this.soldier==s2.soldier) {
                return this.idx-s2.idx;
            }
            return this.soldier-s2.soldier;
        }
        

    }
    //Q5. Sliding Window Maximum
   
    public static class Pair implements Comparable<Pair> {
        int idx; int val;
        public Pair(int idx, int val) {
            this.idx = idx; 
            this.val = val;
        }
        @Override
        public int compareTo(Pair p2) {
            return p2.val-this.val;
        }
    }
    
    // public static void main(String args[]) {
    //     int window[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    //     int k=3; 
    //     int res[] = new int[window.length-k+1];
    //     PriorityQueue<Pair> pq = new PriorityQueue<>();
    //     for(int i=0; i<k; i++) {
    //         pq.add(new Pair(i, window[i]));
    //     }
    //     res[0] = pq.peek().val;
    //     for(int i=k; i<window.length; i++) {
    //     while(pq.size()>0 && pq.peek().idx<=i-k) {
    //         pq.remove();
    //     }
    //         pq.add(new Pair(i, window[i]));
    //         res[i-k+1] = pq.peek().val;
    //     }
    //     for(int i=0; i<res.length; i++) {
    //         System.out.print(res[i]+" ");
    //     }

    // }
    /*public static void main(String args[]) {
        int matrix[][] = {{1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0}};
                        int m = matrix.length; int n = matrix[0].length; int k = 2;

        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i=0; i<m; i++)  {
            int soldier = 0;
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 1) {
                    soldier++;
                }
            }
                pq.add(new Info(i, soldier));
        }
        System.out.println(matrix.length + " " +matrix[0].length);
        for(int i=0; i<k; i++) {
            System.out.println("row"+pq.remove().idx);
        }
    }*/

    /*public static void main(String args[]) {
        /*Heap h = new Heap();
        h.add(10);
        h.add(5);
        h.add(6);
        h.add(3);
        h.add(2);
        h.add(4);
        while(!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }*/
       /* int arr[] = {1, 2, 4, 5 ,3};
        heapsort(arr);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        int arr[][] = {{3, 3}, {5, -1}, {-2, 4}};
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
          int dissq = arr[i][0]*arr[i][0]+arr[i][1]*arr[i][1];
          pq.add(new Point(arr[i][0], arr[i][1], dissq, i));
        }
        for(int i=0; i<2; i++) {
            System.out.println("C"+pq.remove().idx);
        }

        
    }*/
    public static class air{
        int idx; int val;
        public air(int idx, int val) {
            this.idx = idx; 
            this.val = val;
        }        
    }
    // to sort 2d array on basis of 0-indexed coloumn (lambda expression)
    // ye karega kya arrray ko as object lega and object hoge rows hm obj[idx] likhege to us idx ke according sorting hogi
    // public static void main(String args[]) {
    //     int arr[][] = {{3, 2},{4,5}, {5, 6}, {2, 1}, {6, 8}, {7, 3}};
    //     for(int i=0; i<arr.length; i++) {
    //         for(int j=0; j<arr[0].length; j++) {
    //             System.out.print(arr[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
    //     System.out.println();
    //     Arrays.sort(arr, (o1, o2)->o1[0]-o2[0]);
    //     for(int i=0; i<arr.length; i++) {
    //         for(int j=0; j<arr[0].length; j++) {
    //             System.out.print(arr[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
        
    // }
    // to sort 2d array on basis of 1-indexed coloumn (lambda expression)
    // public static void main(String args[]) {
    //     int arr[][] = {{3, 2},{4,5}, {5, 6}, {2, 1}, {6, 8}, {7, 3}};
    //     for(int i=0; i<arr.length; i++) {
    //         for(int j=0; j<arr[0].length; j++) {
    //             System.out.print(arr[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
    //     System.out.println();
    //     Arrays.sort(arr, (o1, o2)->o1[1]-o2[1]);
    //     for(int i=0; i<arr.length; i++) {
    //         for(int j=0; j<arr[0].length; j++) {
    //             System.out.print(arr[i][j]+" ");
    //         }
    //         System.out.println();
    //     }        
    // }
    // below is the actual expression
    public static void main(String args[]) {
            int arr[][] = {{3, 2},{4,5}, {5, 6}, {2, 1}, {6, 8}, {7, 3}};
            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr[0].length; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            Arrays.sort(arr, new mySort());
            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr[0].length; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }        
    }
    public static class mySort implements Comparator<int[]> {
        public int compare(int a[], int b[]) {
            return a[0]-b[0];
        }
    }

}