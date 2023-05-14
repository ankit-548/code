public class BitManipulation {
    // 1. odd/even number
    public static void oddeven(int n) {
        int bitmask = 1;
        if((n & bitmask) == 0) {
            System.out.println("even number");
        } else {
            System.out.println("odd number");
        }
    }
    // 2. get ith bit 
    public static int getithbit(int n, int i)  {
        int bitmask = 1<<i;
        if((n & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
       
    }
    //set ith bit
    public static int setithbit(int n, int i) {
        int bitmask = 1<<i;
        return n|bitmask;
    }
    //clear ith bit
    public static int clearithbit(int n, int i) {
        int bitMask =  ~(1<<i);
        return n & bitMask;
    }
    // update ith bit
    public static int UpdateithBit(int n, int i, int newBit) {
        /*if(newBit == 0) {
            return clearithbit(n, i);
        } else {
            return setithbit(n, i);
        }*/
         n = clearithbit(n, i);
         int bitMass = newBit<<i;
         return n | bitMass;

    }
    public static int clearRangebits(int n, int i, int j) {
        int a = (~0)<<j+1;
        int b = (1<<i)-1;
        return n & (a|b);
    }
    // 7. check if a number is power of 2
    public static boolean IspowTwo(int n) {
       return ((n &(n-1)) == 0);
    }
    // count setbits in a number
    public static int CountSet(int n) {
        int count = 0;
        while(n>0) {
            if((n & 1) != 0) {
            count++;
        } 
            n = n>>1;
        }
        return count;
    } 
    // 9. Fast Exponentiation
    public static double FastExp(double a, int n) {
        double Ans = 1;
        boolean isNeg = n<0 ? true : false;
        n = Math.abs(n);
        if(!isNeg) {
            while(n > 0) {
                if((n & 1) != 0) {
                    Ans*=a;
                } 
                    a*=a;
                    n = n>>1;
            }
        } else {
            while(n > 0) {
                if((n & 1) != 0) {
                    Ans/=a;
                } 
                    a*=a;
                    n = n>>1;
            }
        }
        return Ans;     
    }
    // 10. Modular exponentiation
    public static int modexp(int x, int y, int m) {
        int ans = 1;
        while(y>0) {
            if((y&1) != 0) {
              ans = (ans * x)%m;
            }
            x = (x*x)%m;
            y = y>>1;
        }
        return ans;
    }

    public static void main(String args[]) {
        //oddeven(5);
        //oddeven(16);
        //System.out.println(getithbit(9, 1));
        //System.out.print(getithbit(9, 2));
        //System.out.print(UpdateithBit(10, 1, 2));
        //System.out.print(clearRangebits(2523, 2, 7));
        //System.out.print(IspowTwo(32));
        //System.out.print(CountSet(5));
        // System.out.print(FastExp(2, -2));
       // System.out.print(-(~(-19)));
       //upper case to lower case
     //char ch = 'Q';
        //System.out.print((char)(ch | ' '));
        //System.out.print(modexp(999, 5, 6));
        // char ch = 'A';
        // System.out.print((char)(ch | ' '));
        System.out.print(Math.pow(-1, Integer.MIN_VALUE));
        byte x, y;  
        x=10;  
        y=-10;  
        System.out.println("Bitwise Left Shift: y>>2 = "+(y>>2));  
        System.out.println("Bitwise Right Shift: x>>2 = "+(x>>2));  
        System.out.println("Bitwise Zero Fill Right Shift: x>>>2 = "+(x>>>2));  
        System.out.println("Bitwise Zero Fill Right Shift: y>>>2 = "+(y>>>2));  
}
}
