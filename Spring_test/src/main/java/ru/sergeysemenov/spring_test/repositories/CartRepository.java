package ru.sergeysemenov.spring_test.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sergeysemenov.spring_test.enteties.Cart;
import ru.sergeysemenov.spring_test.enteties.Line;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    Cart findByUserId(Long userId);


}
