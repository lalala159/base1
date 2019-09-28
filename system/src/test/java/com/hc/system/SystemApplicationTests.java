//package com.hc.system;
//
//import com.hc.system.service.RedisService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SystemApplicationTests {
//
//    @Resource
//    private RedisService redisUtils;
//
//    /**
//     * 插入缓存数据
//     */
//    @Test
//    public void set() {
//        redisUtils.set("redis_key", "redis_vale");
//    }
//
//    /**
//     * 读取缓存数据
//     */
//    @Test
//    public void get() {
//        Object value = redisUtils.get("redis_key");
//        System.out.println(value);
//    }
//
//
//}
