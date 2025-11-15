import java.io.*;     
import java.util.*;   

class Printer {
    private int number = 1;
    private final int MAX = 15;

    public synchronized void printOdd() {
        while (number <= MAX) {
            while (number % 2 == 0) {
                try { wait(); } catch (Exception e) {}
            }
            if (number <= MAX) {
                System.out.println("Odd Thread: " + number);
                number++;
                notify();
            }
        }
    }

    public synchronized void printEven() {
        while (number <= MAX) {
            while (number % 2 != 0) {
                try { wait(); } catch (Exception e) {}
            }
            if (number <= MAX) {
                System.out.println("Even Thread: " + number);
                number++;
                notify();
            }
        }
    }
}

public class OddEvenThread {
    public static void main(String[] args) {
        Printer p = new Printer();

        Thread t1 = new Thread(() -> p.printOdd());
        Thread t2 = new Thread(() -> p.printEven());

        t1.start();
        t2.start();
    }
}
