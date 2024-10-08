package com.ms.email.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${broker.queue.email.name}")
    private String queue;

    @Bean//para deixar explicito que queue sera criado quando for necessario
    public Queue queue(){
        return new Queue(queue, true);//ses sera duravel ou nao (se a fila cair ,ela sera resetada)
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){//como o que será recebido será um record, precisamos de um converter do que vem do JSON
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}
