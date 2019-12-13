package com.ys;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.proto.WatcherEvent;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by yuans on 2019/12/12
 **/
public class ZooConnection {
    private static final String hosts= "172.16.9.216";
    private static final int timeout = 3000;

    static ZooKeeper zooKeeper = null;

    public static void getConnection() {
        if(zooKeeper!=null){
            return ;
        }
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            zooKeeper = new ZooKeeper(hosts, timeout, event -> {
                if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
                    System.out.println("zookeeper connected!");
                    countDownLatch.countDown();
                }
                if(Watcher.Event.EventType.NodeCreated == event.getType()){
                    System.out.println(event.getPath() + " had been created!");
                }
            });
            countDownLatch.await();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void close(){
        if(zooKeeper!=null){
            try {
                zooKeeper.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createNode(String path,String data){
        try {
            getConnection();
            zooKeeper.create(path,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static String getNodeData(String path,Stat stat){
        try {
            getConnection();
            byte[] data = zooKeeper.getData(path, event-> {
                    System.out.println("事件被调用:" + event.getType());
            }, stat);

            String result = new String(data,"UTF-8");
            System.out.println(result);
            return result;
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Stat setNodeData(String path,String data, int version){
        try {
            getConnection();
            Stat stat = zooKeeper.setData(path,data.getBytes(),version);
            return stat;
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
//        createNode("/ysTest","测试数据");
        Stat stat = new Stat();
        getNodeData("/ysTest",stat);
        Stat stat1 = setNodeData("/ysTest", "修改数据", stat.getVersion());
        close();
    }
}
