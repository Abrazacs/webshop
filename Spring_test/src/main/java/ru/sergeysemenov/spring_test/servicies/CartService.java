package ru.sergeysemenov.spring_test.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeysemenov.spring_test.enteties.Cart;
import ru.sergeysemenov.spring_test.enteties.Line;
import ru.sergeysemenov.spring_test.repositories.CartRepository;

import java.util.List;

@Service
public class CartService {
    private CartRepository cartRepository;

    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart findByUserId(Long id){
        return cartRepository.findByUserId(id);
    }


}
