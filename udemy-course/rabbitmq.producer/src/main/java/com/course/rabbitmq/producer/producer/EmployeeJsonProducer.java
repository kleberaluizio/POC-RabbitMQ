package com.course.rabbitmq.producer.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeeJsonProducer {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeJsonProducer.class);
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper mapper;

    public EmployeeJsonProducer(RabbitTemplate rabbitTemplate, ObjectMapper mapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.mapper = mapper;
    }

    @Scheduled(fixedRate = 500000)
    public void buildAndSend() throws JsonProcessingException {
        for (int i = 1; i <= 5; i++) {
            var employee = new Employee("emp - " +i, "Employee "+ i, LocalDate.now());
            sendMessage(employee);
            LOG.info("Sending employee {}", employee);
        }
    }

    public void sendMessage(Employee employee) throws JsonProcessingException {
        var json = mapper.writeValueAsString(employee);
        rabbitTemplate.convertAndSend("course.employee", json);
    }
}
