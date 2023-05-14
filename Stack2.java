import java.util.*;
public class Stack2 {
    /*public static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();
        public boolean isEmpty() {
            return list.size() == 0;
        }
        public void push(int data) {
            list.add(list.size(), data);
        }
        public int pop() { 
            if(isEmpty()) {
                return -1;
            }
            int pop = list.get(list.size()-1);
            list.remove(list.size()-1);
            return pop;
        }
        public int peek() {
            if(isEmpty()) {
                return -1;
            }
            return list.get(list.size()-1);
        }
    }*/
    // 2. Stack implimentation using linkedlist
    /*public static class Node {
            int data;
            Node next;
            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
    public static class Stack {        
        public static Node head = null;
        public boolean isEmpty() {
            return head == null;
        }
        public void push(int data) {
            Node newnode = new Node(data);
            if(head == null) {
                head = newnode;
                return ;
            }
            newnode.next = head;
            head = newnode;
        }
        public int pop() {
            if(head == null) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        public int peek() {
            if(head == null) {
                return -1;
            }
            return head.data;
        }
    }*/
    //1. 2. push at bottom
    public static void pushBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
             s.push(data);
             return;
        }
        int top = s.pop();
        pushBottom(s, data);
        s.push(top);
    }
    // 3. reverse a string 
    public static String reversestr(String str) {
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i;
        for(i=0; i<str.length(); i++) {
           s.push(str.charAt(i));
        }
        while(!s.isEmpty()) {
            sb = sb.append(s.pop());
        }
        return sb.toString();
    } 
    // 4. reverse a stack
    public static void reversestack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reversestack(s);
        pushBottom(s, top);
    }
    public static void print(Stack<Integer> s) {
        while(!s.isEmpty()) {
            int top = s.pop();
            System.out.println(top);
        }
    }
    //5. stock span
    public static void stockspan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i=1; i<stocks.length; i++) {
            int currprice = stocks[i];
            while(!s.isEmpty() && currprice >= stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
                s.push(i);
            }
        }
    }
    // 6. next greater left;
    public static void nextgreater(int arr[], int nextGreater[]) {
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }
    public static boolean isvalid(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                s.push(ch);
            } else {
                if(s.isEmpty()) {
                    return false;
                }
                if((s.peek()=='(' && ch==')') 
                   || ( s.peek()=='[' && ch==']') 
                   || ( s.peek()=='{' && ch=='}')) {
                    s.pop();
                   } else {
                    return false;
                   }
            }
            if(s.isEmpty()) {
                return true;
            }
        }
        return false;        
    }
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);int count = 0;
            if(ch==')') {
                while(s.peek()!='(') {
                    s.pop();
                    count++;
                }
                if(count<1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {
                s.push(ch);
            }
        }
        return false;
    }
    //9. max area histogram
    public static void maxareahistogram(int heights[]) {
        int maxarea = 0; 
        int nsl[] = new int[heights.length];
        int nsr[] = new int[heights.length];
        // nsl
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<heights.length; i++) {
            while(!s.isEmpty() && heights[i]<=heights[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //nsr
        s = new Stack<>();
        for(int i=heights.length-1; i>=0; i--) {
            while(!s.isEmpty() && heights[i]<=heights[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = -1;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // area = height*(j-i-1)
        for(int i=0; i<heights.length; i++) {
            int height = heights[i];
            int width = nsr[i]-nsl[i]-1;
            int currarea = height*width;
            maxarea = Math.max(maxarea, currarea);
        }
        System.out.print("max area in histogram : " + maxarea);
    }

    public static void main(String args[]) {
        /*//Stack s = new Stack();
        //Stack<Integer> s = new Stack<>();
        //s.push(1);
        //s.push(2);
        //s.push(3);
        pushBottom(s, 4);
        while(!s.isEmpty()) {
            System.out.println(s.peek());
           s.pop();
        }*/
        //String str = "abc";
        //String result = reversestr(str);
        //System.out.print(result);
        //Stack<Integer> s = new Stack<>();
        /*s.push(1);
        s.push(2);
        s.push(3);
        reversestack(s);
        print(s);*/
        /*int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockspan(stocks, span);
        for(int i=0; i<span.length; i++) {
            System.out.println(span[i]);
        }*/
        /*int arr[] = {6, 8, 0, 1, 3};
        int nextGreater[] = new int[arr.length];
        nextgreater(arr, nextGreater);
        for(int i=0; i<nextGreater.length; i++) {
            System.out.println(nextGreater[i]);
        }*/
        //String str = "{((){}[{}])";
        //System.out.print(isvalid(str));
        //String str1 = "(((a+b))+c)";
        //String str2 = "((a+b)+(c+d))";
        //System.out.print(isDuplicate(str2));
        int heights[] = {2, 1, 5, 6, 2 ,3};
        maxareahistogram(heights);

    }
}