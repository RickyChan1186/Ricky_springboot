package design.composite;

/**
 * @author ricky
 * @create 2021-01-27 16:11
 */
public class Department extends OrganizationComponent{
    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    protected void printf() {
        System.out.println(this.getName());
    }
}
