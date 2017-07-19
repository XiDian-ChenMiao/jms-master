package com.xidian.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;
import java.util.UUID;

/**
 * 文件描述：JMS采用队列模型的消息消费者主启动类
 * 创建作者：陈苗
 * 创建时间：2017/7/18 18:51
 */
public class AppConsumer {
    private static final String MQ_URL = "tcp://127.0.0.1:61616";
    private static final String Q_NAME = "jms-queue";

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
            Destination destination = session.createQueue(Q_NAME);
            /*创建消息消费者*/
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if (message instanceof TextMessage) {
                        TextMessage msg = (TextMessage) message;
                        try {
                            System.out.println(msg.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
