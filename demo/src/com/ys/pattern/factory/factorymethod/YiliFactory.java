package com.ys.pattern.factory.factorymethod;

import com.ys.pattern.factory.Milk;
import com.ys.pattern.factory.YiliMilk;

public class YiliFactory implements MilkFactory{
    @Override
    public Milk productMilk() {
        return new YiliMilk();
    }
}
