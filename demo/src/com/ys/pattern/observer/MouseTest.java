package com.ys.pattern.observer;

import java.lang.reflect.Method;

public class MouseTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Mouse mouse = new Mouse();
        MouseCallback mouseCallback = new MouseCallback();
        Method method = mouseCallback.getClass().getMethod("click", new Class[]{Event.class});

        mouse.addEvent(EventType.ON_CLICK,mouseCallback,method);
        mouse.click();
    }
}
