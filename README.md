# Spring AMQP Examples

Examples for learning Spring AMQP.

#### How to run
1. Make sure a [RabbitMQ](https://www.rabbitmq.com) is running before you start:
    - `$ docker-compose up`
    - Verify rabbitmq is running. Open `http://localhost:15672/` in browser, and you can login with 'guest', 'guest'.
2. Compile:
    - `mvn package`
3. Choose an example to run, e.g. `amqp-basic`:
    - `$ java -jar amqp-basic/amqp-basic-consumer/target/amqp-basic-consumer-1.0.0.jar`
    - `$ java -jar amqp-basic/amqp-basic-producer/target/amqp-basic-producer-1.0.0.jar`
4. It's the similar way like Step 3 to run other examples. Have a try.

#### Modules
- **amqp-basic**
    - The producer will send simple string messages to a queue.
    - The consumer will receive the same messages.
- **amqp-message**
    - The producer will send customized java object messages to a queue.
    - The consumer will receive the same messages.
- **amqp-pubsub-direct**
    - The producer will send messages to a direct exchange.
    - The exchange will route messages to two queues by queue name.
    - The two consumers will receive different messages from corresponding queues.
- **amqp-pubsub-fanout**
    - The producer will send messages to a fanout exchange.
    - The exchange will route messages to all queues.
    - The two consumers will receive the same messages from corresponding queues.
- **amqp-pubsub-topic**
    - The producer will send messages to a topic exchange.
    - The exchange will route messages to three queues by wildcard match.
    - The three consumers will receive different messages from corresponding queues.
- **amqp-requeue**
    - The producer will send messages to a queue.
    - The consumer will act in three ways randomly:
        - Process successfully.
        - Throw an `Exception`. In this case the message will requeue and be deliveried again.
        - Throw an `AmqpRejectAndDontRequeueException`. In this case the message will not requeue.
