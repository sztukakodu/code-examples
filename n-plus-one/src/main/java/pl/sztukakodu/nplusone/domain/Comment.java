package pl.sztukakodu.nplusone.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(of = "uuid")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String uuid = UUID.randomUUID().toString();

    @Column(length = 2048)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnoreProperties("comments")
    Post post;
}
