public class Bucatar extends Thread {
    private Portii sharedContor;
    private int m;

    public Bucatar(Portii sharedContor, int m) {
        this.sharedContor = sharedContor;
        this.m = m;
    }

    @Override
    public void run() {
        int ok = 0;
        while (ok == 0) {
            if (sharedContor.getCounter() == 0) {
                sharedContor.fill();
                System.out.println("Bucatarul a umplut portiile");
            }
            if (sharedContor.getnrportiiservite() == m) {
                ok = 1;
            }
        }
    }
}