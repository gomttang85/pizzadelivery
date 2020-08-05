package pizzaDemo;

import pizzaDemo.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    PizzadeliveryRepository pizzadeliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPizzaordered_Pizzaship(@Payload Pizzaordered pizzaordered){

        if(pizzaordered.isMe()){

            Pizzadelivery pizzadelivery = new Pizzadelivery();
            pizzadelivery.setPizzaId(pizzaordered.getPizzaId());
            pizzadelivery.setPizzaDeliveryStatus("SHIPPED");

            pizzadeliveryRepository.save(pizzadelivery);

        }
    }

}
