package design.clone;

/**
 * @author ricky
 * @create 2021-01-18 16:13
 */
public class test {
    public static void main(String[] args) {
        Cow cow = new Cow("cow",20);
        Sheep sheep1 = new Sheep("aa",10,cow);
        Sheep sheep2 = (Sheep)sheep1.clone();
        System.out.println(sheep1.toString());
        System.out.println(sheep2.toString());
        System.out.println(sheep1.hashCode());
        System.out.println(sheep2.hashCode());
        System.out.println(sheep1.getCow().hashCode());
        System.out.println(sheep2.getCow().hashCode());

    }
}
