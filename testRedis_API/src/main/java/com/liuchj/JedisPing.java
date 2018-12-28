package com.liuchj;/**
 * @ClassName JedisPing
 * @Description TODO
 * @Author liuchj
 * @Date 2018/12/28 10:58
 * @Version 1.0
 **/

import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @ClassName JedisPing
 * @Description 测试连通性
 * @Author liuchj
 * @Date 2018/12/28 10:58
 * @Version 1.0
 **/
public class JedisPing {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("47.105.158.105", 6381);
        System.out.println("jedis.ping= " + jedis.ping());

    }
}
