package design.simplefactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ricky
 * @create 2021-01-18 15:07
 */
public abstract class OrderPizza {

    abstract Pizza createPizza(String orderType);

    public OrderPizza(){
        Pizza pizza = null;
        String orderType = null;
        do{
            orderType = getType();
            pizza = createPizza(orderType);

            pizza.prepare();
            pizza.bake();
            pizza.cut();
        }while (true);
    }



    private String getType() { try {
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in)); System.out.println("input pizza 种类:");
        String str = strin.readLine();
        return str;
    } catch (IOException e) { e.printStackTrace(); return "";
    }
    }

}
