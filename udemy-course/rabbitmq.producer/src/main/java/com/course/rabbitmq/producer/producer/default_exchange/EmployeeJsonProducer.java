package com.course.rabbitmq.producer.producer.default_exchange;

import com.course.rabbitmq.producer.employee.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;

//@Service
public
class EmployeeJsonProducer {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeJsonProducer.class);
    private final RabbitTemplate rabbitTemplate;

    public EmployeeJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
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
        rabbitTemplate.convertAndSend("course.employee", employee);
    }
}
