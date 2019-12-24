package com.ys.pattern.single;

import java.io.*;

public class Seriable implements Serializable {
    private static Seriable seriable = new Seriable();
    private Seriable(){}
    public static Seriable instance(){
        return seriable;
    }

    // 实现这个方法。便可防止序列化保持单例
    private Object readResolve(){
        return seriable;
    }
    public static void main(String[] args) {
        Seriable s1 = Seriable.instance();
        Seriable s2 = null;
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Seriable.obj"));
            os.writeObject(s1);
            os.flush();
            os.close();
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Seriable.obj"));
            s2 = (Seriable) is.readObject();
            is.close();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1==s2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
