package pizzaDemo;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Pizzadelivery_table")
public class Pizzadelivery {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String pizzaId;
    private String pizzaDeliveryStatus;

    @PostPersist
    public void onPostPersist(){

        Pizzashipped pizzashipped = new Pizzashipped();
        BeanUtils.copyProperties(this, pizzashipped);
        pizzashipped.publishAfterCommit();

    }

    @PostUpdate
    public void onPostUpdate(){
        Pizzadeliverycanceled pizzadeliverycanceled = new Pizzadeliverycanceled();
        BeanUtils.copyProperties(this, pizzadeliverycanceled);
        pizzadeliverycanceled.publishAfterCommit();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(String pizzaId) {
        this.pizzaId = pizzaId;
    }
    public String getPizzaDeliveryStatus() {
        return pizzaDeliveryStatus;
    }

    public void setPizzaDeliveryStatus(String pizzaDeliveryStatus) {
        this.pizzaDeliveryStatus = pizzaDeliveryStatus;
    }




}
