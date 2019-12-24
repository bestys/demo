package com.ys.pattern.observer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EventListener {
    private Map<Enum,Event> events = new HashMap<>();

    public EventListener() {}

    public void addEvent(Enum eventType,Object target, Method method){
        events.put(eventType,new Event(eventType.name(),target,method));
    }
    public void trigger(Event e){
        try {
            e.setSource(this);
            e.setTime(new Date());
            e.getMethod().invoke(e.getTarget(),e);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
    public void trigger(Enum eventType){
        if(!events.containsKey(eventType)){return;}
        this.trigger(events.get(eventType));
    }
}
