package com.company.rpctest;

/**
 * Created by lukuanpc on 2017/4/26.
 */
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String ping) {
        return ping!=null?ping+" --> I am OK.":" I am OK.";
    }
}
