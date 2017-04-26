package com.company.rpctest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;


/**
 * Created by lukuanpc on 2017/4/26.
 */
public class RpcImporters<T> {
    public T importer(final Class<?> serviceClass , final InetSocketAddress address)
    {
        return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(), serviceClass.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket=null;
                ObjectOutputStream outputStream=null;
                ObjectInputStream inputStream=null;
                try
                {
                    socket=new Socket();
                    socket.connect(address);
                    outputStream=new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeUTF(serviceClass.getName());
                    outputStream.writeUTF(method.getName());
                    outputStream.writeObject(method.getParameterTypes());
                    outputStream.writeObject(args);
                    inputStream=new ObjectInputStream(socket.getInputStream());
                    return inputStream.readObject();
                }finally {
                    if(socket!=null)
                    {
                        socket.close();
                    }
                    if(outputStream!=null)
                    {
                        outputStream.close();
                    }
                    if(inputStream!=null)
                    {
                        inputStream.close();
                    }
                }
            }
        });
    }
}
