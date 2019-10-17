package com.ys.pattern.factory.simplefactory;

public class Test {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        System.out.println(simpleFactory.productMilk("伊利"));
    }
}
