public class BinarySearchTreeAss {
    public static class Node {
        int data; Node left; Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node getBst(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }
        if(root.data < data) {
            root.right = getBst(root.right, data);
        }
        if(root.data > data) {
            root.left = getBst(root.left, data);
        }
       return root;
    }
    // Q1. Range of Bst    O(n)
    public static int getSumBst(Node root, int key1, int key2) {
        if(root == null) {
            return 0;
        }
        int left = getSumBst(root.left, key1, key2);
        int right = getSumBst(root.right, key1, key2);
        if(root.data<=key2 && root.data>=key1) {
            return root.data+left+right;
        }
        return left+right;
    }
    // Q.2 Find closest element in bst O(h)->O(logn)
    
    public static Node node;
    public static Node getDiff(Node root, int key, Node node, int minDiff) {
        if(root == null) {
            return node;
        }
        if((Math.abs(root.data-key))<minDiff) {
            node = root;
            minDiff = Math.abs(root.data-key);
        }
        if(key<=root.data) {
            return getDiff(root.left, key, node, minDiff);
        } else {
            return getDiff(root.right, key, node, minDiff);
        }
    }
    public static int count;
    public static Node kthSmallestEl(Node root, int k) {
        if(root == null) return null;
        Node left = kthSmallestEl(root.left, k);
        if(left != null) {
            return left;
        }
        count++;
        if(count == k) {
            return root;
        }
        return kthSmallestEl(root.right, k);
    }
    public static void main(String args[]) {
        // Node root = null;
        // root = getBst(root, 10);
        // getBst(root, 5);
        // getBst(root, 3);
        // getBst(root, 7);
        // getBst(root, 15);
        // getBst(root, 18);
        // System.out.print(getSumBst(root, 7, 15));
        // Node root = null;
        // root = getBst(root, 8);
        // getBst(root, 5);
        // getBst(root, 3);
        // getBst(root, 6);
        // getBst(root, 11);
        // getBst(root, 20);
        // // System.out.println(root.data);
        // node = null;
        // node = getDiff(root, 2, node, Integer.MAX_VALUE);
        // System.out.print(node.data);
        Node root = null;
        root = getBst(root, 8);
        getBst(root, 5);
        getBst(root, 3);
        getBst(root, 6);
        getBst(root, 11);
        getBst(root, 20);
        Node node = kthSmallestEl(root, 3);
        System.out.print(node.data);
    }
}
