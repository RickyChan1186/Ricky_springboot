package design.flyweight;

/**
 * @author ricky
 * @create 2021-01-29 14:33
 */
public class ConcreteWebSite extends WebSite {


    private String type = "";

    public ConcreteWebSite(String type){
        this.type = type;

    }


    @Override
    public void user(flyweightuser flyweightuser) {

        System.out.println("website type is :"+type + "用户信息："+flyweightuser.getName());
    }
}
