import java.util.concurrent.locks.ReentrantLock;

public class Salbatic extends Thread {
    private Portii sharedContor;
    private ReentrantLock reentrantLock;

    public Salbatic(Portii sharedContor, ReentrantLock reentrantLock) {
        this.sharedContor = sharedContor;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        reentrantLock.lock();
        //Fiecare salbatic sa manance o portie daca exista, altfel sa astepte ca bucatarul sa o umple
        while (true) {
            if (sharedContor.getCounter() > 0) {
                sharedContor.eat();
                System.out.println("Salbaticul a mancat o portie");
                System.out.println("Portii ramase: " + sharedContor.getCounter());
                break;
            }

        }

        reentrantLock.unlock();


    }
}
