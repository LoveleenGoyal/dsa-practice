import java.io.*;
import java.util.*;

public class QueueUsingStacks {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public static void enqueue(int value) {
        s1.push(value);
    }
    public static int dequeue() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public static void displayElement() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        System.out.println(s2.peek());
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int[] queries = new int[q];
        int value = 0;
        for(int i = 0  ; i < q ; i++) {
            queries[i] = sc.nextInt();
            if(queries[i] == 1) {
                value = sc.nextInt();
                enqueue(value);
            }
            if(queries[i] == 2) {
                dequeue();
            }
            if(queries[i] == 3){
                displayElement();
            }
        }
        sc.close();

    }
}
