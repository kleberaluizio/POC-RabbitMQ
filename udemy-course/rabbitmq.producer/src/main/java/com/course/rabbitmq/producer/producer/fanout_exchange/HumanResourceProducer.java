package com.course.rabbitmq.producer.producer.fanout_exchange;

import com.course.rabbitmq.producer.employee.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

//@Service
public class HumanResourceProducer {

    private static int index = 0;
    public static Logger LOG = LoggerFactory.getLogger(HumanResourceProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public HumanResourceProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedRate = 5000)
    public void publishHumanResource() {
        for (int i = 1; i <= 5; i++) {
            index++;
            var employee = new Employee("emp - " + index, "Employee "+ index, LocalDate.now());
            publishNewEmployee(employee);
            LOG.info("{} - Sending employee {}", index, employee);
        }
    }

    public void publishNewEmployee(Employee employee) {
        rabbitTemplate.convertAndSend("x.hr", "", employee);
    }

}
