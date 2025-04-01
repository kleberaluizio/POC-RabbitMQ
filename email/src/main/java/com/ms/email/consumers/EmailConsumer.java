package com.ms.email.consumers;

import com.ms.email.definition.EmailInput;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailInput input) {
        System.out.println(input.emailTo());
    }
}
