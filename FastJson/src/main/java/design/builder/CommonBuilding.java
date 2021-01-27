package design.builder;

/**
 * @author ricky
 * @create 2021-01-18 17:03
 */
public class CommonBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("CommonBuilding buildBasic");
    }

    @Override
    public void buildWalls() {
        System.out.println("CommonBuilding buildWalls");

    }

    @Override
    public void roofed() {
        System.out.println("CommonBuilding roofed");


    }
}
