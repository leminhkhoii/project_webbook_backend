package vn.sheldon.project_webbook_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_of_order_detail")
    private long idOfOrderDetail;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
            }
    )
    @JoinColumn(name="id_of_book", nullable = false)
    private Book book;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
            }
    )
    @JoinColumn(name="id_of_order", nullable = false)
    private Order order;

}
