public class DoublyLinkedList {
    public static class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size = 0;
    public static Node prev;

    public void addFirst(int data) {
        Node newnode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }
    public int removeFirst() {
            if(size == 0) {
                return Integer.MIN_VALUE;
            }
            if(size == 1) {
                int pre = head.data;
                head = tail = null;
                size--;
                return pre;
            }
            int pre = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return pre;
    }
    
    public void addLast(int data) {
        Node newnode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newnode;
            return;
        }
        newnode.prev = tail;
        tail.next = newnode;
        tail = newnode;
    }
    public int removeLast() {
         if(size == 0) {
                return Integer.MIN_VALUE;
            }
            if(size == 1) {
                int pre = head.data;
                head = tail = null;
                size--;
                return pre;
            }
            int pre = tail.data;
            Node temp = tail.prev;
            tail.prev = null;
            temp.next = null;
            tail = temp;
            size--;
            return pre;
    }
    public void print() {
        if(head == null) {
            System.out.print("ll is empty");
            return;
        }
        Node temp = head;
        System.out.print("null<-");
        while(temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void reverse() {
        Node pre = null; Node curr = head;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = pre;
            curr.prev = curr;
            pre = curr;
            curr = next;
        }
        head = pre;
    }
    
    public static void main(String args[]) {
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.addFirst(3);
        ll.print();
        ll.addLast(4);
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addFirst(0);
        ll.print();//01234null
        ll.removeFirst();
        ll.print();
        System.out.println(ll.size);
        ll.reverse();
        ll.print();
    }
}