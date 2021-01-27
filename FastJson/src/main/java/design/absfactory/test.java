package design.absfactory;

/**
 * @author ricky
 * @create 2021-01-18 15:16
 */
public class test {
    public static void main(String[] args) {
        OrderPizza orderPizza = new BJOrderPizza();


        orderPizza = new LDOrderPizza();
        OrderClient orderClient = new OrderClient(orderPizza);
    }
}
