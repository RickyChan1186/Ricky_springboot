package design.improve;

/**
 * @author ricky
 * @create 2021-02-02 11:25
 */
//观察者接口，有观察者来实现
public interface Observer {

    public void update(float temperature, float pressure, float humidity);
}
