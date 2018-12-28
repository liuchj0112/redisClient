package com.liuchj;/**
 * @ClassName JedisAPI
 * @Description TODO
 * @Author liuchj
 * @Date 2018/12/27 23:04
 * @Version 1.0
 **/

import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @ClassName JedisAPI
 * @Description 测试5+1中的key
 * @Author liuchj
 * @Date 2018/12/27 23:04
 * @Version 1.0
 **/
public class JedisAPI {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.105.158.105", 6381);
        System.out.println("jedis.dbSize= " + jedis.dbSize());
        //key
        Set<String> keys = jedis.keys("*");
        for (Iterator iterator = keys.iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            System.out.println(key);
        }
        System.out.println("jedis.exists====>" + jedis.exists("k2"));
        System.out.println(jedis.ttl("k3"));

        System.out.println();
        System.out.println();
        System.out.println();
        //list
        System.out.println("========lpush===============");
        //jedis.lpush("myList","v1","v2","v3","v4","v5");
        List<String> list = jedis.lrange("myList", 0, -1);
        for (String ele : list) {
            System.out.println("ele ==== " + ele);
        }
        System.out.println();
        System.out.println();
        System.out.println("=========rpush==============");
        //jedis.rpush("myListR","r1","r2","r3");
        List<String> listr = jedis.lrange("myListR", 0, -1);
        for (String element : listr) {
            System.out.println("element===" + element);
        }
        System.out.println();
        System.out.println();
        System.out.println("=========set==============");
        //set
        jedis.sadd("orders", "jd001");
        jedis.sadd("orders", "jd002");
        jedis.sadd("orders", "jd003");
        Set<String> set1 = jedis.smembers("orders");
        for (Iterator iterator = set1.iterator(); iterator.hasNext(); ) {
            System.out.println((String) iterator.next());
        }
        jedis.srem("orders", "jd002");
        System.out.println(jedis.smembers("orders").size());

        //hash
        jedis.hset("hash1", "username", "zhangsan");
        System.out.println("jedis = " + jedis.hget("hash1", "username"));

        Map<String, String> map = new HashMap<>();
        map.put("address", "atguigu");
        map.put("telephone", "123456");
        map.put("email", "liuchj0112@126.com");
        jedis.hmset("hash2", map);

        List<String> hmget = jedis.hmget("hash2", "address");
        for (String str : hmget) {
            System.out.println("str = " + str);
        }

        //zset
        jedis.zadd("zset01", 30, "vv11");
        jedis.zadd("zset02", 30, "vv22");
        jedis.zadd("zset03", 30, "vv33");
        jedis.zadd("zset04", 30, "vv44");

        Set<String> zset = jedis.zrange("zset02", 0, -1);
        Iterator<String> iterator = zset.iterator();

        if (iterator.hasNext()) {
            System.out.println("iterator.next = " + iterator.next());
        }
    }
}
