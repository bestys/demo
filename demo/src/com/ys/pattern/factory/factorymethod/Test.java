package com.ys.pattern.factory.factorymethod;

public class Test {
    public static void main(String[] args) {
        MilkFactory factory = new MengniuFactory();
        factory.productMilk();
    }
}
