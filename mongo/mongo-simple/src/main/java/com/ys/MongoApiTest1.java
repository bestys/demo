package com.ys;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by yuans on 2019/12/11
 **/
public class MongoApiTest1 {
    public static void main(String[] args) {

        //准备使用用户账号连接
        ServerAddress serverAddress = new ServerAddress("172.16.9.216", 27017);
//        MongoClient mongoClient = new MongoClient(serverAddress);

//        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
//        addrs.add(serverAddress);
//
//        //mongodb默认不需要用户名和密码就可以登录
//        //虽然能连接但是后面的操作会报错!还是创建一个吧
//        //数据库必须与用户账号一致,也就是test数据库中创建了用户
//        MongoCredential credential = MongoCredential.createScramSha1Credential("yy",
//                "mydb", "123456".toCharArray());
//        List<MongoCredential> credentials = new ArrayList<>();
//        credentials.add(credential);
//        MongoClient mongoClient = new MongoClient(serverAddress,credentials);
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.maxConnectionIdleTime(60000);//set the max wait time in (ms)
        builder.socketTimeout(60000);
        MongoClientOptions opts = builder.build();

        MongoClient mongoClient = new MongoClient(serverAddress,opts);


//        MongoClient mongoClient = MongoClients.create(
//                MongoClientSettings.builder()
//                        .applyToClusterSettings(builder ->
//                                builder.hosts(Arrays.asList(new ServerAddress("172.16.9.216"))))
//                        .build());

        MongoDatabase db = mongoClient.getDatabase("mydb");
        MongoCollection<Document> myuser = db.getCollection("test");
        Document document = new Document();
        document.put("name","zz");
        document.put("age",21);
        FindIterable<Document> documents = myuser.find();
        System.out.println(documents.cursor().next());

        myuser.insertOne(document);
        mongoClient.close();
        System.out.println("111");
    }
}
