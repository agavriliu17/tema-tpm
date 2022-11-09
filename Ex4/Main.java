import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        int n = 4;
        int m = 14;
        Portii portii = new Portii(n);
        List<Thread> threads = new ArrayList<>();
        threads.add(new Bucatar(portii, m));
        for (int i = 0; i < m; i++) {
            threads.add(new Salbatic(portii, reentrantLock));

        }


        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

    }

}