public class ThreadNou extends Thread{
    ShadyChoice shadyChoice;
    ThreadNou(ShadyChoice shadyChoice){
        this.shadyChoice = shadyChoice;
    }
    public void run(){
        System.out.println(shadyChoice.choose() + ' ' + ThreadId.get());
        }
}
