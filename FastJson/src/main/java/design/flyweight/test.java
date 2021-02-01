package design.flyweight;

/**
 * @author ricky
 * @create 2021-01-29 14:40
 */
public class test {
    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();

        WebSite webSite1 = webSiteFactory.getWebSiteCategory("新闻");
        webSite1.user(new flyweightuser("aa"));
        System.out.println("连接池数量："+  webSiteFactory.getNumber());


        WebSite webSite2 = webSiteFactory.getWebSiteCategory("综艺");
        webSite2.user(new flyweightuser("aa"));
        System.out.println("连接池数量："+  webSiteFactory.getNumber());


    }
}
