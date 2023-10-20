package oliyandebug.projectpatterns.repository;

import oliyandebug.projectpatterns.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
