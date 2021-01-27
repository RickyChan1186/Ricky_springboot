package design.composite;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ricky
 * @create 2021-01-27 16:13
 */
public class College extends OrganizationComponent {


    List<OrganizationComponent> organizationComponentList = new ArrayList<>();

    public College(String name, String des) {
        super(name, des);
    }


    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponentList.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponentList.remove(organizationComponent);
    }


    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    protected void printf() {
        System.out.println("--------------" + getName() + "--------------");
        for(OrganizationComponent organizationComponent:organizationComponentList){
            organizationComponent.printf();
        }

    }
}
