import java.util.*;
import java.util.LinkedList;
public class BinaryTreeB {
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int idx = -1;
    public static Node treeBuilder(int nodes[]) {
        idx++;
        if(nodes[idx] == -1) {
            return null;
        }
        Node newnode = new Node(nodes[idx]);
        newnode.left =  treeBuilder(nodes);
        newnode.right = treeBuilder(nodes);
        return newnode;
    }
    /*public static void preorder(Node root) {
        if(root == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }*/
    public static void inorder(Node root) {
        if(root ==  null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " "); 
        inorder(root.right);
    }
    public static void postorder(Node root) {
        if(root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    public static void levelorder(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
          Node curr = q.remove();
          if(curr == null) {
            System.out.println();
            if(q.isEmpty()) {
                break;
            } else {
                q.add(null);
            }
          } else {
            System.out.print(curr.data + " ");
            if(curr.left != null) {
               q.add(curr.left);
            }
            if(curr.right != null) {
               q.add(curr.right);
            }
          }
        }
    }
    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }
    public static int count(Node root) {
        if(root == null) {
            return 0;
        }
        int lc = count(root.left);
        int rc = count(root.right);
        return lc+rc+1;
    }
    public static int sum(Node root) {
        if(root == null) {
            return 0;
        }
        int ls = sum(root.left);
        int rs = sum(root.right);
        return ls+rs+root.data;
    }
    // Approach 1. 
    public static int treeDia(Node root) {
        if(root == null) {
            return 0;
        }
        int ldiam = treeDia(root.left);
        int rdiam = treeDia(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        int rootdiam = lh+rh+1;
        return Math.max(rootdiam, Math.max(ldiam, rdiam));
    }
    // Approach2.
    /*public static class Info {
        int diam;
        int ht;
        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }*/
    /*public static Info diameter(Node root) {
        if(root == null) {
            return new Info(0, 0);
        }
        Info linfo = diameter(root.left);
        Info rinfo = diameter(root.right);
        int finaldia = Math.max(Math.max(linfo.diam, rinfo.diam), linfo.ht+rinfo.ht+1);
        int finalht = Math.max(linfo.ht, rinfo.ht) + 1;
        return new Info(finaldia, finalht);
    }
    public static boolean isidentical(Node node, Node subroot) {
        if(node == null && subroot == null) {
            return true;
        } else if(node == null ||  subroot == null || node.data != subroot.data) {
            return false;
        }
        if(!isidentical(node.left, subroot.left)) {
            return false;
        }
        if(!isidentical(node.right, subroot.right)) {
            return false;
        }
        return true;
    }
    public static boolean issubtree(Node node, Node subroot) {
        if(node == null) {
            return false;
        }
        if(node.data == subroot.data) {
            return isidentical(node, subroot);
        }
        return issubtree(node.left, subroot) || issubtree(node.right, subroot); 
    }*/
    public static class Info{
        Node node;
        int hd;
        public Info(int hd, Node node) {
           this.hd = hd;
           this.node = node;
        }
    }
      // Top view
    public static void topview(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        map.put(0, root);
        q.add(new Info(0, root)); q.add(null); int min = 0; int max = 0; Info curr;
        while(!q.isEmpty()) {
            curr = q.remove();
            if(curr == null) {
               if(q.isEmpty()) {
                break;
               } else {
                q.add(null);
               }
            } else {
                if(!map.containsKey(curr.hd)) {
                   map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null) {
                    q.add(new Info(curr.hd-1, curr.node.left));
                    min = Math.min(curr.hd-1, min);
                }
                if(curr.node.right != null) {
                    q.add(new Info(curr.hd+1, curr.node.right));
                    max = Math.max(curr.hd+1, max);
                }
            }
        }
        for(int i=min; i<=max; i++) {
            System.out.print(map.get(i).data + " ");
        }

    }
    // Bottom view
    public static void bottomview(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        map.put(0, root);
        q.add(new Info(0, root)); q.add(null); int min = 0; int max = 0; Info curr;
        while(!q.isEmpty()) {
            curr = q.remove();
            if(curr == null) {
               if(q.isEmpty()) {
                break;
               } else {
                q.add(null);
               }
            } else {
                
                map.put(curr.hd, curr.node);
                
                if(curr.node.left != null) {
                    q.add(new Info(curr.hd-1, curr.node.left));
                    min = Math.min(curr.hd-1, min);
                }
                if(curr.node.right != null) {
                    q.add(new Info(curr.hd+1, curr.node.right));
                    max = Math.max(curr.hd+1, max);
                }
            }
        }
        for(int i=min; i<=max; i++) {
            System.out.print(map.get(i).data + " ");
        }

    }
    // Kth Level of a tree
    //1. iterative approach 
    public static void kthLevel(Node root, int k) {
        Queue<Node> q = new LinkedList<>();
        q.add(root); q.add(null); int level = 1;
        while(!q.isEmpty()) {
            Node curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    return;
                } else {
                    level++;
                    if(level == k) {
                        break;
                    }
                    q.add(null);
                }
            } else {
                if(curr.left != null) {
                     q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        while(!q.isEmpty()) {
            System.out.print(q.peek().data + " ");
            q.remove();
        }
    }
    //2. recursive approach preorder
    public static void kthLevelR(Node root, int k, int level) {
        if(root == null) {
            return;
        }
        if(level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kthLevelR(root.left, k, level+1);
        kthLevelR(root.right, k, level+1);
        
    }
    // Last Common Ancestor
    public static boolean getPath(Node root, int n, ArrayList<Node> l) {
        if(root == null) {
            return false;
        }
        l.add(root);
        if(root.data == n) {
            return true;
        }
        boolean leftpath = getPath(root.left, n, l);
        boolean rightpath = getPath(root.right, n, l);
        if(leftpath || rightpath) {
            return true;
        }
        l.remove(l.size()-1);
        return false;
    }
    public static Node lCA(Node root, int n1, int n2) {
        ArrayList<Node> l1 = new ArrayList<>();
        ArrayList<Node> l2 = new ArrayList<>();
        
        getPath(root, n1, l1);
        getPath(root, n2, l2);
        int i=0;
        for(; i<l1.size() && i<l2.size(); i++) {
            if(l1.get(i) != l2.get(i)) {
               break;
            }
        }
        return l1.get(i-1);
    }
    public static Node lCA2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftlca = lCA2(root.left, n1, n2);
        Node rightlca = lCA2(root.right, n1, n2);
        if(leftlca == null) {
            return rightlca;
        }
        if(rightlca == null) {
            return leftlca;
        }
        return root;
    }
    // Min. distance between nodes
    public static int dist(Node root, int n, Node lca) {
        if(root == null) {
            return -1;
        }
        if(root.data == n) {
            return 0;
        }
        int leftdist = dist(root.left, n, lca);
        int rightdist = dist(root.right, n, lca);
        if(leftdist == -1 && rightdist == -1) {
            return -1;
        } else if(leftdist == -1) {
            return rightdist+1;
        } else if(rightdist == -1) {
            return leftdist+1;
        }
        return -1;
    }
    public static int minDis(Node root, int n1, int n2) {
        Node lca = lCA2(root, n1, n2);
        int dis1 = dist(root, n1, lca);
        int dis2 = dist(root, n2, lca);
        return dis1+dis2;        
    }
    // Kth ancestor
    public static int kAncestor(Node root, int node, int k){
        if(root == null) {
            return -1;
        }
        if(root.data == node) {
            return 0;
        }
        int kleft = kAncestor(root.left, node, k);
        int kright = kAncestor(root.right, node, k);
        if(kleft == -1 && kright == -1) {
            return -1;
        }
        int max = Math.max(kleft, kright);
        if(max+1 == k) {
            System.out.print(root.data);
        }
        return max+1;
    }
    // sumtree
    public static int sumtree(Node root) {
        if(root == null) {
            return 0;
        }
        int lsum = sumtree(root.left);
        int rsum = sumtree(root.right);
        int temp = root.data;
        root.data = lsum+rsum;
        return temp+lsum+rsum;
    }
    public static void preorder1(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+ " ");
        preorder1(root.left);
        preorder1(root.right);
    }
    // Assignment
    //Q1. univalued or not
    public static boolean isUnivalued(Node root) {
        if(root == null) {
            return true;
        }
        if(root.left != null) {
            if(root.data!=root.left.data) {
                return false;
            }
        }
        if(root.right!=null) {
            if(root.data!=root.right.data) {
             return false;
            }
        }
        return isUnivalued(root.left) && isUnivalued(root.right);
    }
     // Q2. Mirror
     public static Node mirror(Node root) {
        if(root == null) {
            return null;
        }
        Node left = mirror(root.left);
        Node right = mirror(root.right);
        // swap
        root.left = right;
        root.right = left;
        return root;
     }
     // Q3.  delete leaf node with val = key
     public static Node deleteLeaf(Node root, int key) {
        if(root == null) {
            return null;
        }
        root.left = deleteLeaf(root.left, key);
        root.right= deleteLeaf(root.right, key);
        if(root.left==null && root.right==null && root.data==key) {
            return null;
        }
        return root;
     }
     // Q5. maximum path
     public static int maxPath(Node root) {
        if(root==null) {
            return 0;
        }
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        return Math.max(Math.max(left, right), left+right+root.data);
     }
    public static void main(String args[]) {
        /*int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = treeBuilder(nodes);
        //System.out.println(root.data);
        //preorder(root);
        //inorder(root);
        //postorder(root);
        //levelorder(root);
        Node newnode = new Node(1);
        newnode.left = new Node(2);
        newnode.right = new Node(3);
        newnode.left.left = new Node(4);
        newnode.left.right = new Node(5);
        newnode.right.right = new Node(6);
        //System.out.print(height(root));
        //System.out.print(count(root));
        //System.out.print(sum(root));
        //System.out.print(treeDia(root));
        //System.out.print(diameter(root).diam);
        Node subroot = new Node(2);
        subroot.left = new Node(9);
        subroot.right = new Node(5);
        //System.out.print(issubtree(root, subroot));
        //topview(root);
        //bottomview(root);
        //int k = 0;
        //kthLevel(root, k);
        //kthLevelR(root, k, 1);
        //System.out.print(lCA2(root, 4, 8).data);
        //System.out.print(minDis(root, 4, 6));
        //kAncestor(root, 6, 1);
        sumtree(root);
        preorder1(root);*/
        /*Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        inorder(root);
        root = mirror(root);
        System.out.println();
        //System.out.println(isUnivalued(root));
        inorder(root);*/
        // Node root = new Node(1);
        // root.left = new Node(3);
        // root.right = new Node(3);
        // root.left.left = new Node(3);
        // root.left.right = new Node(2);
        // root = deleteLeaf(root, 3);
        //inorder(root);
        Node root = new Node((-10));
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.print(maxPath(root));
    }
}