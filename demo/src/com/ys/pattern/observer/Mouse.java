package com.ys.pattern.observer;

public class Mouse extends EventListener{
    public void click(){
        System.out.println("鼠标被点击");
        trigger(EventType.ON_CLICK);
    }
    public void doubleClick(){
        System.out.println("鼠标被双击");
        trigger(EventType.ON_DOUBLE_CLICK);
    }
    public void wheel(){
        System.out.println("鼠标滚轮滚动");
        trigger(EventType.ON_WHEEL);
    }
}
