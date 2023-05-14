import java.util.*;
public class HashMapA {
    //Q1. Majority Element
    /*public static void majorityEl(int arr[], int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            int num = arr[i];
            if(hm.containsKey(num)) {
                hm.put(num, hm.get(num)+1);
            } else {
                hm.put(num, 1);
            }
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }
        //Set<Integer> s = hm.keySet();
        //for(int key: s) {
        for(int key: hm.keySet()) {
            if(hm.get(key)>n/3) {
                System.out.println(key);
            }
        }
    }
    // Q2. validAnagram
    public static boolean validAanagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            if(hm.containsKey(ch)) {
                if(hm.get(ch)==1) {
                    hm.remove(ch);
                } else {
                    hm.put(ch, hm.get(ch)-1);
                }
            } else {
                return false;
            }
        }
        return hm.isEmpty();
    }
    // Q3. Count Distinct element
    public static void countDistinct(int nums[]) {
       HashSet<Integer> hs = new HashSet<>();
       for(int i=0; i<nums.length; i++) {
        hs.add(nums[i]);
       }
       System.out.println(hs);
    }
    public static void unionIntersection(int arr1 [], int arr2 []) {
        int count = 0;
        HashSet<Integer> hs = new HashSet<>();
        // union
        for(int i=0; i<arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++) {
            hs.add(arr2[i]);
        }

        System.out.println("union");
        Iterator it = hs.iterator();
        while(it.hasNext()) {
            System.out.print(it.next()+" ");
        }
        System.out.println();
        System.out.println(hs.size());

        //Intersection
        hs.clear();
        for(int i=0; i<arr1.length; i++) {
            hs.add(arr1[i]);
        }
        System.out.println("intersection");
        for(int i=0; i<arr2.length; i++) {
            if(hs.contains(arr2[i])) {
              count++;
              System.out.print(arr2[i]+" ");
              hs.remove(arr2[i]); 
            }
        }
        System.out.println();
        System.out.print(count);
    }
    public static String getStart(HashMap<String, String> hs) {
        HashMap<String, String> revhs = new HashMap<>();
        for(String key : hs.keySet()) {
            revhs.put(hs.get(key), key);
        }
        for(String key : hs.keySet()) {
            if(!revhs.containsKey(key)) {
                return key;
            }
        }
        return null;
    }
    public static void largestSubSum(int[] arr) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        int sum=0, len=0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(hs.containsKey(sum)) {
                len = Math.max(len, i-hs.get(sum));
            } else {
                hs.put(sum, i);
            }
        }
        System.out.println("largest subarray with sum '0' len : "+len);
    }
    public static void subArraySumK(int[] arr, int k) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        hs.put(0, 1);
        int sum=0; int ans=0;
        for(int j=0; j<arr.length; j++) {
            sum += arr[j];
            if(hs.containsKey(sum-k)) {
                ans += hs.get(sum-k);
            }
            hs.put(sum, hs.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);
    }*/


    public static List<String> list = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
      if(digits.length()==0) {
        return list;
      }
       HashMap<Character, String> hs = new HashMap<>();
      hs.put('2', "abc");
      hs.put('3', "def");
      hs.put('4', "ghi");
      hs.put('5', "jkl");
      hs.put('6', "mno");
      hs.put('7', "pqrs");
      hs.put('8', "tuv");
      hs.put('9', "wxyz");
       helper(0, digits, hs, new StringBuilder());
       return list;
    }
    
        public static void helper(int i,String digits, HashMap<Character, String> hs, StringBuilder res) {
      if(i==digits.length()) {
        list.add(res.toString());
        return;
      }
      
      String s = hs.get(digits.charAt(i)); // Note: charAt(i) gives us character value thats why we will use Character key
      for(int j=0; j<s.length(); j++) {
        res.append(s.charAt(j));
        helper(i+1, digits, hs, res);
        res.deleteCharAt(res.length()-1);
      }
    }
        public static void main(String args[]) {
        //HashMap<String, Integer> hm = new HashMap<>(); 
        //LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();
        /*TreeMap<String, Integer> hm = new TreeMap<>();
        hm.put("India", 130);
        hm.put("China", 300);
        hm.put("Pak", 50);
        hm.put("Ukrain", 10);
        System.out.println(hm);
        /*System.out.println(hm.get("China"));
        System.out.println(hm.get("srilanka"));
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("srilanka"));
        System.out.println(hm.remove("Pak"));
        System.out.println(hm);
        System.out.println(hm.size());
        System.out.println(hm.isEmpty());
        hm.clear();
        System.out.println(hm);
        System.out.println(hm.isEmpty());
        // Iteration on HashMap
        Set<String> keys = hm.keySet();
        //Map.Entry<String,Integer> keys = hm.entrySet();    ptanhi;
        for(String k: keys) {
            System.out.println("key = "+k+", value = "+hm.get(k));
        }*/
        //int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        //majorityEl(arr, arr.length-1);
        //String s = "tulip", t = "lipid";
        //System.out.println(validAanagram(s, t));
        /*HashSet<String> hs = new HashSet<>();
        hs.add("Vishal");
        hs.add("Sumit");
        hs.add("Ankit");
        hs.add("Chotu Ustaad");
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Vishal");
        lhs.add("Sumit");
        lhs.add("Ankit");
        lhs.add("Chotu Ustaad");
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Vishal");
        ts.add("Sumit");
        ts.add("Ankit");
        ts.add("Chotu Ustaad");*/
        //System.out.println(hs);
        //System.out.println(lhs);
        //System.out.println(ts);
        //int arr[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        //countDistinct(arr);
        /*int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        //unionIntersection(arr1, arr2);
        HashMap<String, String> hs = new HashMap<>();
        hs.put("Chennai", "Bengaluru");
        hs.put("Mumbai", "Delhi");
        hs.put("Goa", "Chennai");
        hs.put("Delhi", "Goa");
        String start = getStart(hs);
        System.out.print(start);
        for(String key : hs.keySet()) {
           System.out.print("->"+hs.get(start));
           start = hs.get(start);
        }*/
        //int arr[] = {3, 4, 5};
        //largestSubSum(arr);
        //int arr[] = {10, 2, -2, -20, 10};
        //subArraySumK(arr, -10);
        letterCombinations("2");
        System.out.println(list);
    }
}