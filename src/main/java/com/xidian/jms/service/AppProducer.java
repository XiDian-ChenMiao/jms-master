package com.xidian.jms.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * 文件描述：通过Spring来实现JMS的生产者启动类
 * 创建作者：陈苗
 * 创建时间：2017/7/18 19:48
 */
public class AppProducer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service = context.getBean(ProducerService.class);
        for (int i = 0; i < 100; i++) {
            service.sendMessage(UUID.randomUUID().toString());
        }
        context.close();
    }
}
