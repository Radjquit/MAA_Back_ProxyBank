package org.maaProxyBack.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Advisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private Identity identity = new Identity();

    @OneToMany(mappedBy = "advisor",cascade = CascadeType.PERSIST)
    private List<Client2> clients = new ArrayList<>(10);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public List<Client2> getClients() {
        return clients;
    }

    public void setClients(List<Client2> clients) {
        this.clients = clients;
    }
}
