package vn.sheldon.project_webbook_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name="genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_of_genre")
    private int idOfGenre;

    @Column(name="name_of_genre", length = 256)
    private String nameOfGenre;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name="id_of_genre"),
            inverseJoinColumns = @JoinColumn(name="id_of_book")
    )
    private List<Book> listOfBook;
}
