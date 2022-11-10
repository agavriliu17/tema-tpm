public class ThreadId {
    private static volatile int nextId = 0;
    private static ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId++;
        }
    };

    public static int get() {
        return threadId.get();
    }
}
