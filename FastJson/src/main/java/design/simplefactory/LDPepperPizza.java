package design.simplefactory;

/**
 * @author ricky
 * @create 2021-01-18 15:06
 */
public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("LDPepperPizza prepare");
    }

    @Override
    public void bake() {
        System.out.println("LDPepperPizza bake");
    }

    @Override
    public void cut() {
        System.out.println("LDPepperPizza cut");
    }
}
