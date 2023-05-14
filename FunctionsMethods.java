import java.util.*;
public class FunctionsMethods {
   //1. calculate sum
    public static int calculateSum(int num1, int num2) { // formalparameters/parameters
        int sum = num1+num2;
        return sum;
    }
   /* public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = calculateSum(a, b);// argument/ actual parameters
        System.out.println("the sum is : " + sum);
    }*/
    //2. multiply
    public static int multiply(int a, int b) {
      int product = a*b;
      return product;
    }
    /*
    public static void main(String args[]) {
        int a = 4;
        int b = 9;
        int prod = multiply(7, 8);
        System.out.print("the product is : " + prod);
    }*/
    //3.factorial
/* // public static int factorial(int n) {
        int f =1;
        for(int i=1; i<=n;i++) {
            f*=i;
        }
        return f;

    }
    public static int bincoff(int n, int r) {
      int fact_n=factorial(n);
      int fact_r=factorial(r);
      int fact_nmr=factorial(n-r);
      int c=fact_n/(fact_r*fact_nmr);
      return c; 
    }
   /* public static void main(String args[]) {
      
        System.out.print(bincoff(10,1));
    }*/
    // is number prime or not
    public static boolean isPrime(int n) {
        //corner case
        if(n==2) {
            return true;
        }
        for(int i=2; i<=n-1; i++) { // i<=Math.sqrt(n);
            if(n%i==0) {
                return false;
            }
        }
        return true;
    } 
    // print prime no range
   /* public static void printnprime(int n) {
        for(int i=2; i<=n-1 ; i++) {
            if(isPrime(i)) { // true
              System.out.print(i + " ");
            }
            
        }
    }
    public static void main(String args[]) {
        printnprime(100);
    }*/
    // binary to decimal
   /* public static void binToDec(int binno) {
        int decno=0;
        int number=binno;
        for(int pow=0; binno>0; pow++) {
            int lastd=binno%10;
            decno = decno+lastd*((int)Math.pow(2, pow));
            binno/=10;
        }
        System.out.print("bin to dec of " + number + " " + decno);
    }
     public static void main(String args[]) {
        binToDec(01);
     }*/
     //binary to decimal
     /*public static void decTobin(int decno) {
       int no=decno;
       int binno=0;
       for(int pow=0; decno>0; pow++) {
        int r=decno%2;
        binno+=r*(int)(Math.pow(10, pow));
        decno/=2;

       }
       System.out.print("binary of " + no + " is " + binno);
     }
     public static void main(String args[]) {
        decTobin(15);
     }*/
     // assignment 
     //1. to find the avg of three no's
     /*public static int avg(int a,int b,int c) {
        int avg = (a+b+c)/3;
        return avg;
     }
     public static void main(String args[]) {
        System.out.print(avg(10, 29, 51));
     }*/
     //2. isEven 
    /* public static boolean isEven(int a) {
        boolean isEven=true;
        if(a%2!=0) {
            isEven=false;
            return isEven;
        }
        return isEven;
     }
     public static void main(String args[]) {
        System.out.print(isEven());
     }*/
     // is paladrome
    /* public static int reverse(int no) {
        int rev=0;
         while(no>0) {
            int r=no%10;
            rev = (rev*10)+r;
            no=no/10;
         }
         return rev;
     }
     public static void main(String args[]) {
        int no=121;
        if(no==reverse(no)) {
          System.out.print("palindrome");
        } else {
           System.out.print("not a palindrome"); 
        }
     }*/
     // 4. use math class
     
   /* public static void main(String args[]) {
        float avg=return (Math.avg(4, 5, 9));
        System.out.print(avg);
    }*/
    //5 to compute the sum of digits in an integer
    public static int sumdigt(int intgr) {
        int sum=0;
        while(intgr>0) {
            int i=intgr%10;
            intgr/=10;
            sum=sum+i;
        }
        return sum;
    }w
    public static void main(String args[]) {
        System.out.print(sumdigt(1223));
    }
    

}