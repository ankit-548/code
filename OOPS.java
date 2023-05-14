/*public class OOPS {
public static void main(String args[]) {
    //Pen p1 = new Pen();
   // p1.setColor("blue");
    //System.out.println(p1.color);
    //p1.setTip(5);
    //p1.tip = 10;
    //System.out.println(p1.tip);
    //p1.color = "yellow";
    //System.out.println(p1.color);
    //BankAccount myAcc = new BankAccount();
    //myAcc.setPassword("abcdefghijklm");
    //System.out.println(myAcc.password);
    /*Pen p2 = new Pen();
    p2.setColor("purple");
    System.out.println(p2.getColor());
    p2.setTip(6);
    System.out.println(p2.getTip());*/
    /*Student s1 = new Student("Ankit");
    System.out.println(s1.name);
    Student s1 = new Student();
    }
    

}
class Pen {
    private String color;
    private int tip;
    String getColor() {
       return this.color;
    } 
    int getTip() {
        return this.tip;
    }
    void setColor(String newColor) {
        this.color =  newColor;
    }
    void setTip(int newTip) {
        this.tip = newTip;
    }

}
class BankAccount {
    public String username;
    public String password;
    protected void setPassword(String pwd) {
        password = pwd;
    }
}
class Student {
    String name;
    int roll;
    //Student(String name) {
    //    this.name = name;
    //}
    Student() {
        System.out.println("Constructor is called");
    }

}*/
/*//copy constructor
public class OOPS {
    public static void main(String args[]) {
        Student s1 = new Student();
        s1.name = "Ankit";
        s1.roll = 161026;
        s1. password = 7828;
        s1.marks[0] = 100;
        s1.marks[1] = 98;
        s1.marks[2] = 96;
        Student s2 = new Student(s1);
        s1.password = 7354;// call by value means s2.password gives 7828
        s1.marks[2] = 99;// call by reference in arrys means s2.marks gives 99 changed value
        System.out.println(s2.marks[2]);
    }
}
class Student {
    int marks[] = new int[3];
    int roll;
    String name;
    int password;
    Student() {
        System.out.println("s1 constructor is called");
    }
    Student(Student s1) {
        //this.marks = s1.marks;  // shallow copy constructor affect in arrays by changing s1
        for(int i=0; i<marks.length; i++) {   // Deep copy constructor does not affect 
            this.marks[i] = s1.marks[i];      //by changing s1
        }
        this.password = s1.password;
        this.name = s1.name;
        this.roll = s1.roll;
        System.out.println("s2 constructor is called");
        }
}*/
//Inheritance
//single level
/*public class OOPS {
    public static void main(String args[]) {
        Fish shark = new Fish();
        shark.eat();
    }
}
class Animal {
    void eat() {
        System.out.println("eats");
    }
}
class Fish extends Animal {

}*/
//method overloading
/*public class OOPS {
    public static void main(String args[]) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(1, 3));
        System.out.println(calc.sum((float)0.2, (float)0.9));
        System.out.println(calc.sum(1, 4, 5));
    }
}
class Calculator {
    int sum(int a, int b) {
        return a+b;
    }
    float sum(float a, float b) {
        return a+b;
    }
    int sum(int a, int b, int c){
        return (a+b+c);
    }
}*/
//method overriding
/*public class OOPS {
    public static void main(String args[]) {
         Animal d = new Animal();
        d.eats();
    }
}
class Animal {
   void eats() {
        System.out.println("eats anything");
    }
}
class Deer {
    void eats() {
        System.out.println("eats grass");
    }
}*/
// abstraction
/*public class OOPS {
    public static void main(String args[]) {
        Horse h = new Horse();
        h.eat();
        h.walk();
        Chicken c = new Chicken();
        c.eat();
        c.walk();    
        h.changeColor();    
    }
}
abstract class Animal {
    String color;
    Animal() {
        color = "dark brown";
    }
    void eat() {
        System.out.println("animal eats");
    }
    abstract void walk();
}
class Horse extends Animal {
    void changeColor() {
        System.out.println("white");
         }
    void walk() {
        System.out.println("walks on 4 legs");
    }
}
class Chicken extends Animal {
    void walk() {
        System.out.println("walks on 2 legs");
    }
}*/
// interfaces
/*public class OOPS {
    public static void main(String args[]) {
        Queen q = new Queen();
        q.moves();
        Bear b = new Bear();
        b.eat();
    }
}
interface ChessPlayer {
    void moves();
}
class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("in all 4 directios");
    }
}
class king implements ChessPlayer {
    public void moves() {
        System.out.println("single step in all direction");
    }
}
class rook implements ChessPlayer {
     public void moves() {
        System.out.println("Horizontal and vertical direction");
    } 
}
interface Herbivores {
    void eat();
}
interface Carnivores {
    void eat();
}
class Bear implements Herbivores, Carnivores {
    public void eat() {
        System.out.println("eat everything");
    }
}*/
//   Static keyword
/*public class OOPS {
    public static void main(String args[]) {
        Student s1 = new Student();
        s1.school = "rkvm";
        Student s2 = new Student();
        s1.school = "MITS";
        System.out.println(s1.school);
    }
}
class Student {
    String name;
    int roll;
    static String school;
}*/
/*public class OOPS {
    public static void main(String args[]) {
        Horse h = new Horse();
        System.out.println(h.color);
        }
}
class Animal {
    String color;
    Animal() {
       System.out.println("Animal constructor is called");
    }
}
class Horse extends Animal {
    Horse() {
        //super();
        super.color = "white";
        System.out.println("Horse constructor is called");
    }
}*/
/*import java.util.*;
class Complex {
    int real;
    int imag;
    public Complex(int r, int i) {
        real = r;
        imag = i;
    }
    public static Complex add(Complex a, Complex b) {
        return new Complex((a.real+b.real), (a.imag+b.imag));
    }
    public static Complex diff(Complex a, Complex b) {
        return new Complex((a.real-b.real), (a.imag-b.imag));
    }
    public static Complex product(Complex a, Complex b) {
        return new Complex(((a.real*b.real)-(a.imag*b.imag)), ((a.real*b.imag)+(a.imag*b.real)));
    }
    public void printComplex() {
        if(real == 0 && imag!=0) {
            System.out.println(imag+"i");
        } else if(imag == 0 && real!=0) {
            System.out.println(real);
        } else {
            System.out.println(real+"+"+imag+"i");
        }
    }
}
public class OOPS {

    public static void main(String[] args) {
        Complex c = new Complex(4, 5);
        Complex d = new Complex(9, 4);
        Complex e = Complex.add(c, d);
        Complex f = Complex.diff(c, d);
        Complex g = Complex.product(c, d);
        e.printComplex();
        f.printComplex();
        g.printComplex();
    }
}*/
  /*public class OOPS {
    public static class Animal {
        String color; 
        Animal() {
            System.out.println("Animal constructor is called");
        }
    }
    public static class Horse extends Animal {
        Horse() {
            super();
            color == "brown";
            System.out.println("Horse constructor is called");
        }
    }
    public static void main(String args[]) {
        Horse h = new Horse();

        System.out.println(h.color);
    }
  }*/
  public class OOPS {
        public static class Book {
            int price;  static int count;
            public Book(int price) {
                this.price = price;
                count++;
            }
        }
    
        public static void main(String args[]) {
            //System.out.println(Book.count);
            System.out.println(Book.count);
            Book b1 = new Book(100);
            System.out.println(Book.count);
            Book b2 = new Book(4-5);
            System.out.println(Book.count);
            //System.out.println(Book.count);
        }
  }


