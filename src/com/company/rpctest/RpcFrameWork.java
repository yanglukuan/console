package com.company.rpctest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by lukuanpc on 2017/4/26.
 */
public class RpcFrameWork {

    static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(String hostName,int port) throws IOException {
        ServerSocket serverSocket=new ServerSocket();
        serverSocket.bind(new InetSocketAddress(hostName,port));

        try
        {
            while (true)
            {
                executor.execute(new ExporterTask(serverSocket.accept()));
            }
        }
        finally {
            serverSocket.close();
        }
    }




}
