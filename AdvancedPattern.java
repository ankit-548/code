import java.util.*;
public class AdvancedPattern {
    //1. hollow rectangular pattern
   /* public static void adv_Patt(int n) {
         for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==1 || i==n || j==1 || j==n) {
                    System.out.print("* ");

                } else {
                    System.out.print("  ");
                }
                 
            }
            System.out.println();
         }
    }*/
    //2. inverted and half pyramid pattern
   /* public static void inv_HP(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++) {
                System.out.print("* ");
            }
        System.out.println();
        }
    }*/
    // 3. Inverted Half Pyramid with numbers
    /*public static void inv_HPN(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n-i+1; j++) {
                System.out.print(j + " "); 
            }
            System.out.println();
        }
    }*/
    // 4. Floyds triangle
    
   /* public static void floyds(int n) {
        int counter=1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(counter);
                counter++;
            }
            System.out.println();
        }
    }*/
    //5. 0-1 Triangle
    /*public static void zo_T(int n) {
     for(int i=1; i<=n; i++) {
        for(int j=1; j<=i; j++) {
            if((i+j)%2 == 0){
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();
     }
    }*/
    //6. butterfly pattern
   /**/
   //7. solid rhombus
   public static void solidrhombus(int n) {
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n-i; j++) {
            System.out.print(" ");
        }
        System.out.print("*****");
        System.out.println();
    } 
       }
       //8. hollow rhombus
      /* public static void hol_Rhom(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=n; j++) {
                if(i==1 || i==n || j==1 || j==n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
       }*/

     //9.Diamond Pattern
     /*public static void diamond(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n; i>=1; i--) {
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

     }*/
     //10. number pyramid 
    /* public static void num_p(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
     }*/
     //11.Pallondromic Pattern
     public static void PallindromicPattern(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=i; j>=1; j--) {
                System.out.print(j);
            }
            
            for(int j=2; j<=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
     }

    
    public static void main(String args[]) {
    //adv_Patt(5);
     //inv_HP(5);
    // inv_HPN(5);
    // floyds(4);
    // zo_T(6);
    //butterfly(4);
     solidrhombus(5);
    //hol_Rhom(5);
    //diamond(6);
    //num_p(5);
    //PallindromicPattern(5);
    }
}