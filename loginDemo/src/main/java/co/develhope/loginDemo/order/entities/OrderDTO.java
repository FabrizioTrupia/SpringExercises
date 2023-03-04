package co.develhope.loginDemo.order.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String description;
    private String address;
    private String number;
    private String city;
    private String zipCode;
    private String state;
    private double totalPrice;
    private Long restaurant;


}
