package com.example.ActiveMq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * describe:
 *
 * @author laizhihui
 * @date 2018/02/28
 */
@Component
@EnableScheduling
public class PromoteActConsumer {
    public static String ip="";
    public static String analysisType="";
    /**
     * 客户端消费
     *
     * @param consumer
     */
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @JmsListener(destination = "SampleQueue")
    public void receiveQueue(String consumer) {
        String [] s = consumer.split(",");
        String res = "";
        for(int i = 0;i<s.length;i++){
            res+=(char)Integer.parseInt(s[i]);
        }
        System.out.println(res);
        Destination destination = new ActiveMQQueue(ip+analysisType);
        this.jmsMessagingTemplate.convertAndSend(destination, res);
//        this.jmsMessagingTemplate.convertAndSend(this.queue, res);
    }

    public static String getUTF8StringFromGBKString(String gbkStr) {
        try {
            return new String(getUTF8BytesFromGBKString(gbkStr), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new InternalError();
        }
    }

    public static byte[] getUTF8BytesFromGBKString(String gbkStr) {
        int n = gbkStr.length();
        byte[] utfBytes = new byte[3 * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int m = gbkStr.charAt(i);
            if (m < 128 && m >= 0) {
                utfBytes[k++] = (byte) m;
                continue;
            }
            utfBytes[k++] = (byte) (0xe0 | (m >> 12));
            utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
            utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
        }
        if (k < utfBytes.length) {
            byte[] tmp = new byte[k];
            System.arraycopy(utfBytes, 0, tmp, 0, k);
            return tmp;
        }
        return utfBytes;
    }
}