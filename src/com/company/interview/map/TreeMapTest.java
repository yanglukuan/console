package com.company.interview.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yanglk on 2017/9/5.
 */
public class TreeMapTest {

    public static void main(String[] args)
    {
        Map<Integer,Integer> map =new TreeMap<>(Integer::compareTo);

        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
        map.put(8, 8);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(11, null);
        map.put(12, null);
        map.put(null, 123);
        for (Map.Entry<Integer,Integer> entry :map.entrySet())
        {
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }

    }
}
