package design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ricky
 * @create 2021-02-02 11:03
 */
public class test {

    public static void main(String[] args) {

        List<College> collegeList = new ArrayList<>();

        ComputerCollege computerCollege = new ComputerCollege();

        InfoCollege infoCollege = new InfoCollege();

        collegeList.add(computerCollege);
        collegeList.add(infoCollege);

        OutPutImpl outPutImpl = new OutPutImpl(collegeList);
        outPutImpl.printCollege();

    }
}
