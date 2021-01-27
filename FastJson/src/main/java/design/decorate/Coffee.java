package design.decorate;

/**
 * @author ricky
 * @create 2021-01-27 15:32
 */
public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
