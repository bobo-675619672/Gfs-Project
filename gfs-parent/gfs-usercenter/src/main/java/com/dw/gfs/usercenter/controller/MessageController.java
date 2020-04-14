package com.dw.gfs.usercenter.controller;

import com.dw.gfs.common.base.BaseController;
import com.dw.gfs.common.entity.MessageData;
import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.common.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/msg")
public class MessageController extends BaseController {

    private final RocketMQTemplate rocketMQTemplate;

    /**
     * rocketMQ消息发送-生产者
     * @param msg 消息
     * @return 发送结果
     */
    @GetMapping("/send/{msg}")
    public ResultData<String> send(@PathVariable("msg") String msg) {
        String topic = "test-group";
        rocketMQTemplate.convertAndSend(topic,
                MessageData.builder()
                        .id(1L)
                        .message(msg)
                        .createdAt(DateUtil.getNow())
                        .status(1)
                        .build());
        log.info("发送消息topic {}, messag: {}", topic, msg);
        return success("发送:" + msg);
    }

}
