package com.company.interview.collection;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yanglk on 2017/9/8.
 */
public class LinkedListTest {

    public static  void main(String[] args)
    {
        int LIST_SIZE = 10000;
        List<Integer> linkedList=new LinkedList<>();

        linkedList.add(null);
        for (int i = 0; i < LIST_SIZE; i++)
        {

            linkedList.add(i);
        }

        long startTime = System.currentTimeMillis();

        startTime = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++)
        {
           linkedList.get(i);
        }
        System.out.println("LinkedList遍历速度：" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();


        for (Integer ii:linkedList)
        {

            System.out.println(ii);
        }
        System.out.println("LinkedList遍历速度：" + (System.currentTimeMillis() - startTime) + "ms");

    }
}
