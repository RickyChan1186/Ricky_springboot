package design.absfactory;

/**
 * @author ricky
 * @create 2021-01-18 15:15
 */
public class LDOrderPizza implements OrderPizza {

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("absfactory method~");
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
