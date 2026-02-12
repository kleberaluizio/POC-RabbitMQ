package com.course.rabbitmq.consumer.consumer.default_exchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Service
public class HelloRabbitConsumer {

    @RabbitListener(queues = "course.hello")
    public void listen(String message) {
        System.out.println("Consumer received: " + message);
    }
}
