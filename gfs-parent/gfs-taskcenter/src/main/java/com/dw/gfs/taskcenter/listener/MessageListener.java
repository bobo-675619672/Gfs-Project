package com.dw.gfs.taskcenter.listener;

import com.alibaba.fastjson.JSON;
import com.dw.gfs.common.entity.MessageData;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQMessageListener(topic = "test-group", consumerGroup = "consumer-group")
public class MessageListener implements RocketMQListener<MessageData> {

    @Override
    public void onMessage(MessageData messageData) {
        log.info("从test-topic中监听到消息:{}", JSON.toJSONString(messageData));
    }

}
