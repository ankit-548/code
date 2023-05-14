import java.util.ArrayList;
public class BinarySearchTree {
  public static class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
  }
  /*public static Node insert(Node root, int value) {
    if(root == null) {
        root = new Node(value);
        return root;
    }
    if(root.data > value) {
        root.left = insert(root.left, value);
    } else {
        root.right = insert(root.right, value);
    }
    return root;
  }
  public static void preorder(Node root) {
    if(root == null) {
        return;
    }
      System.out.print(root.data + " ");
      preorder(root.left);
      preorder(root.right);
  }
  public static boolean search(Node root, int key) {
    if(root == null) {
        return false;
    }
    if(root.data == key) {
        return true;
    }
    if(root.data > key) {
        return search(root.left, key);
    } else {
        return search(root.right, key);
    }
  }
  public static Node delete(Node root, int val) {
    if(root.data > val) {
      root.left = delete(root.left, val);
    }
    else if(root.data < val) {
      root.right = delete(root.right, val);
    } else {
      //case1.
      if(root.left == null && root.right == null) {
        return null;
      } else if(root.left == null) {//case2
        return root.right;
      } else if(root.right == null) {
        return root.left;
      } else {//case3.
        Node is = inOrderSuccessor(root.right);
        root.data = is.data;
        root.right = delete(root.right, is.data);
      }
    }
    return root;
  }
  public static Node inOrderSuccessor(Node root) {
    while(root.left != null) {
      root = root.left;
    }
    return root;
  }
  public static void printRange(Node root, int k1, int k2) {
    if(root == null) {
      return;
    }
    if(root.data >= k1 && root.data <= k2) {
      printRange(root.left, k1, k2);
      System.out.print(root.data + " ");
      printRange(root.right, k1, k2);
    } else if(root.data>k2) {
      printRange(root.left, k1, k2);
    } else if(root.data<k1) {
      printRange(root.right, k1, k2);
    }    
  }
  public static void printpath(ArrayList<Integer> list) {
    for(int i=0; i<list.size(); i++) {
      System.out.print(list.get(i) + "->");
    }
    System.out.println("null");
  }
  public static void printRToL(Node root, ArrayList<Integer> list) {
    if(root == null) {
      return;
    }
    list.add(root.data);
    if(root.left == null && root.right == null) {
      printpath(list);
    }
    printRToL(root.left, list);
    printRToL(root.right, list);
    list.remove(list.size()-1);
  }
  public static boolean isValidBST(Node root, Node min, Node max) {
    if(root == null) {
      return true;
    }
    if(min != null && root.data <= min.data) {
      return false;
    } 
    if(max != null && root.data >= max.data) { 
      return false;
    } 
    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
  }
  public static Node mirror(Node root) {
    if(root == null) {
      return null;
    }
    Node lmirror = mirror(root.left);
    Node rmirror = mirror(root.right);
    root.left = rmirror;
    root.right = lmirror;
    return root;
  }
  // Sorted array to balanced binary search tree
  public static Node balancedBST(int arr[], int left, int right) {
    if(left>right) {
      return null;
    }
    int mid = (left + right)/2;
    Node root = new Node(arr[mid]);
    root.left = balancedBST(arr, left, mid-1);
    root.right = balancedBST(arr, mid+1, right);
    return root;
  }
  public static void getInorder(Node root, ArrayList<Integer> l) {
    if(root == null) {
      return;
    }
    getInorder(root.left, l);
    l.add(root.data);
    getInorder(root.right, l);
  }
  public static Node getBalBST(ArrayList<Integer> l, int st, int en) {
    if(st>en) {
      return null;
    }
    int mid = (st + en)/2;
    Node root = new Node(l.get(mid));
    root.left = getBalBST(l, st, mid-1);
    root.right = getBalBST(l, mid+1, en);
    return root;
  }
  public static Node balancedBST(Node root) {
    ArrayList<Integer> l = new ArrayList<>();
    getInorder(root, l);
    return getBalBST(l, 0, l.size()-1);    
  }
  public static class Info {
    boolean isBST;
    int size;
    int min;
    int max;
    public Info(boolean isBST, int size, int min, int max) {
      this.isBST = isBST;
      this.size = size;
      this.min = min;
      this.max = max;
    }
  }
  public static int maxBST = 0;
  public static Node maxNode = null;
  public static Info largestBST(Node root) {
    if(root == null) {
      return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    Info linfo = largestBST(root.left);
    Info rinfo = largestBST(root.right);
    int size = linfo.size+rinfo.size+1;
    int min = Math.min(root.data, Math.min(linfo.min, rinfo.min));
    int max = Math.max(root.data, Math.max(linfo.max, rinfo.max));
    if(root.data>=rinfo.min || root.data<=linfo.max) {
      return new Info(false, size, min, max);
    }
    if(linfo.isBST && rinfo.isBST) {
      if(size>maxBST) {
        maxNode = root;
        maxBST = size;
      }
      return new Info(true, size, min, max);
    }
    return new Info(false, size, min, max);
  }*/
  // Merge 2 BSTs
  public static void getInorder(Node root, ArrayList<Integer> list) {
    if(root == null) {
      return;
    }
    getInorder(root.left, list);
    list.add(root.data);
    getInorder(root.right, list);
  }
  public static Node getBST(ArrayList<Integer> list, int st, int end) {
    if(st>end) {
      return null;
    }
    int mid = st + (end-st)/2;
    Node root = new Node(list.get(mid));
    root.left = getBST(list, st, mid-1);
    root.right = getBST(list, mid+1, end);
    return root;
  }
  public static Node mergeBSTs(Node root1, Node root2) {
     // get inorder 1
     ArrayList<Integer> list1 = new ArrayList<>();     
     getInorder(root1, list1);
     // get inorder 2 
     ArrayList<Integer> list2 = new ArrayList<>();
     getInorder(root2, list2);
     // merge 
     int i=0; int j=0;
     ArrayList<Integer> newlist = new ArrayList<>();
     while(i!=list1.size() && j!=list2.size()) {
      if(list1.get(i)<list2.get(j)) {
        newlist.add(list1.get(i));
        i++;
      } else {
        newlist.add(list2.get(j));
        j++;
      }
     }
     while(i!=list1.size()) {
      newlist.add(list1.get(i));
        i++;
     }
     while(j!=list2.size()) {
      newlist.add(list2.get(j));
        j++;
     }
     Node root = getBST(newlist, 0, newlist.size()-1);
     return root;
  }
  public static void inorder(Node root) {
    if(root == null) {
      return;
    }
    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
  }
  public static void main(String args[]) {
    //int values[] = {5, 1, 3, 4, 2, 7};
    //Node root = null;
    //for(int i=0; i<values.length; i++) {
     //  root = insert(root, values[i]);
    //}
    //preorder(root);
    //System.out.println();
    //System.out.print(search(root, 9));
    //delete(root, 3);
    //preorder(root);
    //printRange(root, 2, 6);
    //ArrayList<Integer> list = new ArrayList<>();
    //printRToL(root, list);
    //System.out.print(isValidBST(root, null, null));
    //mirror(root);
    //preorder(root);
    //int arr[] = {3, 5, 6, 8, 10, 11, 12};
    
    //root = balancedBST(arr, 0, arr.length-1);
    //preorder(root);
    /*Node root = new Node(8);
    root.left = new Node(6);
    root.left.left = new Node(5);
    root.left.left.left = new Node(3);
    root.right = new Node(10);
    root.right.right = new Node(11);
    root.right.right.right = new Node(12);
    root = balancedBST(root);
    preorder(root);
    /*Node root = new Node(50);
    root.left = new Node(30);
    root.left.left = new Node(5);
    root.left.right = new Node(20);
    root.right = new Node(60);
    root.right.left = new Node(45);
    root.right.right = new Node(70);
    root.right.right.left = new Node(65);
    root.right.right.right = new Node(80);
    largestBST(root);
    System.out.print(maxBST);
    System.out.println();
    preorder(maxNode);*/
       Node root1 = new Node(2);
       root1.left = new Node(1);
       root1.right = new Node(4);
       Node root2 = new Node(9);
       root2.left = new Node(3);
       root2.right = new Node(12);
       Node root = mergeBSTs(root1, root2);
       inorder(root);
  }
}
