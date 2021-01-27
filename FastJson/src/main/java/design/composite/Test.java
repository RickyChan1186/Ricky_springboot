package design.composite;

/**
 * @author ricky
 * @create 2021-01-27 16:22
 */
public class Test {

    public static void main(String[] args) {


        OrganizationComponent university = new University("吉林大学","吉珠");

        OrganizationComponent college1 = new College("计算机学院","计院");
        OrganizationComponent college2 = new College("工商学院","工院");

        university.add(college1);
        university.add(college2);

        OrganizationComponent jdepartment1 = new Department("计院1班","计院1班");
        OrganizationComponent jdepartment2 = new Department("计院2班","计院2班");


        OrganizationComponent gdepartment3 = new Department("工院1班","工院1班");
        OrganizationComponent gdepartment4 = new Department("工院2班","工院2班");

        college1.add(jdepartment1);
        college1.add(jdepartment2);

        college2.add(gdepartment3);
        college2.add(gdepartment4);

        university.printf();



    }
}
