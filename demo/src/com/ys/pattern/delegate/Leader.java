package com.ys.pattern.delegate;

import java.util.HashMap;
import java.util.Map;

public class Leader implements Target {
    private static Map<String, Target> map = new HashMap<>();
    static {
        map.put("写代码",new TargetA());
        map.put("看书",new TargetB());
    }
    @Override
    public void doing(String commend) {
        map.get(commend).doing(commend);
    }
}
