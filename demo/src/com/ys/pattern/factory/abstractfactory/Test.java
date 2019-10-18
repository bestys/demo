package com.ys.pattern.factory.abstractfactory;

public class Test {
    public static void main(String[] args) {
        AbstractMilkFactory milkFactory = new MilkFactory();
        milkFactory.productMengniuMilk();
        milkFactory.productYiliMilk();
    }
}
