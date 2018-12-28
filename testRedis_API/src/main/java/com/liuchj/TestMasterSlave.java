package com.liuchj;

import redis.clients.jedis.Jedis;

/**
 * @ClassName TestMasterSlave
 * @Description 测试主从复制
 * @Author liuchj
 * @Date 2018/12/28 15:13
 * @Version 1.0
 **/

public class TestMasterSlave {


    public static void main(String[] args) {
        Jedis jedis_M = new Jedis("47.105.158.105", 6381);
        Jedis jedis_S = new Jedis("47.105.158.105", 6379);

        jedis_S.slaveof("47.105.158.105", 6381);

        jedis_M.set("class", "1122V2");

        String result = jedis_S.get("class");
        System.out.println(result);
    }

}
