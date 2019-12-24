package com.ys.pattern.observer;

public class MouseCallback {
    public void click(Event e){
        System.out.println("触发鼠标点击事件：" + e);
    }
    public void doubleClick(){
        System.out.println("触发鼠标双击事件");
    }
    public void wheel(){
        System.out.println("触发鼠标滚轮事件");
    }
}
