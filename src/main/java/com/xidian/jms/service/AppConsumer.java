package com.xidian.jms.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 文件描述：通过Spring来实现JMS的消费者启动类
 * 创建作者：陈苗
 * 创建时间：2017/7/18 20:05
 */
public class AppConsumer {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("consumer.xml");
    }
}
