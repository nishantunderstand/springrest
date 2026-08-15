package restfulwebservices.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

  @KafkaListener(
          topics = "main-topic",
          groupId = "dlq-group",
          containerFactory = "kafkaListenerContainerFactory"
  )
  public void consume(String message) {
    log.info("=== CONSUMER HIT (thread: {}) ===", Thread.currentThread().getName());
    log.info("Received Message : {}", message);

    if (message.contains("FAIL")) {
      log.warn("THROWING ERROR for message: {}", message);
      throw new RuntimeException("Intentional Exception");
    }

    log.info("Processed Successfully : {}", message);
  }
}