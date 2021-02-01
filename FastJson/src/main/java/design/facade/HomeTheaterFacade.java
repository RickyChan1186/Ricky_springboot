package design.facade;

/**
 * @author ricky
 * @create 2021-01-29 14:22
 */
public class HomeTheaterFacade {
    private DVDplay dvDplay;

    public HomeTheaterFacade(){
        this.dvDplay = DVDplay.getInstance();
    }


    public void play(){
        dvDplay.on();
    }
}
