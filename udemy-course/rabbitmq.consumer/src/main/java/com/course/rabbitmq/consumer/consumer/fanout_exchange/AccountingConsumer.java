package com.course.rabbitmq.consumer.consumer.fanout_exchange;

import com.course.rabbitmq.consumer.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class AccountingConsumer {

    public static Logger LOG = LoggerFactory.getLogger(MarketingConsumer.class);

    @RabbitListener(queues = "q.hr.accounting", concurrency = "1-2")
    public void consumerNewEmployee(Employee employee) throws InterruptedException {
        Thread.sleep(1000);
        LOG.info("Accounting consumed employee {}", employee);
    }

}
