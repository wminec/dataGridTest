package com.sye010_datagrid;

import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws java.io.IOException
    {
        /*
        System.out.println( "Hello World!" );

        ConfigurationBuilder b = new ConfigurationBuilder();
        Properties p = new Properties();
        try(Reader r = new FileReader("hotrod.properties")) {
            p.load(r);
            b.withProperties(p);
        }
        RemoteCacheManager rcm = new RemoteCacheManager(b.build());
        RemoteCache<String, String> cache = rcm.getCache("VALIDATION");
        */


        MultiThread[] mt = new MultiThread[3];
        MultiThread2[] mt2 = new MultiThread2[3];
        for(int i = 0 ; i < 3 ; i ++){
            mt[i] = new MultiThread();
            mt2[i] = new MultiThread2();
            mt[i].start();
            mt2[i].start();
        }


    }
}


class MultiThread extends Thread
{
    
    MultiThread(){
    }
    public void run(){
        try{
            ConfigurationBuilder b = new ConfigurationBuilder();
            Properties p = new Properties();
            try(Reader r = new FileReader("hotrod.properties")) {
                p.load(r);
                b.withProperties(p);
            }
            RemoteCacheManager rcm = new RemoteCacheManager(b.build());
            RemoteCache<String, String> cache = rcm.getCache("VALIDATION");
    
            for(int i=1; i <= 1000000000; i++)
            {
                /*
                double dValue = Math.random();
                //double dValue2 = Mat
                String rKey = (int)(dValue * 1000000000)+"";
                String rValue = (int)(dValue * 1000000000)+"";
                //cache.put("k"+i, "v"+i, 5, TimeUnit.SECONDS, 5, TimeUnit.SECONDS);
                cache.put(rKey, rValue);
                System.out.println(rKey + " : " +cache.get(rKey));
                */
                double dValue = Math.random();
                String rKey = (int)(dValue * 10)%3+"";
                //String rKey2 = (int)(dValue * 10)%3+"";
                //cache.put(rKey, "v1", 1, TimeUnit.SECONDS, 1, TimeUnit.SECONDS);
                cache.put(rKey, "v1");
                //System.out.println("rKey : " +rKey + ", rKey2 : " + rKey2 + cache.get(rKey));
                //cache.removeAsync(rKey2);
            }
            /* Source */
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class MultiThread2 extends Thread
{
    
    MultiThread2(){
    }
    public void run(){
        try{
            ConfigurationBuilder b = new ConfigurationBuilder();
            Properties p = new Properties();
            try(Reader r = new FileReader("hotrod.properties")) {
                p.load(r);
                b.withProperties(p);
            }
            RemoteCacheManager rcm = new RemoteCacheManager(b.build());
            RemoteCache<String, String> cache = rcm.getCache("VALIDATION");
    
            for(int i=1; i <= 1000000000; i++)
            {
                /*
                double dValue = Math.random();
                //double dValue2 = Mat
                String rKey = (int)(dValue * 1000000000)+"";
                String rValue = (int)(dValue * 1000000000)+"";
                //cache.put("k"+i, "v"+i, 5, TimeUnit.SECONDS, 5, TimeUnit.SECONDS);
                cache.put(rKey, rValue);
                System.out.println(rKey + " : " +cache.get(rKey));
                */
                double dValue = Math.random();
                String rKey = (int)(dValue * 10)%3+"";
                //String rKey2 = (int)(dValue * 10)%3+"";
                //cache.put(rKey, "v1", 1, TimeUnit.SECONDS, 1, TimeUnit.SECONDS);
                System.out.println("rKey : " +rKey + " : " + cache.get(rKey));
                cache.removeAsync(rKey);
            }
            /* Source */
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}