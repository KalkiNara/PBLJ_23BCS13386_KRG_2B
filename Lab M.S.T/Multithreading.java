class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

class SquareThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Square of " + i + ": " + (i * i));
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

public class MultithreadingExample {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread();
        SquareThread t2 = new SquareThread();

        t1.start(); 
        t2.start(); 
}
