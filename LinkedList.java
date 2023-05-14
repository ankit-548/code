public class LinkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size = 0;
    public void addfirst(int data) {
        Node newnode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newnode; 
            return;
        }
        newnode.next = head;
        head = newnode;
    }
    public void addlast(int data) {
        Node newnode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;
    }
    public void print() {
        if(head == null) {
            System.out.println("LL  is empty");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + ">-");
            temp = temp.next;
        }
        System.out.println("null");
   
    }
    public void add(int idx, int data) {
        if(idx == 0) {
            addfirst(data);
            return;
        }
        Node newnode = new Node(data);
        size++;
        Node temp = head; int i = 0;
        while(i<idx-1) {
            temp = temp.next;
            i++;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }
    public int removefirst()  {
        if(size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        } 
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public  int removelast() {
        if(size == 0) {
            System.out.print("ll is empty");
            return -1;
        } else if(size == 1) {
            int val = tail.data;
            head = tail = null;
            return val;
        }  
        Node prev = head;
        for(int i=0; i<size-2; i++) {
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    public  int itrSearch(int key) {
        int i=0; Node temp = head;
        while(temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public  int helper(Node head, int key) {
        if(head == null) {
            return -1;
        }
        if(head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key) {
        return helper(head, key);
    }
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void nfrmend(int n) {
        int sz=0; Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }
        if(n==sz) {
            head = head.next;
            return;
        }
        int i=1; Node var = head;
        while(i<sz-n) {
            var = var.next;
            i++;
        }
        var.next = var.next.next;
    }
    public Node findMid() {
        Node slow = head; Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome() {
        if(head == null || head.next == null) {
            return true;
        }
        Node midnode = findMid();
        Node curr = midnode; Node prev = null;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head; Node right = prev;
        while(right != null) {
            if(right.data != left.data) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }
    // mergesort
    public Node mergesort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node mid = midget(head);
        Node righthead = mid.next;
        mid.next = null;
        Node newleft = mergesort(head);
        Node newright = mergesort(righthead);
        
        return merge(newleft, newright);
    }
    private Node midget(Node head) {
        Node slow = head; Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private Node merge(Node lefthead, Node righthead) {
        Node start = new Node(0);
        Node temp = start;
        while(lefthead != null && righthead != null) {
            if(lefthead.data <= righthead.data) {
                temp.next = lefthead;
                lefthead = lefthead.next;
            } else {
                temp.next = righthead;
                righthead = righthead.next;
            }
            temp = temp.next;
        }
        while(lefthead != null) {
            temp.next = lefthead;
            lefthead = lefthead.next;
            temp = temp.next;
        }
        while(righthead != null) {
            temp.next = righthead;
            righthead = righthead.next;
            temp = temp.next;
        }
        return start.next;
    }
    public void zigzaged() {
        //1. find mid
        Node slow = head; Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //2. reverse
        Node curr = slow.next; 
        slow.next = null;
        Node prev = null; Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }        
         //3. zigzag
         Node rh = prev; Node lh = head;
         Node nextl; Node nextr;
         while(rh != null && lh != null) {
            nextl = lh.next;
            lh.next = rh;
            nextr = rh.next;
            rh.next = nextl;

            lh = nextl;
            rh = nextr;
         }
        
    }
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.print();
        ll.addfirst(2);
        ll.print();
        ll.addfirst(1);
        ll.print();
        ll.addlast(4);
        ll.print();
        ll.addlast(5);
        ll.print();
        ll.add(2, 3); 
        ll.print();
        /*System.out.println(ll.size);
        ll.removefirst();
        ll.print();
        System.out.println(ll.size);
        ll.removelast();
        ll.print();
        System.out.println(ll.size);*/
        //System.out.println(ll.itrSearch(9));
        //System.out.println(ll.itrSearch(10));
        //System.out.println(ll.recSearch(9));
        //System.out.println(ll.recSearch(10));
        //ll.reverse();
        //ll.print();
        // find nth term from end;
        //ll.nfrmend(3);
        //ll.print();
        //System.out.println(ll.isPalindrome());
        //ll.head = ll.mergesort(ll.head);
        //ll.print();
        ll.zigzaged();
        ll.print();
    }
}