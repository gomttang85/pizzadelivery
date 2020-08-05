package pizzaDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
 public class PizzadeliveryController {
    @Autowired
    PizzadeliveryRepository pizzadeliveryRepository;

    @RequestMapping(method=RequestMethod.POST, path="/cancellations")
    public void cancelPizzaDelivery(@RequestBody Pizzadelivery pizzadelivery){

     Optional<Pizzadelivery> pizzaorderOptional = pizzadeliveryRepository.findByPizzaId(pizzadelivery.getPizzaId());
     Pizzadelivery pizzaorder = pizzaorderOptional.get();

     pizzaorder.setPizzaDeliveryStatus("CANCELED");
     pizzadeliveryRepository.save(pizzaorder);

    }
 }
