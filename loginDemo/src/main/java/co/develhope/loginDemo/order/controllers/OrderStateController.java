package co.develhope.loginDemo.order.controllers;

import co.develhope.loginDemo.order.entities.Order;
import co.develhope.loginDemo.order.repositories.OrderRepository;
import co.develhope.loginDemo.order.services.OrderServerState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/orders/{id}/state")
public class OrderStateController {

    @Autowired
    private OrderServerState orderServerState;
    @Autowired
    private OrderRepository orderRepository;

    @PreAuthorize("hasRole('ROLE_RESTAURANT')")
    @PutMapping("/accept")
    public ResponseEntity<Object> accept(@PathVariable Long id){
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_RESTAURANT')")
    @PutMapping("/in_preparation")
    public ResponseEntity<Object> inPreparation(@PathVariable Long id){
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }
    @PreAuthorize("hasRole('ROLE_RESTAURANT')")
    @PutMapping("/ready")
    public ResponseEntity<Object> ready(@PathVariable Long id){
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_RIDER')")
    @PutMapping("/delivering")
    public ResponseEntity<Object> delivering(@PathVariable Long id){
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_RIDER')")
    @PutMapping("/complete")
    public ResponseEntity<Object> complete(@PathVariable Long id){
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }



}
