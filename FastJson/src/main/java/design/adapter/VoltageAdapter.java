package design.adapter;

/**
 * @author ricky
 * @create 2021-01-18 17:16
 */
public class VoltageAdapter implements Voltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V){
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        return voltage220V.output220V()/50;
    }
}
