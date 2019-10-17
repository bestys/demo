package com.ys.pattern.factory.simplefactory;

import com.ys.pattern.factory.MengniuMilk;
import com.ys.pattern.factory.Milk;
import com.ys.pattern.factory.YiliMilk;

public class SimpleFactory {

    public Milk productMilk(String name){
        Milk milk = null;
        switch (name) {
            case "蒙牛":
                milk = new MengniuMilk();
                break;
            case "伊利":
                milk = new YiliMilk();
                break;
                default:
                    break;
        }
        return milk;
    }

}
