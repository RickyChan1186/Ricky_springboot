package design.flyweight;

import java.util.HashMap;

/**
 * @author ricky
 * @create 2021-01-29 14:35
 */
public class WebSiteFactory {

    private HashMap<String,WebSite> pool = new HashMap<>();

    public WebSite getWebSiteCategory(String type){
        if(!pool.containsKey(type)){
            pool.put(type,new ConcreteWebSite(type));
        }

        return (WebSite) pool.get(type);

    }

    public int getNumber(){
        return pool.size();
    }
}
