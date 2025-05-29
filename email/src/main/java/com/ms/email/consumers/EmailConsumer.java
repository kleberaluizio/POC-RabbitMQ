package com.ms.email.consumers;

import com.ms.email.definition.EmailInput;
import com.ms.email.definition.EmailModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailInput emailInput) {
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailInput, emailModel);
        //sendemail
        System.out.println(emailInput.emailTo());
    }
}
