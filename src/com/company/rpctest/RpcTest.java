package com.company.rpctest;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by lukuanpc on 2017/4/26.
 */
public class RpcTest {

    public static void runRpc()
    {
        new Thread (new Runnable(){

            @Override
            public void run() {
                try {
                    RpcFrameWork.exporter("localhost",8888);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        RpcImporters<EchoService> importers=new RpcImporters<>();
        EchoService echo=importers.importer(EchoServiceImpl.class,new InetSocketAddress("localhost",8888));
        System.out.println(echo.echo(" Are you Ok?"));
    }





}
