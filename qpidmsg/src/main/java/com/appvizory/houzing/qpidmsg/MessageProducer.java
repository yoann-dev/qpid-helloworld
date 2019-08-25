package com.appvizory.houzing.qpidmsg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.util.UUID;

/**
 * Created by elflord on 2/18/18.
 */
@Component
public class MessageProducer {

    private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class.getName());

    @Autowired
    public JmsTemplate jmsTemplate;

    @Scheduled(fixedDelay = 5000)
    public void sendMessageQueue(){
        final String payload = "Hello from Spring Boot QPID Queue";
        logger.info("Sending Message {}", payload);
        this.jmsTemplate.convertAndSend("testqueue", payload);
    }

    @Scheduled(fixedDelay = 5000)
    public void sendMessageTopic(){
        final String payload = "Hello from Spring Boot QPID Topic";
        logger.info("Sending Message {}", payload);
        this.jmsTemplate.setPubSubDomain(true);
        this.jmsTemplate.convertAndSend("testqueue", payload);
        this.jmsTemplate.setPubSubDomain(false);
    }
}
