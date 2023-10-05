package vn.sheldon.project_webbook_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name = "method_delivery")
public class MethodDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_of_method_delivery")
    private int idOfMethodDelivery;

    @Column(name = "name_of_method_delivery")
    private String nameOfMethodDelivery;

    @Column(name = "description")
    private String description;

    @Column(name = "payment_fee")
    private double feePayment;

    @OneToMany(mappedBy = "methodDelivery", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    private List<Order> listOfOrder;
}
