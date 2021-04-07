package pl.sztukakodu.live.tweets.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Tweet {

    @Id
    private String id = UUID.randomUUID().toString();

    private String author;

    @Column(length = 280)
    private String text;
    private LocalDateTime createdAt;

    public Tweet(String author, String text, LocalDateTime createdAt) {
        this.author = author;
        this.text = StringUtils.substring(text, 0, 280);
        this.createdAt = createdAt;
    }
}
