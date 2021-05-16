package pl.sztukakodu.springsecuritytoken.users;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class User {
    @Id
    Long id;
}
