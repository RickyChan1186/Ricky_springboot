package design.builder;

/**
 * @author ricky
 * @create 2021-01-18 17:00
 */
public class test {
    public static void main(String[] args) {
        HouseBuilder houseBuilder = new HighBuilding();
        HouseDirector houseDirector = new HouseDirector(houseBuilder);
        houseDirector.constructHouse();

        houseDirector.setHouseBuilder(new CommonBuilding());
        houseDirector.constructHouse();


    }
}
