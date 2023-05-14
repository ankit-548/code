import java.util.*;
public class PatternNestedLoops {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //1. nested star pattern
        /*for(int line=1; line<=4; line++) {
            for(int star=1; star<=line; star++) {
                System.out.print("*");
            }
            System.out.println();
        }*/
        //2. inverted star pattern
        /*int n=10;
        for(int line=1; line<=n; line++) {
            for(int star=1; star<=n-line+1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }*/
        //3.Half pyramid pattern
       /* for(int line=1; line<=4; line++) {
            for(int n=1; n<=line; n++) {
                System.out.print(n);
            }
         System.out.println();
        }*/
        //4. character pattern
       /* int n=4;
        char ch='A';
        for(int line=1; line<=n; line++) {
            for(int character=1; character<=line; character++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }*/
        // inverted  half pyramid with numbers 5*5
       /* for(int line=1; line<=5; line++) {
            for(int num=1; num<=5-line+1; num++) {
                System.out.print(num);

            }
            System.out.println();
        }*/
       /* int n=5;
        int value=1;
         for(int line=1; line<=n; line++) {
            for(int num=1; num<=line; num++) {
                System.out.print(value + " ");
                value++;// value next time bda hua se start krege next loop me 
                        // because iska iniitialisation bahar bale for ke bahar hai 
                        // hm for ke ander deal kr rhe isliye again begining se initialise ni krna pdta

            }
            System.out.println();
        }*/
        //0-1 triangle pattern
        /*int n=5;
        
         for(int line=1; line<=n; line++) {

            if(line%2==0) {
                int value=0;
              for(int num=1; num<=line; num++) {
                System.out.print(value + " ");
                if(value==1) {
                   value=0;
                } else {
                    value=1;
                }
            }
            System.out.println();
            } else {
                int value=1;
              for(int num=1; num<=line; num++) {
                System.out.print(value + " ");
                if(value==1) {
                   value=0;
                } else {
                    value=1;
                }
            }
            System.out.println();
            }
            
        }*/
        //inverted & rotated half pyramid 4*4
        /* int n=4;
        
         for(int line=1; line<=n; line++) {
            for(int num=1; num<=n; num++) {
                if(num<n-line+1) {
                   System.out.print(" ");     
                } else {
                     System.out.print("*");
                }
            }
            System.out.println();
         }*/
         //trying for rhombus
         /*int n=5;
        
         for(int line=1; line<=n; line++) {
            for(int num=1; num<=n; num++) {
                if(num<n-line+1) {
                  do {
                    System.out.print(" ");     
                    num++;
                   } while(num<n-line+1);
                } else {
                    System.out.print("*****");
                }           
                               
           }
            System.out.println();
         }*/


    }
}