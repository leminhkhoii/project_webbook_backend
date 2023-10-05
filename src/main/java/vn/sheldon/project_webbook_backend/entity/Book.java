package vn.sheldon.project_webbook_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_of_book")
    private int idOfBook;

    @Column(name="name_of_book", length = 256)
    private String nameOfBook;

    @Column(name="name_of_author", length = 512)
    private String nameOfAuthor;

    @Column(name="isbn", length = 256)
    private String ISBN;

    @Column(name="description",columnDefinition = "text")
    private String description;
    //Giá niêm yết

    @Column(name="list_price")
    private double listPrice;

    @Column(name="price")
    private double price;

    @Column(name="quantity")
    private int quantity;

    @Column(name = "average_rating")
    private double averageRating;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name="id_of_book"),
            inverseJoinColumns = @JoinColumn(name="id_of_genre")
    )
    private List<Genre> listOfGenre;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE
    })
    private List<Picture> listOfPicture;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.REMOVE
    })
    private List<Review> listOfReview;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    private List<OrderDetail> listOfOrderDetail;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE
    })
    private List<WishList> listOfWhisList;
}
