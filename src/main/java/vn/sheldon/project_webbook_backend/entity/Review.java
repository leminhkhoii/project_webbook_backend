package vn.sheldon.project_webbook_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_of_review")
    private long idOfReview;

    @Column(name="point_review")
    private float pointReview;

    @Column(name = "comment")
    private String comment;

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
    @JoinColumn(name="id_of_user", nullable = false)
    private User user;
}
