package pl.sztukakodu.lazyinit.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(of = "uuid")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Player {
    @Id
    private String uuid = UUID.randomUUID().toString();
    private String name;
    private String country;

    public Player(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
