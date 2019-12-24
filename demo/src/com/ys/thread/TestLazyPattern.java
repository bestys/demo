package com.ys.thread;

public class TestLazyPattern {

    private static TestLazyPattern testLazyPattern;
    private TestLazyPattern(){}
    public static TestLazyPattern instance(){
        if(testLazyPattern==null){
            synchronized (TestLazyPattern.class){
                if(testLazyPattern==null){
                    testLazyPattern = new TestLazyPattern();
                }
            }
        }
        return testLazyPattern;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                System.out.println(TestLazyPattern.instance());
            }).start();
        }
    }
}
