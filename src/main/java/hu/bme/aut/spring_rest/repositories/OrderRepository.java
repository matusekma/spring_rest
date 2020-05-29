package hu.bme.aut.spring_rest.repositories;

import hu.bme.aut.spring_rest.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
