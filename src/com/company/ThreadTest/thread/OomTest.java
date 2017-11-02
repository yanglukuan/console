package com.company.ThreadTest.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukuanpc on 2017/10/31.
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class OomTest {

    static class OOMObject{
    }
    public static void main(String[] args){
        List<OOMObject>list=new ArrayList<OOMObject>();
        while(true){
            list.add(new OOMObject());
    }
}}
