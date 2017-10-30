package com.company.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yanglk on 2017/7/7.
 */
public class LambdaTest {

    public static void lmTest()
    {
         String[] strs={"7","2","3","4"};

        List<String> strList= Arrays.asList(strs);
        strList.forEach(m->System.out.println(m));

        strList.sort((s1,s2)->s1.compareTo(s2));

        strList.forEach(m->System.out.println(m));


    }


    public static void main(String[] args) {
        lmTest();
    }

}
