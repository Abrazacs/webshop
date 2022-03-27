package ru.sergeysemenov.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sergeysemenov.spring_test.enteties.Cart;
import ru.sergeysemenov.spring_test.enteties.Line;
import ru.sergeysemenov.spring_test.enteties.Product;
import ru.sergeysemenov.spring_test.enteties.User;
import ru.sergeysemenov.spring_test.repositories.CartRepository;
import ru.sergeysemenov.spring_test.servicies.CartService;
import ru.sergeysemenov.spring_test.servicies.LineService;
import ru.sergeysemenov.spring_test.servicies.ProductService;
import ru.sergeysemenov.spring_test.servicies.UserService;


import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private CartService cartService;
    private UserService userService;
    private LineService lineService;

    @Autowired
    public void setLineService(LineService lineService) {
        this.lineService = lineService;
    }

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showProducts(Model model, Principal principal){
        List<Product> products = productService.getProducts();
        model.addAttribute("productList", products);
        User user = userService.findByUsername(principal.getName());
        Cart cart =  cartService.findByUserId(user.getId());
        model.addAttribute("cartId", cart.getCartId());
        return "products";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") long id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product-info";
    }

    @PostMapping("")
    public String createLine(@RequestParam("cartId") Long cartId, @RequestParam ("productId") Long productId,
                           @RequestParam("quantity") int quantity){

            Line line = new Line();
            line.setProductId(productId);
            line.setProductQty(quantity);
            line.setCartId(cartId);
            lineService.saveOrUpdateLine(line);

        return "redirect:/products";
    }


}
