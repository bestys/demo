package com.ys.pattern.prototype;

public class ShallowCopy implements Cloneable{

    private String name;
    private String age;
    private OneBean oneBean;

    public ShallowCopy(String name, String age, OneBean oneBean) {
        this.name = name;
        this.age = age;
        this.oneBean = oneBean;
    }

    @Override
    public String toString() {
        return "ShallowCopy{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", oneBean=" + oneBean +
                '}';
    }

    public static void main(String[] args) {
        ShallowCopy yuans = new ShallowCopy("yuans", "18", new OneBean());
        try {
            ShallowCopy copy = (ShallowCopy)yuans.clone();
            System.out.println(yuans);
            System.out.println(copy);
            // 我们发现yuans和copy中oneBean对象是一样的
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
