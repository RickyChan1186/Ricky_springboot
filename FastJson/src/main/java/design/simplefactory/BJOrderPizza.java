package design.simplefactory;

/**
 * @author ricky
 * @create 2021-01-18 15:12
 */
public class BJOrderPizza extends OrderPizza {


    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
