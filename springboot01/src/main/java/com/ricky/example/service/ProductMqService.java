package com.ricky.example.service;


import javax.jms.Destination;

/**
 * @author ricky
 * @create 2020-03-01 15:49
 */
public interface ProductMqService {

    public void sendMessage(Destination destination, final String message);
    public void sendMessage(final String message);
    public void sendTopicMessage(final String message);


}
