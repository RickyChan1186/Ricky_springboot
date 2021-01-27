package design.decorate;

/**
 * @author ricky
 * @create 2021-01-27 15:40
 */
public class Chocolate extends Decorator {
    public Chocolate(Drink drink) {
        super(drink);
        setDes("巧克儿");
        setPrice(0.8f);
    }
}
