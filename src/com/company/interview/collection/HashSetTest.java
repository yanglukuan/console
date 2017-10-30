package com.company.interview.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanglk on 2017/9/8.
 */
public class HashSetTest {

    public static void main(String[] args)
    {
        Set<String>  set=new HashSet<>();

        set.add("1");

        set.forEach(m->System.out.println(m));
        for (String s:set)
        {
            System.out.println(s);
        }

    }

}
