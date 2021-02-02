package design.iterator;

import java.util.Iterator;

/**
 * @author ricky
 * @create 2021-02-02 10:37
 */
public class ComputerCollegeIterator implements Iterator {


    Department[] departments ;
    int position = 0; //遍历的位置

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {

        if(position>departments.length || departments[position] == null){
            return false;
        }else{
            return true;
        }

    }

    @Override
    public Object next() {

        Department department = departments[position];
        position = position + 1;

        return department;
    }

    @Override
    public void remove() {

    }
}
