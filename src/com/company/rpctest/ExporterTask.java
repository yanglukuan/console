package com.company.rpctest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Objects;

/**
 * Created by lukuanpc on 2017/4/26.
 */
public class ExporterTask implements Runnable {
    Socket client =null;

    public  ExporterTask(Socket client)
    {
        this.client=client;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream=null;
        ObjectOutputStream outputStream=null;
        try
        {
            inputStream=new ObjectInputStream(client.getInputStream());
            String interfaceName=inputStream.readUTF();

            Class<?> service=Class.forName(interfaceName);
            String methodName=inputStream.readUTF();
            Class<?>[] parameterTypes=(Class<?>[])inputStream.readObject();
            Object[] arguments=(Object[])inputStream.readObject();
            Method method =service.getMethod(methodName,parameterTypes);
            Object result=method.invoke(service.newInstance(),arguments);
            outputStream=new ObjectOutputStream(client.getOutputStream());
            outputStream.writeObject(result);




        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            if(inputStream!=null)
            {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream!=null)
            {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(client!=null)
            {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
