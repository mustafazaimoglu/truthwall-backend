package dev.mkz.truthwall.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "dislikes")
public class Dislike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dislike_id")
    private int likeId;

    @Column(name = "post_id")
    private int postId;

    @Column(name = "user_id")
    private int userId;
}
