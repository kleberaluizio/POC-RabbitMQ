package com.course.rabbitmq.consumer.consumer.default_exchange;

import com.course.rabbitmq.consumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeJsonConsumer.class);

    @RabbitListener(queues = "course.employee")
    public void consume(Employee employee) throws JsonProcessingException, InterruptedException {
        Thread.sleep(500);
        LOG.info("Consume Employee: {}", employee);
    }
}
