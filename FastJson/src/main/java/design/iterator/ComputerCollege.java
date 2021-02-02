package design.iterator;

import java.util.Iterator;

/**
 * @author ricky
 * @create 2021-02-02 10:44
 */
public class ComputerCollege implements College {


    Department[] departments;
    int numOfDepartment = 0 ;// 保存当前数组的对象个数


    public ComputerCollege() { departments = new Department[5];
        addDepartment("Java 专业", " Java 专业  ");
        addDepartment("PHP 专业", " PHP 专业  ");
        addDepartment("大数据专业", "  大数据专业 ");
    }





    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        departments[numOfDepartment] = new Department(name,desc);
        numOfDepartment = numOfDepartment +1;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
