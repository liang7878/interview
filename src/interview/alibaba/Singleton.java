package interview.alibaba;

public class Singleton {
    private Object object = new Object();
    private Singleton instance;

    public Singleton() {
    }

    public Singleton getInstance() {
        if(instance == null) {
            synchronized (object) {
                if(instance==null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
