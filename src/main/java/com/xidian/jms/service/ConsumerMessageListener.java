package com.xidian.jms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 文件描述：消息监听者
 * 创建作者：陈苗
 * 创建时间：2017/7/18 19:59
 */
public class ConsumerMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerMessageListener.class);
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                logger.info(((TextMessage) message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
