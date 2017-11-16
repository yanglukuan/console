package com.company.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lukuanpc on 2017/11/10.
 */
public class RabbitMQTest {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");

        Connection connection= factory.newConnection();

        Channel channel=connection.createChannel();

        channel.queueDeclare("Hello",false,false,false,null);


        for(int i=0;i<100;i++) {
            channel.basicPublish("", "Hello", null, ("Hello world"+i).getBytes());
            Thread.sleep(100);
        }

        System.out.println("message send");

        channel.close();

        connection.close();
    }


}
