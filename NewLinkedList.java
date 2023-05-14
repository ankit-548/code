import java.util.*;
public class NewLinkedList {
    // mergesort
    public Node mergesort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node mid = midget(head);
        Node righthead = mid.next;
        mid.next = null;
        Node newleft = mergesort(head);
        newright = mergesort(righthead);
        head = merge(newleft, newright);
        return head;
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
        //Note :  I'm having problem here see it wisely;
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(0);
        ll.addLast(1);
        ll.addLast(3);
        ll.add(2, 5);
        System.out.println(ll);
        ll.remove(2);
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);
        //Node head = ll.First;
        //ll.head = ll.mergesort(ll.head);
        System.out.println(ll);
    }
}