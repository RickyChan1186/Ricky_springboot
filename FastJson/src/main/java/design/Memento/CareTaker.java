package design.Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ricky
 * @create 2021-02-04 14:27
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento){
        mementoList.add(memento);
    }


    public Memento get(int index){
        return mementoList.get(index);
    }
}
