package design.clone;

import java.io.*;

/**
 * @author ricky
 * @create 2021-01-18 16:11
 */
public class Sheep implements Serializable,Cloneable{
    private String name;
    private int age;

    private Cow cow;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sheep(String name, int age, Cow cow) {
        this.name = name;
        this.age = age;
        this.cow = cow;
    }

    public Cow getCow() {
        return cow;
    }

    public void setCow(Cow cow) {
        this.cow = cow;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cow=" + cow +
                '}';
    }

    @Override
    protected Object clone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis =null;
        ObjectInputStream ois = null;


        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);

            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);

            Sheep sheep = (Sheep)ois.readObject();
            return sheep;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }finally {
            //关闭流
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e2) {
            // TODO: handle exception System.out.println(e2.getMessage());
            }
    }


    }
}
