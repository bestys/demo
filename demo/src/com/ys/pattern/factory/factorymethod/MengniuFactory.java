package com.ys.pattern.factory.factorymethod;

import com.ys.pattern.factory.MengniuMilk;
import com.ys.pattern.factory.Milk;

public class MengniuFactory implements MilkFactory{
    @Override
    public Milk productMilk() {
        return new MengniuMilk();
    }
}
