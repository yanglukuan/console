package com.company.interview;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Stack;

/**
 * Created by yanglk on 2017/8/22.
 */
public class StringTest {


    public static void main(String[] args) {

         //反转字符串
        String teststr="abcdefg";

        char[] arry= teststr.toCharArray();

        char[] arrytemp=new char[arry.length];
        for (int i=0;i<arry.length;i++)
        {
            arrytemp[i]=arry[arry.length-i-1];

        }

        System.out.println(arrytemp);

        for (int i=0;i<arry.length/2;i++)
        {
             char str= ' ';
             str=arry[i];
             arry[i]=arry[arry.length-i-1];
             arry[arry.length-i-1]=str;

        }

        System.out.println(arry);


        Stack stack=new Stack();
        for (char c: arry){
            stack.push(c);
        }

        for (char c: arry){
            System.out.print(stack.pop());
        }


    }

}
