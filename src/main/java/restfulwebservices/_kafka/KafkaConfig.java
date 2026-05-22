package restfulwebservices._kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Slf4j
@Configuration
public class KafkaConfig {

  @Bean
  public DefaultErrorHandler errorHandler(KafkaTemplate<String, String> kafkaTemplate) {
    log.info("=== Creating DefaultErrorHandler with DLQ ===");

    DeadLetterPublishingRecoverer recoverer = new DeadLetterPublishingRecoverer(
            kafkaTemplate,
            (record, ex) -> {
              log.error(">>> Sending message to DLQ : {}", record.value());
              return new TopicPartition(record.topic() + "-dlq", record.partition());
            }
    );

    FixedBackOff backOff = new FixedBackOff(2000L, 3);
    DefaultErrorHandler errorHandler = new DefaultErrorHandler(recoverer, backOff);

    log.info("=== ErrorHandler configured with retries: 3, interval: 2000ms ===");
    return errorHandler;
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(
          ConsumerFactory<String, String> consumerFactory,
          DefaultErrorHandler errorHandler) {

    log.info("=== Creating kafkaListenerContainerFactory with errorHandler: {} ===", errorHandler);

    ConcurrentKafkaListenerContainerFactory<String, String> factory =
            new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory);
    factory.setCommonErrorHandler(errorHandler);

    log.info("=== Container factory configured ===");
    return factory;
  }
}