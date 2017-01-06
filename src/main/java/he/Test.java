package he;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Test extends Thread {
    public synchronized void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("i::"+i);
        }
    }

    public static void main(String[] args) {
        Test obj = new Test();

        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        Thread t3 = new Thread(obj);

        t1.start();
        t2.start();
        t3.start();
    }
}