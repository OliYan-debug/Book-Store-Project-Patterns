package oliyandebug.projectpatterns.service;

import oliyandebug.projectpatterns.model.Client;

import java.util.Optional;


public interface ClientService {
    Iterable<Client> findAll();
    Optional<Client> findById(Long id);
    void add(Client client);
    void update(Long id, Client client);
    void delete(Long id);
}
