package design.absfactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ricky
 * @create 2021-01-18 15:48
 */
public class OrderClient {

    OrderPizza orderPizza;

    public OrderClient(OrderPizza orderPizza){
        setFactory(orderPizza);
    }


    private void setFactory(OrderPizza orderPizza){
        Pizza pizza = null;
        String orderType = "";
        this.orderPizza = orderPizza;
        do{
            orderType = getType();
            pizza = orderPizza.createPizza(orderType);

            if(pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
            }else{
                System.out.println("error pizza is not exist");
                break;
            }

        }while(true);

    }




    // 写一个方法，可以获取客户希望订购的披萨种类
    private String getType() { try {
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in)); System.out.println("input pizza 种类:");
        String str = strin.readLine();
        return str;
    } catch (IOException e) { e.printStackTrace(); return "";
    }
    }

}
