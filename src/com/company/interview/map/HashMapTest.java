package com.company.interview.map;

import com.company.model.PersonModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanglk on 2017/8/25.
 */
public class HashMapTest {


    public static void main(String[] args) {


        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("语文", 1);
        map.put("数学", 2);
        map.put("英语", 3);
        map.put("历史", 4);
        map.put("政治", 5);
        map.put("地理", 6);
        map.put("生物", 7);
        map.put("化学", 8);
        map.get("化学");
        for(Map.Entry<String,Integer> entry:map.entrySet())
        {
            System.out.println(entry.getValue());
        }
        System.out.println(map);


        HashMap<PersonModel,String> mapp=new HashMap<>();

        PersonModel p=new PersonModel();
        p.setId(1);

        PersonModel p2=new PersonModel();
        p2.setId(2);

        mapp.put(p,"123");
        mapp.put(p2,"23424");

        //mapp的siaze=2
        //p和p2 是两个对象 hashcode不同 所以会是两个
        System.out.println(mapp.size());


        HashMap<String,String> mappp=new HashMap<>();
        mappp.put("key1","1");
        mappp.put("key1","2");

        //mappp的siaze=1
        //key1的 hashcode相同 所以会是一个
        // 利用此特性 可自动去重
        if(mappp.containsKey("key1"))
        {
            System.out.println("hase key");
        }
        else
        {
            System.out.println("hase null key");
        }



        //值可重复 可以为null
        HashMap<String,String> mapppp=new HashMap<>();
        mapppp.put("key1","1");
        mapppp.put("key2","3");
        mapppp.put("key3","4");
        mapppp.put("key4","4");
        mapppp.put("key5","6");
        mapppp.put("key6","7");
        mapppp.put("key7",null);

        //遍历
        for (Map.Entry<String,String> entry :mapppp.entrySet())
        {
            if(entry.getValue()!=null) {
                System.out.println(entry.getValue());
            }
        }

    }

}
