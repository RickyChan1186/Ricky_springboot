package design.iterator;


import java.util.Iterator;
import java.util.List;

/**
 * @author ricky
 * @create 2021-02-02 10:48
 */
public class InfoCollegeIterator implements Iterator {


    List<Department> departmentList ;

    int index = -1;


    public InfoCollegeIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public boolean hasNext() {
        if(index>=departmentList.size()-1){
            return false;
        }else{
            index = index + 1;
            return true;
        }

    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }

    @Override
    public void remove() {

    }
}
