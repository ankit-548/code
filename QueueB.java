import java.util.*;
import java.util.LinkedList;

public class QueueB {
    //Queue using array
    /*static class Queue {
        static int arr[];
        static int size;
        static int rear;
        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }
     
        public static  boolean isEmpty() {
            return rear == -1;
        }
        public static void add(int data) {
            if(rear == size-1) {
                System.out.print("Queue is full");
                return;
            }
            rear = rear+1;
            arr[rear] = data;
        }
        public static int remove() {
            if(isEmpty()) {
                System.out.print("Queue is empty");
                return -1;
            }
            int front = arr[0];
            for(int i=0; i<size-1; i++) {
                arr[i] = arr[i+1];
            }
            rear = rear-1;
            return front;
        }
        public static int peek() { 
            if(rear==-1) {
                System.out.print("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    }
    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;
        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }
        public static boolean isFull() {
            return (rear+1)%size == front;
        }
     
        public static  boolean isEmpty() {
            return rear == -1;
        }
        public static void add(int data) {
            if(isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if(front ==-1) {
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];
            if(rear == front) {
                rear = front = -1;
            } else {
            front = (front+1)%size;
            }

            return result;
        }
        public static int peek() { 
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
        q.remove();
        q.add(4);
        System.out.println(q.peek());
        q.add(5);
        q.remove();
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }*/
    // Q1. Queue using LinkedList
    /*public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class Queue {
        static Node head = null;
        static Node tail = null;
     
        public static  boolean isEmpty() {
            return head==null && tail==null;
        }
        public static void add(int data) {
            Node newnode = new Node(data);
            if(head==null && tail==null) {
                head = tail = newnode;
                return;
            }
            tail.next = newnode;
            tail = newnode;
        }
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = head.data;
            if(head == tail) {
                head = tail = null;
                return -1;
            } else {
            head = head.next;
            }

            return result;
        }
        public static int peek() { 
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }*/
    /*public static void main(String args[]) {
        //Queue q = new Queue();
        //Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }*/
    // Q2. approach 1. Queue;
    /*static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();
    public boolean isEmpty() {
        return s1.isEmpty();
    }
    public void add(int data) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(data);
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    public int remove() {
        if(s1.isEmpty()) {
            System.out.print("Queue is Empty");
            return -1;
        }
        int result = s1.peek();
        s1.pop();
        return result;
    }
    public int peek() {
        if(s1.isEmpty()) {
            System.out.print("Queue is Empty");
            return -1;
        }
        return s1.peek();
    }*/
    // Approach 2.
    /*static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();
    public boolean isEmpty() {
        return s1.isEmpty();
    }
    public void add(int data) {
        s1.push(data);
    }
    public int remove() {
        if(s1.isEmpty()) {
            System.out.print("Queue is Empty");
            return -1;
        }
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int result = s2.pop();
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return result;
    }
    public int peek() {
        if(s1.isEmpty()) {
            System.out.print("Queue is Empty");
            return -1;
        }
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int result = s2.peek();
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return result;
    } 

    public static void main(String args[]) {
        QueueB q = new QueueB();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }*/
    // Q3.  Stack using Queue;
    //approach 2
    /*public class Stack {
        static Queue<Integer> q1 = new ArrayDeque<>();
        static Queue<Integer> q2 = new ArrayDeque<>();
        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }
        public static void push(int data) {
            if(!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }
        public static  int pop() {
            if(q1.isEmpty() && q2.isEmpty()) {
                System.out.print("Stack is empty");
                return -1;
            }
            int top = -1;
            if(!q1.isEmpty()) {
               top = q1.remove();
               if(q1.isEmpty()) {
                return top;
               }
               q2.add(top);
            } else {
               top =q2.remove();
               if(q2.isEmpty()) {
                return top;
               }
               q1.add(top);
            }
            return top;
        }
        public static int peek() { 
            if(q1.isEmpty() && q2.isEmpty()) {
                System.out.print("Stack is empty");
                return -1;
            }
            int top = -1;
            if(!q1.isEmpty()) {
               top = q1.remove();
               
               q2.add(top);
            } else {
               top =q2.remove();
              
               q1.add(top);
            }
            return top;
        }
    }  
    public static void main(String args[]) {
        QueueB s = new QueueB();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }*/
    // Approach 1. 
    /*public static class Stack {
        static Queue<Integer> q1 = new ArrayDeque<>();
        static Queue<Integer> q2 = new ArrayDeque<>();
        public boolean isEmpty() {
            return q1.isEmpty();
        }
        public void push(int data) {
            if(q1.isEmpty()) {
               q1.add(data);
               return; 
            }
            while(!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            q1.add(data);
            while(!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        }
        public int pop() {
            if(q1.isEmpty()) {
                System.out.print("Stack is Empty") ;
                return -1;
            }
            return q1.remove();
        }
        public int peek() {
            if(q1.isEmpty()) {
                System.out.print("Stack is Empty");
                return -1;
            }
            return q1.peek();
        }
    }
    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()) {
            System.out.println(s.peek());
             s.pop();
        }
    }*/
    // Q4. first Nonrepeating Letter

    /*public static void firstnonrepeating(String str) {
        int freq[] = new int[25];
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1) {
                q.remove();
            }
            if(!q.isEmpty()) {
             System.out.print(q.peek() + " ");   
            } else {
                System.out.print("-1 ");  
            }
            
        }
        System.out.println();
    }
    public static void main(String args[]) {
        String str = "aabccxb";
        firstnonrepeating(str);
    }*/
    /*public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        for(int i=0; i<size/2; i++) {
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
    public static void reverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()) {
            s.push(q.remove());
        }
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }*/
    /*public static void main(String args[] ){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        //interLeave(q);
        //reverse(q);
        /*while(!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }

        
    }*/
    // Deque
    /*public static void main(String args[]) {
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addLast(2);
        d.addFirst(0);
        d.addLast(3);
        d.addLast(4);
        d.addLast(5);
        d.removeLast();
        System.out.println(d);
        d.addFirst(3);
        System.out.println(d.getFirst());
        System.out.println(d);
    }*/
    // Q7. Stack using Deque
    /*public static class Stack {
        Deque<Integer> deque = new LinkedList<>();
        public void push(int data) {
            deque.addLast(data);
            return;
        }
        public int pop() {
            return deque.removeLast();
        }
        public int peek() {
            return deque.getLast();
        }
    }
     public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(5);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        
     }*/
     /*public static class Queue {
         Deque<Integer> deque = new LinkedList<>();
         public void add(int data) {
            deque.addLast(data);
         }
         public int remove() {
            return deque.removeFirst();
         }
         public int peek() {
            return deque.getFirst();
         }

     }
     public static void main(String args[]) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());

     }*/
     // Assignment
     //Q1. generate all binary nums
     /*public static void main(String args[]) {
        int n=2;
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n-->0) { 
            String s1 = q.peek();
            q.remove();
            System.out.print(s1+" ");
            q.add(s1+"0");
            q.add(s1+"1");
        }
     }*/
     // Q2. Connect n ropes
     /*public static int connectnrope(int arr[]) {
        int mincost = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
            q.add(arr[i]);
        }
        while(q.size()>1) {
           Integer a = q.poll();
           Integer b = q.poll();
           q.add(a+b);
           mincost += (a+b);
        }
        return mincost;
     }
     public static void main(String args[]) {
        int arr[] = {1, 2, 3};
        System.out.print(connectnrope(arr));
        
     }*/

     //Q4 Reversing the first k elements
    /*public static void reverseKel(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=1; i<=k; i++) {
            s.push(q.peek());
            q.remove();
        }
        
        while(!q.isEmpty()) {
            q2.add(q.peek());
            q.remove();
        }
        while(!s.isEmpty()){
            q.add(s.peek());
            s.pop();
        }
        while(!q2.isEmpty()) {
            q.add(q2.peek());
            q2.remove();
        }

    }
    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>(); 
            q.add(10); q.add(20); q.add(30); q.add(40); q.add(50); 
            q.add(60); q.add(70); q.add(80); q.add(90); q.add(100);
            reverseKel(q, 5);
            while(!q.isEmpty()) {
                System.out.print(q.peek() + " ");
                q.remove();
            } 
            System.out.print(q);
    }*/
    //Q5. max of subarrays of size k
    /*public static void maxel(int arr[], int k) {
        Queue<Integer> q = new LinkedList<>();
        int n = arr.length-1; int max = Integer.MIN_VALUE;
        for(int i=0; i<=n-k+1; i++) {
            int j=0;
            while(j<k) {
                q.add(arr[i+j]);
                j++;
            }
            while(!q.isEmpty()) {
                int curr = q.remove();
                if(curr>max) {
                    max = curr;
                }
            }
            System.out.print(max + " ");
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        maxel(arr, 3);

    }*/
    
    
}