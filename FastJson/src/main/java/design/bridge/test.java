package design.bridge;

/**
 * @author ricky
 * @create 2021-01-18 17:33
 */
public class test {
    public static void main(String[] args) {
        Phone phone = new FolePhone(new xiaomi());
        phone.call();

        phone = new FolePhone(new vivo());
    }
}
