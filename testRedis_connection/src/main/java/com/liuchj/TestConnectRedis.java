package com.liuchj;/**
 * @ClassName TestConnectRedis
 * @Description TODO
 * @Author liuchj
 * @Date 2018/12/27 22:28
 * @Version 1.0
 **/

import redis.clients.jedis.Jedis;

/**
 *@ClassName TestConnectRedis
 *@Description 测试联通到redis
 *@Author liuchj
 *@Date 2018/12/27 22:28
 *@Version 1.0
 **/
public class TestConnectRedis {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.105.158.105",6381);
        System.out.println("jedis.get(k2) = " + jedis.get("k2"));
    }


}
