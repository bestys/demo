package com.ys.pattern.single;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Registry {
    private static Map<String,Registry> map = new ConcurrentHashMap<>();
    static {
        Registry registry = new Registry();
        map.put(registry.getClass().getName(),registry);
    }
    private Registry(){

    }
    // 这里的线程安全如何保证
    public static Registry instance(String name){
        if (name==null) {
            name = Registry.class.getName();
        }
        if(map.get(name) == null){
            try {
                map.put(name,(Registry) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
}
