package design.bridge;

/**
 * @author ricky
 * @create 2021-01-18 17:32
 */
public class FolePhone extends Phone {
    public FolePhone(Brand brand) {
        super(brand);
    }
    public void call(){
        super.call();
        System.out.println("FolePhone call");
    }
}
