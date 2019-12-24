package com.ys.pattern.prototype;

import java.io.*;

public class DeepCopy implements Cloneable,Serializable{
    private String name;
    private String age;
    private OneBean oneBean;

    public DeepCopy(String name, String age, OneBean oneBean) {
        this.name = name;
        this.age = age;
        this.oneBean = oneBean;
    }

    @Override
    public String toString() {
        return "this{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", oneBean=" + oneBean +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return deepClone();
    }

    private Object deepClone(){
        try {
            ByteArrayOutputStream byteArr = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(byteArr);
            os.writeObject(this);
            ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(byteArr.toByteArray()));
            return is.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        DeepCopy yuans = new DeepCopy("yuans", "19", new OneBean());
        try {
            DeepCopy copy = (DeepCopy)yuans.clone();
            System.out.println(yuans);
            System.out.println(copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
