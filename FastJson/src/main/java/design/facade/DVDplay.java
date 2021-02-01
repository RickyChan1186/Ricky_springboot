package design.facade;

/**
 * @author ricky
 * @create 2021-01-29 14:19
 */
public class DVDplay {

    public static final DVDplay instance  = new DVDplay();

    public static DVDplay getInstance(){

        return instance;
    }


    public void on(){
        System.out.println("DVAplay on ");
    }
}
