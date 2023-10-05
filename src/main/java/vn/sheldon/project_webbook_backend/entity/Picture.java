package vn.sheldon.project_webbook_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name="picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_of_picture")
    private int idOfPicture;

    @Column(name="name_of_picture", length = 256)
    private String nameOfPicture;

    @Column(name = "icon")
    private boolean icon;

    @Column(name="link")
    private String link;

    @Column(name = "data")
    @Lob
    private String data;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
            }
    )
    @JoinColumn(name="id_of_book", nullable = false)
    private Book book;
}
