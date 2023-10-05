package vn.sheldon.project_webbook_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name="decentralization")
public class Decentralization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_of_decentralization")
    private int idOfDecentralization;

    @Column(name = "name_of_decentralization")
    private String nameOfDecentralization;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinTable(
            name = "user_decentralization",
            joinColumns = @JoinColumn(name="id_of_decentralization"),
            inverseJoinColumns = @JoinColumn(name="id_of_user")
    )
    private List<User> listOfUser;
}
