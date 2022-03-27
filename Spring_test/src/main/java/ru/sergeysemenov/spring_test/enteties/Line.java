package ru.sergeysemenov.spring_test.enteties;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lines")
@Getter
@Setter
public class Line {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_qty")
    private int productQty;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "cart_id")
    private Long cartId;

}
