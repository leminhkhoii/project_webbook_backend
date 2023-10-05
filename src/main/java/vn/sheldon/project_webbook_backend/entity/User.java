package vn.sheldon.project_webbook_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_of_user")
    private int idOfUser;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="username")
    private String userName;

    @Column(name="password", length = 512)
    private String passWord;

    @Column(name="gender")
    private char gender;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="order_address")
    private String orderAddress;

    @Column(name="delivery_address")
    private String deliveryAddress;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    private List<Review> listOfReview;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    private List<WishList> listOfWishlist;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinTable(
            name = "user_decentralization",
            joinColumns = @JoinColumn(name="id_of_user"),
            inverseJoinColumns = @JoinColumn(name="id_of_decentralization")
    )
    private List<Decentralization> listOfDecentralization;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    private List<Order> listOfOrder;


}
