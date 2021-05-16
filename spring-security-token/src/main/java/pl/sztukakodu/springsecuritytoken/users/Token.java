package pl.sztukakodu.springsecuritytoken.users;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
class Token {
    @Id
    private String digest;

    @ManyToOne
    private User user;
}
