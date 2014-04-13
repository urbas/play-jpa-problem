package projectb.jpa;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue
    public long id;
}
