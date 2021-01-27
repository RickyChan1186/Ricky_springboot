package design.bridge;

/**
 * @author ricky
 * @create 2021-01-18 17:29
 */
public abstract class Phone {

    private Brand brand;

    public Phone(Brand brand){
        this.brand = brand;
    }


    protected void call(){
        this.brand.call();
    }
}
