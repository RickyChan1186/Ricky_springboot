package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author ricky
 * @create 2020-03-19 9:28
 */
public class test01 {

    public static void main(String[] args) {
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("13726261186");
        phoneNumbers.add("13726261186");
        phoneNumbers.add("13726261188");
        phoneNumbers.add("13726261189");
        phoneNumbers.add("13726261188");

        List<String> phoneList = new ArrayList<>(new HashSet<>(phoneNumbers));
        System.out.println(phoneList.toString());
    }
}
