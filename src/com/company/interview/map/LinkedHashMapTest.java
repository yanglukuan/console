package com.company.interview.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yanglk on 2017/9/4.
 */
public class LinkedHashMapTest {

    public static void main(String[] args)
    {
        Map<String,Integer> map =new LinkedHashMap<>();

        map.put("head语文", 1);
        map.put("数学", 2);
        map.put("英语", 3);
        map.put("历史", 4);
        map.put("政治", 5);
        map.put("地理", 6);
        map.put("生物", 7);
        map.put("化学", 8);


      //  map.forEach((k,v)->System.out.println(k+"--"+v));

      //  map.entrySet().stream().forEach((m)->System.out.println(m.getKey()+"---"+m.getValue()));


        for (Map.Entry<String,Integer> entry :map.entrySet())
        {
            System.out.println(entry.getKey()+"___"+entry.getValue());
        }


    }

}
