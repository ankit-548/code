public class LinkedList2 {
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
    public static boolean detectcycle() {
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
    public static void removecycle() {
        //1. detectcycle
        Node slow = head, fast = head; boolean iscycle = false;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                iscycle = true;
                break;
            }
        }
        if(iscycle == false) {
            return ;
        }

        //2. slow = head
        slow = head; Node prev = null;

        //3. prev.next = null
        while(slow != fast) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = null;
    }
    public Node mergesort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node mid = midget(head);
        Node righthead = mid.next;
        mid.next = null;
        Node lefthead = mergesort(head);
        righthead = mergesort(righthead);
        head = merge(lefthead, righthead);
        return head;
    }
    private Node midget(Node newhead) {
        Node slow = newhead; Node fast = newhead;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private Node merge(Node lefthead, Node righthead) {
        Node start = new Node(0);
        Node temp = start;
        while(lefthead == null && righthead == null) {
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
    public static void main(String args[]) {
        LinkedList2 ll2 = new LinkedList2();
        //ll2.head.data = 1;
        //ll2.head.next.data = 2;
        //ll2.head.next.next.data = 3;
        //ll2.head.next.next.next = head;
        //head = new Node(1);
        //Node temp = new Node(2);
        //head.next = temp;
        //head.next.next = new Node(3);
        //head.next.next.next = temp;
        //System.out.print(detectcycle());
        //removecycle();
        //System.out.print(detectcycle());
        ll2.add(0); ll2.add(1); ll2.add(2); ll2.add(3); ll2.add(4);
        System.out.print(mergesort());
    }
}