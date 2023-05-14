import java.util.*;
public class ConditionalSentence {
    public static void main(String args[]){
     Scanner sc = new Scanner(System.in);
     
     /*int a = sc.nextInt();
     // 1. odd/even no.
     
     if(a % 2 == 0){
        System.out.println("Even");
     } else{
        System.out.println("Odd");
     }*/
     //2 ifelse
    /* int income = sc.nextInt();
     int tax;
     if(income < 500000) {
        tax = 0;
    
     } else if(income >= 500000 && income < 1000000) {
        tax = (int) (income * 0.2);
     } else {
        tax = (int) (income * 0.3);
     }
     System.out.print("Your Tax" + " " + tax);*/
     // 3. ternary check student pass/fail.
     /*int marks = sc.nextInt();
     String reportcard = marks >= 33 ? " Congaratulations you are pass" : " better luck next time fail";
     System.out.print(reportcard);*/
     // 4. calculator
     System.out.println("Enter a"); 
     int a = sc.nextInt();
     System.out.println("Enter b"); 
     int b = sc.nextInt();
     System.out.println("enter symbol");
     char symbol = sc.next().charAt(0);
     

     switch(symbol) {
        case '+' : System.out.println(a+b);
                     break;
        case '-' : System.out.println(a-b);
                     break;
        case '*' : System.out.println(a*b);
                     break;   
        case '/' : System.out.println(a/b);
                     break;
        case '%' : System.out.println(a%b);
                     break;
        default : System.out.println("You will get all your answers soon");
     }
     //System.out.println("enter your no.");
     //System.out.println("patwari abhi door hai"); 
     // Question 1 . a no. positive or negative
    /* float number = sc.nextFloat();
     if(number >= 0) {
        System.out.print("positive");
    
     } else {
        System.out.print("Negative");
     }*/
        //2. question finish code fever
        /*double temp = 103.5;
        if(temp > 100) {
            System.out.print("You have a fever");
        } else {
            System.out.print("You don't hsve a fever");
        }*/
        // 3. 1-7 days of week using switch conditon
        /*System.out.println("enter day of the week");
        int a = sc.nextInt();
        
        switch(a) {
            case 1 : System.out.println("Monday");
                       break;
            case 2 : System.out.println("tuesday");
                       break;  
            case 3 : System.out.println("wednesday");
                       break;
            case 4 : System.out.println("Thursday");
                       break;
            case 5 : System.out.println("friday");
                       break;
            case 6 : System.out.println("Saturday");
                       break;
            case 7 : System.out.println("Sunday");
                      break;*/
                      /*int a = 63, b = 36;
                      boolean x = (a < b ) ? true : false;
                      int y = (a > b ) ? a : b;
                      System.out.println(x);
                      System.out.println(y);*/
                      //5. leap year
                      //System.out.println("enter the year");
                      //int year = sc.nextInt();
                    /* if(year % 4 == 0) {
                        if(year % 100 == 0) {
                           if((year % 400 == 0)) {
                              System.out.print("a leap year");
                           } else {
                               System.out.print("Not a leap year");
                           }
                        } else {
                            System.out.print("a leap year");
                        }
                      } else {
                         System.out.print("Not a leap year");
                      }*/
                     //or using boolean
                    /* boolean x = year % 4 == 0;
                     boolean y  = year % 100 != 0;
                     boolean z = (year % 100 == 0) && (year % 400 == 0);
                     if(x && (y || z)) {
                         System.out.print("a leap year");
                     } else {
                         System.out.print("not a leap year");
                     }*/

        


         
         }
    


    }