package design.absfactory;

/**
 * @author ricky
 * @create 2021-01-18 15:12
 */
public class BJOrderPizza implements OrderPizza{


    @Override
    public Pizza createPizza(String orderType) {

        System.out.println("absfactory method~");
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
