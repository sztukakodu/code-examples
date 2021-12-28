package pl.sztukakodu.lazyinit.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

@Entity
@EqualsAndHashCode(of = "uuid")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class Team {
    @Id
    private String uuid = UUID.randomUUID().toString();

    private String name;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "team_id")
    private Set<Player> players;

    public Team(String name, Set<Player> players) {
        this.name = name;
        this.players = players;
    }
}
