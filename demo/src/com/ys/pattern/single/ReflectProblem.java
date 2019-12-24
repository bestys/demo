package com.ys.pattern.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectProblem {
    public static void main(String[] args) {
        Class<?> clazz = Lazy.class;
        try {
            Constructor constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            System.out.println(constructor.newInstance());
            System.out.println(constructor.newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
