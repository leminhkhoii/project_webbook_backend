package vn.sheldon.project_webbook_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="wish_list")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_of_wish_list")
    private int idOfWishList;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
            }
    )
    @JoinColumn(name="id_of_user", nullable = false)
    private User user;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
            }
    )
    @JoinColumn(name="id_of_book", nullable = false)
    private Book book;
}
