public class SinglyCircularLinkedList {
    public static class Node {
        int data;
        Node next;
    }
    static Node addToEmpty(Node last, int data) {
        if(last != null) {
            return last;
        }
        Node newnode = new Node();        
        newnode.data =  data;
        last = newnode;
        newnode.next = last;
        return last;
    }
    static Node addEnd(Node last, int data) {
        if(last == null) {
            return addToEmpty(last, data);
        }
        Node newnode = new Node();
        newnode.data = data;
        newnode.next = last.next;
        last.next = newnode;
        last = newnode;
        return last;
    }
    static Node addFront(Node last, int data) {
        if(last == null) {
            return addToEmpty(last, data);
        }
        Node newnode = new Node();
        newnode.data = data;
        newnode.next = last.next;
        last.next = newnode;
        return last;
    }
    static Node addAfter(Node last, int data, int key) {
       if(last == null) {
        return null;
       }
       Node newnode = new Node();
       newnode.data = data;
       Node p = last.next;
        do {
            if(p.data==key) {
                newnode.next = p.next;
                p.next = newnode;
                if(p == last) {
                    last = newnode;
                }
                return last;            
            } 
            p = p.next;  
        }while(p != p.next);
        System.out.print("key is not present");
        return last;
    }
    static void traverse(Node last) {
        if(last == null) {
            System.out.print("list is empty");
            return ;
        }
        Node temp = last.next;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while(temp!=last.next);
        System.out.println();
    }
    static Node deleteNode(Node last, int key) {
        if(last == null) {
            return null;
        }
        if(key == last.data && last.next==last) {
          return null;  
        }
       Node temp = last.next;
       do {
           if(temp.next.data == key) {
              temp.next = temp.next.next;
              if(last.data == key) {
                last = temp.next;
              }
              return last;
           }
           temp = temp.next;
       } while(temp != last.next);
       System.out.print("node not present");
       return last;
    }



    public static void main(String args[]) {
        Node last = null;
        last = addToEmpty(last, 6);
         traverse(last);
        last = addEnd(last, 8);
         traverse(last);
        last = addFront(last, 2);
         traverse(last);
        last = addAfter(last, 10, 2);
        traverse(last);
        last = deleteNode(last, 8);
        traverse(last);
    }
}