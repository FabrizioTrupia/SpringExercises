package co.develhope.loginDemo.order.controllers;

import co.develhope.loginDemo.order.entities.Order;
import co.develhope.loginDemo.order.repositories.OrderRepository;
import co.develhope.loginDemo.order.services.OrderService;
import co.develhope.loginDemo.user.entities.Role;
import co.develhope.loginDemo.user.entities.User;
import co.develhope.loginDemo.user.utilies.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_REGISTERED')")
    public ResponseEntity<Order> create(@RequestBody Order order) throws Exception {

        return ResponseEntity.ok((Order) orderService.save(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getSingle(@PathVariable Long id , Principal principal){
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) return ResponseEntity.notFound().build();

        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        if (!Objects.equals(order.get().getCreatedBy(), user.getId())) {
            if (Roles.hasRole(user, Roles.RESTAURANT) && Objects.equals(order.get().getRestaurant().getId(), user.getId())) {
                return ResponseEntity.ok(order.get());
            } else if (Roles.hasRole(user, Roles.RIDER) && Objects.equals(order.get().getRider().getId(), user.getId())) {
                return ResponseEntity.ok(order.get());
            }
        } else {
            if (Roles.hasRole(user, Roles.REGISTERED)) {
                return ResponseEntity.ok(order.get());
            } else if (Roles.hasRole(user, Roles.RESTAURANT) && Objects.equals(order.get().getRestaurant().getId(), user.getId())) {
                return ResponseEntity.ok(order.get());
            } else if (Roles.hasRole(user, Roles.RIDER) && Objects.equals(order.get().getRider().getId(), user.getId())) {
                return ResponseEntity.ok(order.get());
            }
        }
        return ResponseEntity.ok(order.get());
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll(Principal principal){
        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        if (Roles.hasRole(user , Roles.REGISTERED)){
            return ResponseEntity.ok(orderRepository.findByCreatedBy(user));
        } else if (Roles.hasRole(user , Roles.RESTAURANT)) {
            return ResponseEntity.ok(orderRepository.findByRestaurant(user));

        } else if (Roles.hasRole(user , Roles.RIDER)) {
            return ResponseEntity.ok(orderRepository.findByRider(user));

        }
        return null;
    }


}
