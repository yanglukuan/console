package com.company.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lukuanpc on 2017/11/11.
 */
public class RabbitRecive {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("127.0.0.1");

        Connection connection=factory.newConnection();

        Channel channel=connection.createChannel();

        channel.queueDeclare("Hello",false,false,false,null);

        System.out.println("recive....");


        QueueingConsumer consumer=new QueueingConsumer(channel);

        channel.basicConsume("Hello",true,consumer);



        while (true){

            QueueingConsumer.Delivery delivery=consumer.nextDelivery();
            String message=new String (delivery.getBody());
            System.out.println(message);

        }



    }


}
