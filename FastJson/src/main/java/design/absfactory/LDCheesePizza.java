package design.absfactory;

/**
 * @author ricky
 * @create 2021-01-18 15:06
 */
public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("LDCheesePizza prepare");
    }

    @Override
    public void bake() {
        System.out.println("LDCheesePizza bake");
    }

    @Override
    public void cut() {
        System.out.println("LDCheesePizza cut");
    }
}
