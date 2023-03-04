package co.develhope.loginDemo.order.services;

import co.develhope.loginDemo.order.entities.Order;
import co.develhope.loginDemo.order.repositories.OrderRepository;
import co.develhope.loginDemo.user.entities.User;
import co.develhope.loginDemo.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    public Object save(Order order) throws Exception {
        if (order == null) return null;
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Order order1 = new Order();
        order1.setCreatedAt(LocalDateTime.now());
        order1.setCreatedBy(user);
        //CHeck for restaurant
        if (order.getRestaurant() == null) throw new Exception("Restaurant is null");
        Optional<User> restaurant = userRepository.findById(order.getRestaurant().getId());

        return orderRepository.save(order1);
    }


}
