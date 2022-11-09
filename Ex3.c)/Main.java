import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShadyChoice shadyChoice = new ShadyChoice();
        long startTime = System.nanoTime();
        List<Thread> threads = new ArrayList<Thread>();
        int n;
        n = 15;
        for (int i = 0; i < n; i++) {
            ThreadNou thread = new ThreadNou(shadyChoice);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Durata programului: " + (double) (endTime - startTime) / 1000000000);

    }
}