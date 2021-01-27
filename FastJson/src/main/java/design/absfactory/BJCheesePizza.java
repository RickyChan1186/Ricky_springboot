package design.absfactory;

/**
 * @author ricky
 * @create 2021-01-18 15:03
 */
public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("BJCheesePizza prepare");
    }

    @Override
    public void bake() {
        System.out.println("BJCheesePizza bake");
    }

    @Override
    public void cut() {
        System.out.println("BJCheesePizza cut");

    }
}
