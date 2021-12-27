package pl.sztukakodu.lazyinit.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

@Entity
@EqualsAndHashCode(of = "uuid")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
    @Id
    private String uuid = UUID.randomUUID().toString();
    private String name;
    @OneToMany
    private Set<Player> players;

    public Team(String name, Set<Player> players) {
        this.name = name;
        this.players = players;
    }
}
