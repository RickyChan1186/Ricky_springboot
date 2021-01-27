package design.adapter;

/**
 * @author ricky
 * @create 2021-01-18 17:18
 */
public class Phone {
    public void chargeing(Voltage5V voltage5V){
        if(voltage5V.output5V()<5){
            System.out.println("less than 5V");
        }else{
            System.out.println("more than 5V");
        }

    }
}
