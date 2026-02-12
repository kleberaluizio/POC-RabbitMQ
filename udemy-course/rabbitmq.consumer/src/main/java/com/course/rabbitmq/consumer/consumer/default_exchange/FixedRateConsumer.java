package com.course.rabbitmq.consumer.consumer.default_exchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FixedRateConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(FixedRateConsumer.class);

    @RabbitListener(queues = "course.fixedrate", concurrency = "1-7")
    public void consume(String message) throws InterruptedException {
        Thread.sleep(1000);
        LOG.info("Consumed message: {} by Thread {}", message, Thread.currentThread().getName());
    }
}
