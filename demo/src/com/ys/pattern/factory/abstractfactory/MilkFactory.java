package com.ys.pattern.factory.abstractfactory;

import com.ys.pattern.factory.MengniuMilk;
import com.ys.pattern.factory.Milk;
import com.ys.pattern.factory.YiliMilk;

public class MilkFactory extends AbstractMilkFactory {
    @Override
    public Milk productYiliMilk() {
        return new YiliMilk();
    }

    @Override
    public Milk productMengniuMilk() {
        return new MengniuMilk();
    }
}
