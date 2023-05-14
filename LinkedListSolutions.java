public class LinkedListSolutions {
    //ass. 1. Intersection of LinkedList
    /*public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public void printll(Node head) {
        if(head == null) {
           System.out.print("ll is empty");
           return;
        }
        while(head!=null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }
    public Node findIntersection(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            return null;
        }
        Node temp1 = head1; Node temp2 = head2;
        while(temp1 != temp2) {
            temp1 = temp1==null ? head2 : temp1.next;
            temp2 = temp2==null ? head1 : temp2.next;
        }
        return temp1;
    }
    
    public static void main(String args[]) {
      LinkedListSolutions list = new LinkedListSolutions();
      Node newnode = new Node(1);
      
      Node head1 = newnode;
      newnode = new Node(2);
      head1.next = newnode;
      newnode = new Node(3);
      head1.next.next = newnode;
      
      newnode = new Node(4);
      Node head2 = newnode;
      newnode = new Node(5);
      head2.next = newnode;
      newnode = new Node(6);
      head2.next.next = newnode;
      head1.next.next.next = newnode;
      newnode = new Node(7);
      head2.next.next.next = newnode;
      list.printll(head1);
      list.printll(head2);
      Node intersectionNode = list.findIntersection(head1, head2);
      
      System.out.print("intersection node is : " + intersectionNode.data);
            
    }*/
    // 2. Delete N nodes after M nodes;
    /*public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public Node deleteNNodesafM(Node head, int M, int N) {
        if(N==0 || head==null) {
            return head;
        }
        Node temp = head;
        while(temp != null) {
            for(int i=1; i<M && temp!=null; i++) {
               temp = temp.next;
            }
            Node t = temp.next;
            for(int i=1; i<=N && t!=null; i++) {
                 t = t.next;
            }
            temp.next = t;
            temp = t;
        }
        return head;
    }
    public void printll(Node head) {
        if(head == null) {
           System.out.print("ll is empty");
            return;
        }
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]) {
        LinkedListSolutions ll = new LinkedListSolutions();
        Node newnode = new Node(1);
        Node head = newnode;
        Node temp = head;
        for(int i=2; i<11; i++) {
            newnode = new Node(i);
            temp.next = newnode;
            temp = newnode;
            if(i==10) {
                temp.next = null;
            }
        }
        int N = 2, M = 3;
        head = ll.deleteNNodesafM(head, M, N);
        ll.printll(head);
    }*/
    //3. Swapping
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
         this.data = data;
         this.next = null;
        }
    }
    public Node push(Node head, int data) {
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
        return head;
    }
    public Node swapping(Node head, int X, int Y) {
        if(X==Y || head==null){ 
            return head;
        }
        Node currX=head; Node currY=head; 
        Node prevX=null; Node prevY=null;
        while(currX.data!=X && currX!=null) {
            prevX=currX;
            currX=currX.next;
        }
        while(currY.data!=Y && currY!=null) {
            prevY=currY;
            currY=currY.next;
        }
        if(prevX!=null) {
          prevX.next = currY;
        } else {
            head = currY;
        }
        if(prevY!=null) {
            prevY.next = currX;
        } else {
            head = currX;
        }
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
        return head;
    }
    public void printll(Node head) {
         if(head == null) {
             System.out.print("ll is empty");
             return;
         }
         Node temp = head;
         while(temp!=null) {
             System.out.print(temp.data + "->");
             temp = temp.next;
         }
         System.out.println("null");
    }
    //4. Even/Odd LinkedList
    public Node oddEven(Node head) {
        Node curr = head; Node end = head; Node prev = null;
        while(end.next!=null)  {
            end = end.next;
        }
        Node newend = end;
        while(curr.data%2!=0 && curr!=end) {
            newend.next = curr;
            curr = curr.next;
            newend.next.next = null;
            newend =  newend.next;
        }
        if(curr.data%2 == 0) {
            head=curr;
            while(curr!=end) {
                if(curr.data%2==0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    newend.next = curr;
                    newend = curr;
                    curr = prev.next;
                }
            }
        } else prev = curr;
        if(newend!=end && end.data%2!=0) {
            prev.next = end.next;
            end.next = null;
            newend.next = end;
        }
        return head;
    }
    //5. merge K sorted listsw
    public Node mergekLists(Node arr[], int last) {
        while(last!=0) {
            int i=0, j=last;
            while(i<j) {
                arr[i] = sortedmerge(arr[i], arr[j]);
                    i++; j--;
                    if(i>=j) {
                        last=j;
                    }
            }
        }
        return arr[0];
    }
    public Node sortedmerge(Node a, Node b) {
        Node result = null;
        if(a==null) {
            return b;
        } else
        if(b==null) {
            return a;
        }
        if(a.data<=b.data) {
            result = a;
            result.next = sortedmerge(a.next, b);
        }else {
            result = b;
            result.next = sortedmerge(a, b.next);
        }
        return result;
    }
    public static void main(String args[]) {
        LinkedListSolutions ll = new LinkedListSolutions();
        //Node head = null;
        /*head = ll.push(head, 6);
        head = ll.push(head, 5);
        head = ll.push(head, 4);
        head = ll.push(head, 3);
        head = ll.push(head, 2);
        head = ll.push(head, 1);
        ll.printll(head);
        int X = 2; int Y = 5;
        head = ll.swapping(head, X, Y);
        ll.printll(head);*/
        /*head = ll.push(head, 6);
        head = ll.push(head, 1);
        head = ll.push(head, 4);
        head = ll.push(head, 5);
        head = ll.push(head, 10);
        head = ll.push(head, 12);
        head = ll.push(head, 8);
        head = ll.oddEven(head);
        ll.printll(head);*/
        int K=3, N=2;
        
        Node arr[] = new Node[K];
        arr[0] = new Node(1);
        arr[0].next = new Node(3);

        arr[1] = new Node(6);
        arr[1].next = new Node(8);

        arr[2] = new Node(9);
        arr[2].next = new Node(10);
        Node head = ll.mergekLists(arr, K-1);
        ll.printll(head);
        
    }
}