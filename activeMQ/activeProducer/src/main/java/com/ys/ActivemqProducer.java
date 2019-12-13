package com.ys;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

/**
 * created by yuans on 2019/12/9
 **/
public class ActivemqProducer {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "tcp://localhost:61616");
        Connection connection = null;
        try {
            connection =  connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("myQueue");

            MessageProducer producer = session.createProducer(destination);

            TextMessage activeMQTextMessage = new ActiveMQTextMessage();
            activeMQTextMessage.setText("hello,my activeMQ!");
            producer.send(activeMQTextMessage);

            session.commit();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
