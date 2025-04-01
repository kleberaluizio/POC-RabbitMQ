package com.ms.user.producers;

import com.ms.user.definition.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}") //Exchange do tipo default: chave routing key é o mesmo nome da fila criada
    private String routingKey;

    public void publishMessageEmail(UserModel user) {
        var emailOutput = new EmailOutput(
                user.getUserId(),
                user.getEmail(),
                "Cadastro realizado com sucesso!",
                user.getName() +", seja bem vindo! \nAgradecemos o seu cadastro, aproveite agora"
        );

        rabbitTemplate.convertAndSend("", routingKey, emailOutput);

    }
}
