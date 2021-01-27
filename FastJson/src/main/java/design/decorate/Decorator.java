package design.decorate;

/**
 * @author ricky
 * @create 2021-01-27 15:36
 */
public class Decorator extends Drink {

    private Drink drink;

    public Decorator(Drink drink){
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice()+drink.getPrice();
    }

    public String getDes() {
        // TODO Auto-generated method stub
        return des + " " + getPrice() + " && " + drink.getDes();
    }

}
