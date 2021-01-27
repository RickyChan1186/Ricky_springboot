package design.decorate;

/**
 * @author ricky
 * @create 2021-01-27 15:30
 */
public abstract class Drink {

    String des;
    float price = 0.0f;


    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public abstract float cost();
}
