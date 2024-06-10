package org.maaProxyBack.persistance;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.maaProxyBack.model.Advisor;
import org.maaProxyBack.model.BankClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
//@DataJpaTest
public class ClientRepositoryTest {

    //@Autowired
    //private TestEntityManager manager;

    @Autowired
    private ClientRepository repo;

    @Test
    void findById_should_find_by_id(){
        BankClient cli = new BankClient();
        cli.getIdentity().setLastName("toto");
        BankClient savedCli = repo.save(cli);
        //BankClient savedCli = manager.persistAndFlush(cli);
        Optional<BankClient> foundCli = repo.findById(savedCli.getId());
        assertTrue(foundCli.isPresent() && Objects.equals(foundCli.get().getId(), savedCli.getId()));
    }

    @Test
    void save_should_create_a_Client(){
        BankClient cli = new BankClient();
        cli.getIdentity().setLastName("toto");
        BankClient savedCli = repo.save(cli);
        //BankClient savedCli = manager.persistAndFlush(cli);
        assertTrue(repo.findById(savedCli.getId()).isPresent());
    }

    @Test
    void delete_should_delete_a_Client(){
        BankClient cli = new BankClient();
        cli.getIdentity().setLastName("toto");
        //BankClient savedCli = manager.persistAndFlush(cli);
        BankClient savedCli = repo.save(cli);
        repo.deleteById(savedCli.getId());
        assertTrue(repo.findById(savedCli.getId()).isEmpty());
    }

    @Test
    void getAllByAdvisor_should_return_a_client_list() {
        long advisorOneId = 1;
        long advisorTwoId = 2;
        Advisor ad1 = new Advisor();
        Advisor ad2 = new Advisor();
        BankClient client1 = new BankClient();
        client1.setAdvisor(ad1);
        client1.getIdentity().setLastName("toto");
        BankClient client2 = new BankClient();
        client2.setAdvisor(ad1);
        client2.getIdentity().setLastName("toto");
        BankClient client3 = new BankClient();
        client3.setAdvisor(ad1);
        client3.getIdentity().setLastName("toto");
        BankClient client4 = new BankClient();
        client4.setAdvisor(ad2);
        client4.getIdentity().setLastName("toto");

        ad1.getClients().addAll(List.of(client1,client2,client3));
        ad2.getClients().add(client4);

        repo.save(client1);
        repo.save(client2);
        repo.save(client3);
        repo.save(client4);

        Assertions.assertFalse(repo.findByAdvisorId(advisorOneId).isEmpty());
        Assertions.assertTrue(repo.findByAdvisorId(advisorOneId).stream()
                .allMatch(c->c.getAdvisor().getId() == advisorOneId));
    }
}
