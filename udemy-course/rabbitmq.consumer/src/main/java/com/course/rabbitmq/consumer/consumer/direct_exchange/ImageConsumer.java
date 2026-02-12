package com.course.rabbitmq.consumer.consumer.direct_exchange;

import com.course.rabbitmq.consumer.Picture.Picture;
import com.course.rabbitmq.consumer.consumer.fanout_exchange.MarketingConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ImageConsumer {

    public static Logger LOG = LoggerFactory.getLogger(MarketingConsumer.class);


    @RabbitListener(queues = "q.picture.image", concurrency = "1-5")
    public void pictureConsumer(Picture picture) throws InterruptedException {
        Thread.sleep(1000);
        LOG.info("IMAGE - Picture consumed employee {}", picture);
    }
}
