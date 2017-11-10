package com.company.redis;

import com.company.model.PersonModel;
import org.codehaus.jackson.map.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanglk on 2017/11/10.
 */
public class RedisTest {

    public static void main(String[] args) throws InterruptedException, IOException {

        //建立连接
        Jedis read=new Jedis("127.0.0.1", 6379);

        //检查服务是否正常  正常返回PONG
        System.out.println("健康监测："+read.ping());

        //设置值 字符串
        read.set("test", "这是一个测试字符串");

        //根据key取值 字符串
        String str=read.get("test");
        System.out.println("测试取值："+str);

        //判断key是否存在
        System.out.println("test 存在："+read.exists("test"));//存在
        System.out.println("test2不存在："+read.exists("test2"));//不存在

        //获取key 类型
        System.out.println("key 类型:"+read.type("test"));

        //设置 key “test” 秒钟过期
        read.expire("test",3);

        //休眠5秒钟
        Thread.sleep(1000);
        //未过期
        System.out.println("设置key10秒钟过期，未过期："+read.get("test"));

        //再次休眠5秒钟
        Thread.sleep(2000);
        //已过期
        System.out.println("设置key10秒钟过期，已过期："+read.get("test"));


        PersonModel model =new PersonModel();

        List<PersonModel> models=new ArrayList<>();

        model.setId(1);
        model.setAge(Integer.valueOf(12));
        model.setName("测试1");

        models.add(model);

        ObjectMapper obj =new ObjectMapper();
        String strPerson=  obj.writeValueAsString(models);

        read.set("person",strPerson);

        System.out.println(read.get("person"));




    }

}
