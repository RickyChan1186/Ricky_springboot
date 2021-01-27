package design.singleton;

/**
 * @author ricky
 * @create 2021-01-18 14:36
 */
public class Singleton {
    public Singleton(){}

    private static class SingletonInstance{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonInstance.instance;
    }
}
