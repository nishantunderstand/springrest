package restfulwebservices._kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/messages")
public class MessageController {

  private final KafkaProducer producer;

  @PostMapping
  public String publish(@RequestParam String message) {

    producer.send(message);

    return "Message Sent";
  }
}