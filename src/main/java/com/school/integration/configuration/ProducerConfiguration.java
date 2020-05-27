package com.school.integration.configuration;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class ProducerConfiguration {

    @Bean
    public MessageConverter messageConverterProducer() {
        return new Jackson2JsonMessageConverter();
    }

//    private MessageConverter messageConverter;
//
//    public ProducerConfiguration(MessageConverter messageConverter) {
//        this.messageConverter = messageConverter;
//    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverterProducer());
        return rabbitTemplate;
    }

}
