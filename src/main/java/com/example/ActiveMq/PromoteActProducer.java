//package com.example.ActiveMq;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsMessagingTemplate;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.jms.Queue;
//
///**
// * describe:
// *
// * @author laizhihui
// * @date 2018/02/28
// */
//@Component
//@EnableScheduling
//public class PromoteActProducer {
//
//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;
//
//    @Autowired
//    private Queue queue;
//
//    @Scheduled(fixedDelay = 4000)    // 每2s执行1次
//    public void send() {
//        this.jmsMessagingTemplate.convertAndSend(this.queue, "hello,activeMQ");
//    }
//}