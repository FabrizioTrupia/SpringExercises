package co.develhope.loginDemo.order.entities;

import co.develhope.loginDemo.user.entities.User;
import jakarta.persistence.*;
import jakarta.persistence.metamodel.IdentifiableType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String description;
    private String address;
    private String number;
    private String city;
    private String zipCode;
    private String state;
    private double totalPrice;
    private OrderStateEnum status = OrderStateEnum.CREATED;
    @ManyToOne
    private User restaurant;
    @ManyToOne
    private User rider;


    public void setCreatedAt(LocalDateTime now) {
    }

    public void setCreatedBy(User user) {
    }

    public IdentifiableType<Object> getCreatedBy() {
        return null;
    }
}
