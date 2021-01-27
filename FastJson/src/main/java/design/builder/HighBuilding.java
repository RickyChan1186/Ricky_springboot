package design.builder;

/**
 * @author ricky
 * @create 2021-01-18 16:54
 */
public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("HighBuilding buildBasic");
    }

    @Override
    public void buildWalls() {
        System.out.println("HighBuilding buildWalls");

    }

    @Override
    public void roofed() {
        System.out.println("HighBuilding roofed");


    }
}
