package design.Memento;

/**
 * @author ricky
 * @create 2021-02-04 14:23
 */
public class Originator {

    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}
