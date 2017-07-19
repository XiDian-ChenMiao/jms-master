package com.xidian.jms.service;

/**
 * 文件描述：生产者接口
 * 创建作者：陈苗
 * 创建时间：2017/7/18 19:38
 */
public interface ProducerService {
    /**
     * 发送消息
     * @param message
     */
    void sendMessage(String message);
}
