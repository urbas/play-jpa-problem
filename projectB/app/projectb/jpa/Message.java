package projectb.jpa;

import projecta.jpa.Client;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue
    public long id;

    @ManyToOne(optional = false, cascade = {
            CascadeType.REMOVE
    })
    public Client client;
}
