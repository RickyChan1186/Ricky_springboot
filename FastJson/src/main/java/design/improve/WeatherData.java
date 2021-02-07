package design.improve;

import java.util.ArrayList;

/**
 * @author ricky
 * @create 2021-02-02 11:30
 */
public class WeatherData implements Subject {


    private float temperatrue;
    private float pressure;
    private float humidity;
    //观察者集合
    private ArrayList<Observer> observers;


    public WeatherData() {
        observers = new ArrayList<Observer>();
    }


    public float getTemperatrue() {
        return temperatrue;
    }

    public void setTemperatrue(float temperatrue) {
        this.temperatrue = temperatrue;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(observers.contains(o)) {
            observers.remove(o);
        }

    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this.temperatrue, this.pressure, this.humidity);
        }

    }



    //当数据有更新时，就调用 setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperatrue = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //调用 dataChange， 将最新的信息 推送给 接入方 currentConditions
        dataChange();
    }

    public void dataChange() {
        notifyObservers();
    }

}
