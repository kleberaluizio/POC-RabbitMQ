package com.course.rabbitmq.consumer.consumer;

import com.course.rabbitmq.consumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeJsonConsumer.class);
    private final ObjectMapper mapper;

    public EmployeeJsonConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @RabbitListener(queues = "course.employee")
    public void consume(String message) throws JsonProcessingException, InterruptedException {
        Thread.sleep(500);
        Employee employee = mapper.readValue(message, Employee.class);
        LOG.info("Consume Employee: {}", employee);
    }
}
