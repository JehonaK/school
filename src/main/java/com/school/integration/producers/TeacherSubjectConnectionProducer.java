package com.school.integration.producers;

import com.school.integration.models.SerializableTeacherSubjectConnection;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TeacherSubjectConnectionProducer {

    @Value("${routing.connection.teacher.subject}")
    private String teacherSubjectConnectionRoutingKey;

    @Value("${exchange.direct}")
    private String directExchange;

    private final RabbitTemplate rabbitTemplate;

    public TeacherSubjectConnectionProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendTeacherSubjectConnection(SerializableTeacherSubjectConnection connection) {
        rabbitTemplate.convertAndSend(directExchange, teacherSubjectConnectionRoutingKey, connection);
    }

}
