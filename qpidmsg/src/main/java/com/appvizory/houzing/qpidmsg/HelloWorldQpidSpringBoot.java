package com.appvizory.houzing.qpidmsg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.ConnectionFactory;

/**
 * Created by elflord on 2/18/18.
 */
@EnableJms
@EnableScheduling
@SpringBootApplication
public class HelloWorldQpidSpringBoot {

    public static void main(String args[]){
        SpringApplication.run(HelloWorldQpidSpringBoot.class);
    }
}
