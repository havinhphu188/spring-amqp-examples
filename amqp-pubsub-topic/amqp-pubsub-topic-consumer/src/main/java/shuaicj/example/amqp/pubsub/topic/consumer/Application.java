package shuaicj.example.amqp.pubsub.topic.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring boot app.
 *
 * @author shuaicj 2017/07/21
 */
@SpringBootApplication
public class Application {

    static final String EX = "hello-topic-ex";
    static final String Q1 = "hello-topic-q1";
    static final String Q2 = "hello-topic-q2";
    static final String Q3 = "hello-topic-q3";

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EX);
    }

    @Bean
    Queue queue1() {
        return new Queue(Q1);
    }

    @Bean
    Queue queue2() {
        return new Queue(Q2);
    }

    @Bean
    Queue queue3() {
        return new Queue(Q3);
    }

    @Bean
    Binding binding1() {
        return BindingBuilder.bind(queue1()).to(exchange()).with("shuaicj.#");
    }

    @Bean
    Binding binding2() {
        return BindingBuilder.bind(queue2()).to(exchange()).with("*.hello.*");
    }

    @Bean
    Binding binding3() {
        return BindingBuilder.bind(queue3()).to(exchange()).with("*.*.amqp");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
