package com.company;

import com.company.rpctest.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //System.out.println("sdsd");
       RpcTest.runRpc();

//        new Thread (new Runnable(){
//
//            @Override
//            public void run() {
//                try {
//                    RpcFrameWork.exporter("localhost",8888);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//
//        RpcImporters<EchoService> importers=new RpcImporters<>();
//        EchoService echo=importers.importer(EchoServiceImpl.class,new InetSocketAddress("localhost",8888));
//       System.out.print(echo.echo("Are you Ok?"));
    }
}
