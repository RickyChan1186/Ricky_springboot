package design.improve;

/**
 * @author ricky
 * @create 2021-02-02 11:26
 */
//接口, 让 WeatherData 来实现
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
