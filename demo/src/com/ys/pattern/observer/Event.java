package com.ys.pattern.observer;

import java.lang.reflect.Method;
import java.util.Date;

public class Event {
    private Object source;
    private Object target;
    private Method method;
    private String trigger;
    private Date time;

    public Event(String trigger,Object target, Method method) {
        this.trigger = trigger;
        this.target = target;
        this.method = method;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", method=" + method +
                ", trigger=" + trigger +
                ", time=" + time +
                '}';
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
