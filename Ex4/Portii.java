public class Portii {
    public volatile int contor;
    public int n;
    public int nrportiiservite;

    public Portii(int n) {
        this.contor = 0;
        this.n = n;
        this.nrportiiservite = 0;
    }

    public void eat() {
        contor--;
        this.nrportiiservite++;
    }

    public int getCounter() {
        return contor;
    }

    public void fill() {
        contor = this.n;
    }

    public int getnrportiiservite() {
        return nrportiiservite;
    }

}
