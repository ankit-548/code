
public class Trie {
    public static class Node {
        boolean eow; Node[] children = new Node[26];
        Node() {
           for(int i=0; i<26; i++) {
            this.children[i] = null;
            }
            eow = false;
        }
    }
    public static Node root = new Node();
    public static void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
     public static boolean search(String key) {
        Node curr = root;
        for(int i=0; i<key.length(); i++) {
            int idx = key.charAt(i)-'a';
            if(curr.children[idx]==null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow==true;
     }
     //Q3. starts.With problem
     public static boolean startsWith(String prefix) {
        Node curr = root;
        for(int i=0; i<prefix.length(); i++) {
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
     }
     //Q1. word Break problem
     public static boolean wordBreak(String key) {
        if(key.length()==0) {
            return true;
        }
        for(int i=1; i<=key.length(); i++) {
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
     }
     // Q4. count unique substring
     public static int countNodes(Node root) {
        int count=0; 
        for(int i=0; i<26; i++) {
            if(root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count+1;
     }
     // Q5. Longest Word
     static String ans = "";
     public static void longestWord(Node root, StringBuilder temp) {
        if(root == null) {
            return;
        }
        for(int i=0; i<26; i++) {
            // check not null and eow true
            if(root.children[i] != null && root.children[i].eow == true) {
                char ch = (char)(i+'a');
                // add char to temp , check templen > anslen
                temp.append(ch);
                if(temp.length()>ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
     }
     // Prefix Problem
     /*public static class Node {
        Node children[] = new Node[26]; int freq;
        boolean eow;
        Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
            freq = 1; eow = false;
        }
      }
      public static Node root = new Node();
      public static void insert(String str) {
          Node curr = root;
          for(int i=0; i<str.length(); i++) {
            int idx = str.charAt(i)-'a';
            if(curr.children[idx]==null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];            
          }
      }
      public static void findPrefix(Node root, String ans) {
        if(root.freq==1) {
            System.out.print(ans + " ");
            return;
        }
        for(int i=0; i<26; i++) {
            if(root.children[i]!=null) {
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
      }*/
    public static void main(String args[]) {
        /*String words[] = {"the", "a", "there", "their", "any", "thee"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        System.out.println(search("thee"));
        System.out.println(search("thor"));
        /*String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        System.out.println(wordBreak("ilikesamsung"));*/
        /*String arr[] = {"zebra", "dog", "duck", "dove"};
        for(int i=0; i<arr.length; i++) {
            insert(arr[i]);
        }
        root.freq = -1;
        findPrefix(root, "");*/
        /*String words[] = {"apple", "app", "mango", "man", "woman"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        System.out.println(startsWith("app"));
        System.out.println(startsWith("moon"));*/
        /*String str = "apple";
        for(int i=0; i<str.length(); i++) {
            String str1 = str.substring(i);
            insert(str1);
        }
        System.out.println(countNodes(root));*/
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}