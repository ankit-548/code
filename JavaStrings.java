import java.util.*;
import java.util.Arrays;
public class JavaStrings {
    //1.is palindrome
    /*public static boolean isPalindrome(String str) {
        for(int i=0; i<str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)) {
               return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        String str = "ANKIT";
        System.out.print(isPalindrome(str));
        
    }*/
    //2. Shortest Path
    /*public static float shortestPath(String str) {
        int x = 0, y = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'N') {
                y++;
            }
            else if(str.charAt(i) == 'S') {
                y--;
            }
            else if(str.charAt(i) == 'E') {
                x++;
            }
            else {
                x--;
            }
        }
        int dir = x*x + y*y;
        float shortpath = (float)(Math.sqrt(dir));
        return shortpath;
    }
    public static void main(String args[]) {
        String str = "WESWWSWNWSSNEENESENN";
        System.out.print(shortestPath(str));
    }*/
    //3. Print substring and largest string
    /*public static String substring(String str, int si, int ei) {
        String substring = "";
        for(int i=si; i<ei; i++) {
           substring+=str.charAt(i);
        }
        return substring;
    }
    //public static void main(String args[]) {
        String str = "Ankit raghuwanshi";
        int si = 0, ei = 5;
        //System.out.print(substring(str,si,ei));
        System.out.print(str.substring(6, str.length()));
        /*String str[] = {"bnana", "Mango", "apple"};
        String largest = str[0];
        for(int i=0; i<str.length; i++) {
            if(largest.compareToIgnoreCase(str[i])<0) {
                largest = str[i];
            }
        }
        System.out.print(largest);*/
        
    //}
    //5. StringBuilder add kakkar in tony
    /*public static void main(String args[]) {
        StringBuilder str = new StringBuilder("TONY");
        String secondname = "KAKKAR";
        for(char ch='a'; ch<='z'; ch++) {
            str.append(ch);
        }
        System.out.print(str);
    }*/
    //6. convert start character to upper case
    /*public static String uppercase(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i)==' ' && i<str.length()-1) {
                 sb.append(' ');
                i++;
             sb.append(Character.toUpperCase(str.charAt(i)));
              }
              else{
                sb.append(str.charAt(i));
              }
        }
        return sb.toString();
    }*/
    public static String uppercase(String str) {
      StringBuilder sb = new StringBuilder();
      sb = sb.append(Character.toUpperCase(str.charAt(0)));
      for(int i=1; i<str.length(); i++) {
        if(str.charAt(i-1) == ' ') {
            sb = sb.append(Character.toUpperCase(str.charAt(i)));
        } else {
            sb = sb.append(str.charAt(i));
        }
      }
      return sb.toString();
    }
    public static void main(String args[]) {
        String str = "hi i am ankit raghuwanshi";
        System.out.print(uppercase(str));
    }
    //7. compress
    /*public static String compress(String str) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++) {
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        String str = "aaabbcccdd";
        System.out.print(compress(str));
    }
    

}*/
    //1. Assignment count lower case vowels
    /*public static void main(String args[]) {
        //String str = new Scanner(System.in).nextLine();
        Scanner sc =  new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        System.out.print(count);
    }*/
    //4. if two numbers anagrams
    /*public static void main(String args[]) {
        String str1 = "Race";
        String str2 = "care";
        
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();
            if(str1.length() == str2.length()) {
            char strtochararray1[] = str1.toCharArray();
            char strtochararray2[] = str2.toCharArray();
           Arrays.sort(strtochararray1);
           Arrays.sort(strtochararray2);
           boolean result = Arrays.equals(strtochararray1, strtochararray2);
            if(result) {
               System.out.print("The Strings are Anagrams");  
            } else {
                 System.out.print("The Strings are not Anagrams");
            }
         } else{
            System.out.print("The Strings are not Anagrams");

        } 
    }*/
    }