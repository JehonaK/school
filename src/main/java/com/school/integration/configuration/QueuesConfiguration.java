package com.school.integration.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueuesConfiguration {

    @Value("${queue.user.new.student}")
    private String newStudentsQueueName;

    @Value("${queue.user.new.teacher}")
    private String newTeachersQueueName;

    @Value("${queue.user.new.admin}")
    private String newAdminsQueueName;

    @Bean(name = "newStudentsQueue")
    public Queue newStudentsQueue() {
        return new Queue(newStudentsQueueName);
    }

    @Bean(name = "newTeachersQueue")
    public Queue newTeachersQueue() {
        return new Queue(newTeachersQueueName);
    }

    @Bean(name = "newAdminsQueue")
    public Queue newAdminsQueue() {
        return new Queue(newAdminsQueueName);
    }

}
