package design.simplefactory;

/**
 * @author ricky
 * @create 2021-01-18 15:05
 */
public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("BJPepperPizza prepare");
    }

    @Override
    public void bake() {
        System.out.println("BJPepperPizza bake");
    }

    @Override
    public void cut() {
        System.out.println("BJPepperPizza cut");
    }
}
