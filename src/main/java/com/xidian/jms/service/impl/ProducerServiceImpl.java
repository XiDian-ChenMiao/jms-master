package com.xidian.jms.service.impl;

import com.xidian.jms.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * 文件描述：生产者实现类
 * 创建作者：陈苗
 * 创建时间：2017/7/18 19:39
 */
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource(name = "topicDestination")
    private Destination destination;

    private final static Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);
    /**
     *
     * @param message
     */
    public void sendMessage(final String message) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                logger.info("发送消息：" + message);
                return textMessage;
            }
        });
    }
}
