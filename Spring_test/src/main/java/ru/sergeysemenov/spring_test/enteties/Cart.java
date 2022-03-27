package ru.sergeysemenov.spring_test.enteties;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private User user;

    @OneToMany(mappedBy = "cartId")
    private List<Line> lineList;


}
