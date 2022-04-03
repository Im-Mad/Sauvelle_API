package ma.sauvelle.repository;

import ma.sauvelle.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client save(Client client);
    List<Client> findAll();
    Client findClientByUsername(String username);
}
