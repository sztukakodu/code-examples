package pl.sztukakodu.nplusone.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(of = "uuid")
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String uuid = UUID.randomUUID().toString();

    @Column(length = 2048)
    private String content;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "post_id")
    @JsonIgnoreProperties("post")
    private Set<Comment> comments = new HashSet<>();

    public void addComment(Comment comment) {
        this.comments.add(comment);
        comment.setPost(this);
    }
}
