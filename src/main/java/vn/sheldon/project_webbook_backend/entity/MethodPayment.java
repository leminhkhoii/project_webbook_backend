package vn.sheldon.project_webbook_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name="method_payment")
public class MethodPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_of_method_payment")
    private int idOfMethodPayment;

    @Column(name="name_method_payment")
    private String nameOfMethodPayment;

    @Column(name="description")
    private String description;

    @Column(name="payment_fee")
    private double feePayment;

    @OneToMany(mappedBy = "methodPayment", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    private List<Order> listOfOrder;
}
