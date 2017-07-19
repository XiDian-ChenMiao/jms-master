package com.xidian.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;
import java.util.UUID;

/**
 * 文件描述：JMS采用主题模型的消息生产者主启动类
 * 创建作者：陈苗
 * 创建时间：2017/7/18 18:51
 */
public class AppProducer {
    private static final String MQ_URL = "tcp://127.0.0.1:61616";
    private static final String TOPIC_NAME = "jms-topic";

    /**
     * 主程序
     * @param args
     */
    public static void main(String[] args) {
        /*创建连接工厂*/
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(MQ_URL);
        Connection connection = null;
        try {
            /*创建连接*/
            connection = connectionFactory.createConnection();
            /*启动连接*/
            connection.start();
            /*创建会话*/
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            /*创建目的地*/
            Destination destination = session.createTopic(TOPIC_NAME);
            /*创建消息生产者*/
            MessageProducer producer = session.createProducer(destination);
            for (int i = 0; i < 100; i++) {
                /*创建消息*/
                TextMessage message = new ActiveMQTextMessage();
                message.setText(UUID.randomUUID().toString());
                /*发送消息*/
                producer.send(message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
