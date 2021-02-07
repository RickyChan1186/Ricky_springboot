package design.improve;

/**
 * @author ricky
 * @create 2021-02-02 11:35
 */
public class test {

    public static void main(String[] args) {
        //创建一个 WeatherData
        WeatherData weatherData = new WeatherData();

        //创建观察者
        CurrentConditions currentConditions = new CurrentConditions();

        weatherData.registerObserver(currentConditions);

        // 测 试
        System.out.println("通知各个注册的观察者, 看看信息");
        weatherData.setData(10f, 100f, 30.3f);


    }
}
