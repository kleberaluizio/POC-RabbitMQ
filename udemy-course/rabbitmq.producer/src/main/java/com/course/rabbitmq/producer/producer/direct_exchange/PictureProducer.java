package com.course.rabbitmq.producer.producer.direct_exchange;

import com.course.rabbitmq.producer.Picture.Picture;
import com.course.rabbitmq.producer.Picture.PictureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PictureProducer {

    private static int index = 0;
    private static final Logger LOG = LoggerFactory.getLogger(PictureProducer.class);
    private static final PictureType[] types = PictureType.values();
    private final RabbitTemplate rabbitTemplate;

    public PictureProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void sendNewPicture() {
        for (int i = 0; i < 3; i++) {
            index++;
            var picture = new Picture("Picture " + index, types[i], "300x400");
            sendNewPicture(picture);
            LOG.info("{} - Sending picture {}", index, picture);
        }
    }

    public void sendNewPicture(Picture picture) {
        rabbitTemplate.convertAndSend("x.picture", picture.pictureType().getDescription(), picture);
    }
}
