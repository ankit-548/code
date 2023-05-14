import java.util.Comparator;
import java.util.PriorityQueue;
public class PriorityQueueS {
    public static class Student implements Comparable<Student> {
        int rank;
        String name;
        public Student(String name, int rank) {
           this.rank = rank;
           this.name = name;
        }
        @Override
        public  int compareTo(Student s2) {
            return this.rank-s2.rank;
        }
    }
    public static void main(String args[]) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("ankit", 5));// O(logn)
        pq.add(new Student("sumit", 3));
        pq.add(new Student("vishal", 2));
        pq.add(new Student("deep", 1));
        while(!pq.isEmpty()) {
         System.out.println(pq.peek().name+"<-"+pq.peek().rank);// O(1)
         pq.remove();           // O(logn) 
        }
    }
}