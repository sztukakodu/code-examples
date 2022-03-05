package pl.sztukakodu.lazyinit;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NamedEntityGraph(
    name = "Blogpost.comments",
    attributeNodes = {@NamedAttributeNode("comments")}
)
public class Blogpost {
    @Id
    private Long id;
    private String title;
    private String content;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Set<Comment> comments;
}
