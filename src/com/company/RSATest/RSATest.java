package com.company.RSATest;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by yanglk on 2017/7/26.
 */
public class RSATest {
    private static  String prikey ="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMRlCre/bE1lUbwe"+
            "FcttbdEb+xrTPBQwq72sPEotrLbiwUM6ZAF7Y9UOCfQV1DPIbfeTHkh/8xQMtEY0"+
            "gyWBtDXtoRlN+88ChDXhnSETBui85qvGxp4YbOpdWKQtMwNMoV0WvgUXckN7fhO8"+
            "WIqXDa5P4wpzbnUGY1vnc1rYA0nrAgMBAAECgYEAiEQTS6rl2k2SiJPXS26B47Um"+
            "ZVZrORcMEm6O5mkKjVqH/b1l5iFXA1zaSyFaOxO2OTE6sdMVNbQa4RtOY5e7EPjH"+
            "007PMAqdPuGqfwbO7tmKmbmhGoFf/vmIxgzzj66AqlQl8q/dcCN91+H0fgkHZRvA"+
            "EI86w4fo+A0t1XrtYAECQQDgZW6u1HkbetPGO3zPoGWISgFVHsO/u6sqFRHUjINy"+
            "M3R4ez2D/LWHyhV2B5+6My/srrH9sFzn+8jvZ+uvVbGBAkEA4A4E7pZ/X3xEv3Mc"+
            "3p2EmVr7ISfUYywcSWEekIjK91ecHYnm+vUapcwo+PXCV4IjZEGbklLL5fIdBeIp"+
            "7hyZawJAeyVvTqbwJ7KKkhmHb3J5BgiHHq2Zg5l8X8XcWScb5Ap0+sG3ir2e6fxv"+
            "Nq0MbWU2AdAFglHNSsqVBT2kzD5dAQJAX9g/bdy9YhhjxE425FgXuA5+bSF/rmjZ"+
    "NN6x13xc7s/wfYZXY7VkD9a1FEL1Pr/x6dpS9ZYrmRMoLTMhYrWjPwJBAMxKkNyt"+
    "jAwOoRoR7kGrd+ZjGExhFSWx7gB5mC+qNyYMrWOG8JoCST/FTOPRuRDylQ5p05uK"+
    "vMoML12/S7yRNKo=";

    private static String pubkey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDEZQq3v2xNZVG8HhXLbW3RG/sa0zwUMKu9rDxKLay24sFDOmQBe2PVDgn0FdQzyG33kx5If/MUDLRGNIMlgbQ17aEZTfvPAoQ14Z0hEwbovOarxsaeGGzqXVikLTMDTKFdFr4FF3JDe34TvFiKlw2uT+MKc251BmNb53Na2ANJ6wIDAQAB";


    /**
     * verify
     *
     * @param publicKeyStr publickey base64
     * @param sign
     * @param content
     * @return
     */
    public static boolean verify(String publicKeyStr, byte[] sign, byte[] content) {
        if (publicKeyStr == null || publicKeyStr.length() == 0) {
            throw new RuntimeException("publickey is empty.");
        }
        if (sign == null || content == null) {
            return false;
        }
        RSAPublicKey publicKey = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(java.util.Base64.getDecoder().decode(publicKeyStr)));
        } catch (Exception e) {
            throw new RuntimeException("init public key failed!", e);
        }
        boolean isOk = false;
        try {
            Signature signature = Signature.getInstance("MD5WithRSA");
            signature.initVerify(publicKey);
            signature.update(content);
            isOk = signature.verify(sign);
        } catch (Exception e) {
          //  logger.error("rsa verify failed.", e);
        }
        return isOk;
    }

    /**
     * sign
     *
     * @param privateKeyStr privatekey base64
     * @param content
     * @return
     */
    public static String sign(String privateKeyStr, byte[] content) {
        if (privateKeyStr == null || privateKeyStr.length() == 0) {
            throw new RuntimeException("private key is empty.");
        }
        if (content == null) {
            return null;
        }
        RSAPrivateCrtKey privateKey = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = (RSAPrivateCrtKey) keyFactory.generatePrivate(new PKCS8EncodedKeySpec(java.util.Base64.getDecoder().decode(privateKeyStr)));
        } catch (Exception e) {
            throw new RuntimeException("init private key failed!", e);
        }
        String sig = null;
        try {
            Signature signature = Signature.getInstance("MD5WithRSA");
            signature.initSign(privateKey);
            signature.update(content);
            sig =java.util.Base64.getEncoder().encodeToString(signature.sign());//do base64 encoding
        } catch (Exception e) {
            throw new RuntimeException("sign failed!", e);
        }
        return sig;
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        String ss=  sign(prikey,"hello".getBytes("utf-8"));
        verify(pubkey,java.util.Base64.getDecoder().decode(ss),"hello".getBytes("utf-8"));
        verify(pubkey,java.util.Base64.getDecoder().decode("lwpXHof4k+COE4GuHNFcJ7EVHP5p7dwooNWoQVrdGuFZgbsIgls4IkM8BaQFQhOSnHAKAKRLlo5Mqi2In6gKFeZ4+5tbmJ1YDRybNZ/y9HsL+gsQu/OPynLbjSIN7uSoFb2hsm3pvq+7mNTSxvSYjZP3QWyIEpzzCimVs2mTr7k="),"hello".getBytes("utf-8"));
    }



}
