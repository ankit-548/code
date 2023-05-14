import java.util.*;
public class Arrays {
// 1. taking input and giving output
public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// int marks[] = new int[100];
// //marks[0] = sc.nextInt();
// //marks[1] = sc.nextInt();
// //marks[3] = sc.nextInt();
// for(int i=0; i<4; i++) {
//    marks[i] = sc.nextInt();
// }
// System.out.println("marks of physics : " + marks[0]);
// System.out.println("marks of chemistry : " + marks[1]);
// System.out.println("marks of unknown : " + marks[2]);
// System.out.println("marks of maths : " + marks[3]);
System.out.println(2%10);
}
//2. length of array
//System.out.println("length of array : " + marks.length);
//}
// 3.updation of marks
/*public static void updation(int marks[]) {
    for(int i=0; i<marks.length; i++) {
        marks[i]++;
    }
}
public static void main(String args[]) {
    int marks[] = {93, 94, 99, 90, 95};
    updation(marks);
    for(int i=0; i<marks.length; i++) {
    System.out.print(marks[i] + " ");
    }
}*/
//4. finding the index no. of our key
/*public static int linear_search(int numbers[], int key) {
    for(int i=0; i<numbers.length; i++) {
        if(numbers[i] == key) {
            return i;
        }
    }
    return -1;
}
public static void main(String args[]) {
    int numbers[] = {2,4,6,8,10,12,14,16,18,20};
    int key = 16;
    int index_no = linear_search(numbers, key);
    if(index_no == -1) {
        System.out.print("number not found");
    } else {
       System.out.print("index no " + index_no); 
    }
}*/
//5. largest and smallest no in an array
/*public static int largest(int numbers[]) {
    int larger = Integer.MIN_VALUE;
    for(int i=0; i<numbers.length; i++) {
        if(numbers[i]>larger){
            larger=numbers[i];
        }   
         }
         return larger;
}
public static void main(String args[]) {
   int numbers[] = {23,45,66,55,76,35,65,454,46} ;
   System.out.print("largest no : " + largest(numbers)); 
   
   }*/
   
/*public static int smallest(int numbers[]) {
    int smaller = Integer.MAX_VALUE;
    for(int i=0; i<numbers.length; i++) {
        if(numbers[i]<smaller){
            smaller=numbers[i];
        }   
         }
         return smaller;
}
public static void main(String args[]) {
   int numbers[] = {23,45,66,55,76,35,65,454,46} ;
   System.out.print("smallest no : " + smallest(numbers)); 
   
   }*/
   //finding index no.of our key10 binary search
  /* public static int binary_search(int numbers[], int key) {
    int i=0;
    int j=numbers.length-1;
    while(i<=j) {
        int mid = (i+j)/2;
        if(numbers[mid] == key) {
            return mid;
        }
        if(numbers[mid] > key) {
            j = mid-1;
        } else {
            i = mid+1;
        }
    }
    return -1;
    
   }*/
   //7. reverse array
   /*public static void reverse(int numbers[]) {
    //swap
    int swap = 0, j = numbers.length-1;
    for(int i=0; i<j; i++){
        swap = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = swap;
        j--;
    }
   }*/
    /*int first = 0, last = numbers.length-1;
    while(first<last) {
        int temp = numbers[first];
        numbers[first] = numbers[last];
        numbers[last] = temp;
        first++;
        last--;
    } 
   }*/
   //8. Arrange array in pairs
   /*public static void ArngPairs(int numbers[]) {
    int tp = 0;
    for(int i=0; i<numbers.length; i++) {
        for(int j=i+1; j<numbers.length; j++) {
            System.out.print("(" + numbers[i] + "," + numbers[j] + ")");
            tp++;
        }
        System.out.println();
    }
    System.out.println("total pairs: " + tp);
   }*/
   // 9. print subarrays'
  /*public static void subArrays(int numbers[]) {
    int maxSum = Integer.MIN_VALUE;
    int minSum = Integer.MAX_VALUE;
   
    for(int i=0; i<numbers.length; i++) {
        for(int j=0; j<numbers.length; j++) {
            int sum = 0;
            for(int k=i; k<=j; k++) {
                sum += numbers[k];
                System.out.print(numbers[k] + " ");  
            }
            if(sum!=0) {
            System.out.print("sum of subarray : " + sum);
            
            if(sum>maxSum) {
                maxSum = sum;
            }
            if(sum<minSum) {
                minSum = sum;
            }
            }
            System.out.println();
        }
        System.out.println();
    }
    System.out.println("max sum of array: " + maxSum);
    System.out.println("min sum of array: " + minSum);
   }*/
   //9.prefix array sum
   /*public static void prefixarraymaxsum(int numbers[]) {
    int maxsum = Integer.MIN_VALUE;
    int prefixsum[] = new int [numbers.length];
    prefixsum[0] = numbers[0];
    for(int i=1; i<numbers.length; i++) {
        prefixsum[i] = prefixsum[i-1] + numbers[i];
    }
    int currentsum=0;
    for(int i=0; i<numbers.length; i++) {
        for(int j=i; j<numbers.length; j++) {
            currentsum = i==0 ? prefixsum[j] : prefixsum[j]-prefixsum[i-1];
        }
        if(maxsum<currentsum) {
            maxsum=currentsum;
        }
    }
    System.out.print("maxsum of the subarray: " + maxsum);
   }*/
   //kadane's Algoritm
   /*public static void kadanes(int numbers[]) {
    int cs=0, ms=0;
    for(int i=0; i<numbers.length; i++){
        cs+=numbers[i];
        if(cs<0) {
          cs=0;   
        }
        if(cs>ms) {
            ms=cs;
        }
    }
    System.out.print("the maximum sum of array: " + ms);
   }*/
   //11. trapping rainwater
    /*public static int trappingrw(int height[]) {
        int tw=0;
        int n=height.length;
        int maxleft[] = new int[n];
        int maxright[] = new int[n];
        maxleft[0]=height[0];
        maxright[n-1]=height[n-1];
        for(int i=1; i<n; i++) {
          maxleft[i]=Math.max(height[i], maxleft[i-1]);
        }
        for(int i=n-2; i>=0; i--) {
            maxright[i]=Math.max(height[i], maxright[i+1]);
        }
        for(int i=0; i<n; i++) {
            int waterlevel=Math.min(maxleft[i], maxright[i]);
            int w = waterlevel-height[i];
            tw = tw+w;
        }
        return tw;
    }*/
    
   // height of trapped water 
   /*public static int trapwater(int height[]) {
    int trapwater=0;
    int n = height.length;
    int maxleft[] = new int[n];
    int maxright[] = new int[n];
    maxleft[0] = height[0];
    maxright[n-1] = height[n-1];
    for(int i=1; i<n; i++) {
        maxleft[i] = Math.max(height[i], maxleft[i-1]);
    } 
    for(int i=n-2; i>=0; i--) {
        maxright[i] = Math.max(height[i], maxright[i+1]);
    }
    for(int i=0; i<n; i++) {
        int hw = Math.min(maxleft[i], maxright[i]);
        int h = hw-height[i]; 
        trapwater = trapwater+h;
    }
    return trapwater;
   }
   
   public static void main(String args[]) {
    int height[] = {4, 2, 0, 3, 2, 5};*/
    //int key = 14;
    //System.out.print("binary search key index : " + binary_search(numbers,key) );
    //reverse(numbers);
    
    //for(int i=0; i<numbers.length; i++) {
      //System.out.print(numbers[i] + " ");
   //}
   //System.out.println();
  // ArngPairs(numbers);
  //prefixarraymaxsum(numbers);
  //kadanes(numbers);
 //System.out.print("trapped water: " + trappingrw(height));
 //System.out.print(maxp(prices));
   //System.out.print(trapwater(height));           
   //}
   



}