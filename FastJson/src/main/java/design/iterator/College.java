package design.iterator;

import java.util.Iterator;

/**
 * @author ricky
 * @create 2021-02-02 10:43
 */
public interface College {

    public String getName();

    //增加系的方法
    public void addDepartment(String name, String desc);


    //返回一个迭代器,遍历
    public Iterator createIterator();

}
