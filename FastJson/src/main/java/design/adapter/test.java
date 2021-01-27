package design.adapter;

/**
 * @author ricky
 * @create 2021-01-18 17:20
 */
public class test {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.chargeing(new VoltageAdapter(new Voltage220V()));
    }
}
