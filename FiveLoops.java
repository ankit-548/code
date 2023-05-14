import java.util.*;
public class FiveLoops {
    //public static void main(String args[]) {
        //Scanner sc = new Scanner(System.in);
        //1. print no. 1-10
        /*int n = 1;
        while(n <= 10) {
            System.out.println(n);
            n++;
        }
        System.out.println("numbers printed");*/
        // 2. print number 1-n
        //4System.out.println("enter the number");
        /*int n = sc.nextInt();
        int a = 1;
        while(a <= n) {
            System.out.print(a+ " ");
            a++;
        }
        System.out.println("numbers printed");*/
        // 3. sum of n natural number
        /*System.out.println("enter the number");
        int n = sc.nextInt();
        int sum = 0;
        int a = 1;
        while(a <= n) {
            sum += a;
         a++;
        }
        System.out.println("the sum" + " " + "=" + " " + sum);*/
        //4. for loop print square pattern
        /*for(int i=1; i <= 4; i++) {
            System.out.println("****");
        }*/
        /*5. print reverse of a number*/
       // System.out.println("enter the number");
      /*  int a;
        int i = sc.nextInt();
       /* while(i > 0) {
           a = i%10;
           System.out.print(a + " ");
           i /= 10;
        }
        for(a = i % 10; i >= 0; i /= 10) { //i= 140299 
            System.out.print(a + " ");
        }*/
        //6. do while loop
        /*int counter = 1;
        do {
            System.out.println("Hello World");
            counter++;
        }   while(counter <= 10);*/
        /*for(int i = 1; i <= 5; i++){
            if(i == 3) {
                break;
            } 
            System.out.println(i);
        }
        System.out.print("i am out of the loop");*/
        //7. keep entering a number till user enter multiple of 10
        /*do {
          System.out.print("enter the number : ");
          int a = sc.nextInt();
          if(a % 10 ==0) {
            break;
          }
          System.out.println(a);
        
        } while(true);*/
        //8. continue statement
       /* for(int i = 1;i <= 5; i++) {
            if(i == 3) {
                continue;
            }
         System.out.println(i);
        }*/
        //9. display all numbers entered by user except multiple of 10
        /*do {
            System.out.print("enter the number : ");
            int a = sc.nextInt();
            if(a % 10 == 0) {
                continue;
            }
            System.out.println(a);
        }   while(true);    
        */
        // 10. Given number prime or not
        /*int n = sc.nextInt() ;
        boolean isPrime = true;
        if(n != 2) {
        for(int i = 2; i<=Math.sqrt(n); i++) {
           if(n % i == 0) {
            isPrime = false;
           }
        }
           if(isPrime == true) {
            System.out.print("the number is prime");
           } else {
            System.out.print("the numer is not prime");
           }
        

        } else {
            System.out.print("the number is prime");
        }*/
        //assignment 
       /* //1. read set of no. and write sum of alternate numbers
        int number;
        int choice;
        int evensum = 0;
        int oddsum = 0;
       
        do {
            System.out.println("enter the number");
            number = sc.nextInt();
            if(number % 2 == 0) {
                evensum += number;
            } else {
                oddsum += number;
            }
            System.out.println("Do you want to add more number, for yes press 1 for no press 0");
            choice = sc.nextInt();      
        } while(choice == 1);
        System.out.println("sum of even numbers : " + evensum);
        System.out.println("sum of odd numbers : " + oddsum);*/
        //2. to find factorial
       /* System.out.println("enter the number");
        int number = sc.nextInt();
        int factorial = 1;
        for(int i = number; i >= 1; i--) {
            factorial *= i;
        }
        System.out.println("factorial : " + factorial);*/
        //3. table of a number
        /*System.out.println("enter the number");
        int n = sc.nextInt();
        System.out.println("table is : ");
        
        for(int i =1; i <= 10; i++) {
            int table = n*i;
            
            System.out.println(table);
           }*/
            
    public static void main(String args[]) {
   int nums[] = {2, 7, 11, 15};
   int key = 9;
   twonums(nums, key, 0, nums.length-1);
    }
    public static void twonums(int nums[], int key, int si, int ei) {
        if(si>=ei) {
            return;
        }
        
        if(nums[si]+nums[ei] == key) {
        System.out.print("[" + si + "," + ei + "]");
        return;
        }
        twonums(nums, key, si+1, ei);
        twonums(nums, key, si, ei-1);
        twonums(nums, key, si+1, ei-1);
        
        
    }
   

}       


             
