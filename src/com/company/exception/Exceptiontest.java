package com.company.exception;

/**
 * Created by yanglk on 2017/7/21.
 */
public class Exceptiontest {

    public static int NoException(){
        int i=10;
        try{
            System.out.println("i in try block is"+i);
            return --i;
        }catch(Exception e){
            --i;
            System.out.println("i in catch - form try block is"+i);
            return --i;
        }finally{

            System.out.println("i in finally - from try or catch block is"+i);
            return --i;
        }
    }


    public static void main(String[] args) {
       System.out.print(NoException());
    }

}
