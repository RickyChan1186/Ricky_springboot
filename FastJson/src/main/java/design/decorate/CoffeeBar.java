package design.decorate;

/**
 * @author ricky
 * @create 2021-01-27 15:41
 */
public class CoffeeBar {
    public static void main(String[] args) {
        Drink obj = new DeCaf();
        System.out.println("费用1："+obj.cost());
        System.out.println("描述1："+obj.getDes());

        obj = new Chocolate(obj);
        System.out.println("费用2："+obj.cost());
        System.out.println("描述2："+obj.getDes());

        obj = new Chocolate(obj);
        System.out.println("费用3："+obj.cost());
        System.out.println("描述3："+obj.getDes());

    }
}
