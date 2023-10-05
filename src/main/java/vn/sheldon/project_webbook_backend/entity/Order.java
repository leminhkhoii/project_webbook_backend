package vn.sheldon.project_webbook_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
@Entity
@Data
@Table(name="order1")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_of_order")
    private int idOfOrder;

    @Column(name="created_date")
    private Date createdDate;

    @Column(name = "order_address", length = 512)
    private String orderAddress;

    @Column(name = "delivery_address", length = 512)
    private String deliveryAddress;

    @Column(name = "total_price_of_book")
    private double totalPriceOfBook;

    @Column(name="shipping_cost")
    private double shippingCost;

    @Column(name = "payment_cost")
    private double paymentCost;

    @Column(name = "total_price")
    private double totalPrice;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> listOfOrderDetail;

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
    @JoinColumn(name="id_of_method_payment")
    private MethodPayment methodPayment;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
            }
    )
    @JoinColumn(name="id_of_method_delivery")
    private MethodDelivery methodDelivery;
}
