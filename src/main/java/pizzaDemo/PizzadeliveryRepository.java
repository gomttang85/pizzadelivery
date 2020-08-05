package pizzaDemo;

import feign.Param;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PizzadeliveryRepository extends PagingAndSortingRepository<Pizzadelivery, Long>{

    Optional<Pizzadelivery> findByPizzaId(@Param("pizzaId") String pizzaId);

}