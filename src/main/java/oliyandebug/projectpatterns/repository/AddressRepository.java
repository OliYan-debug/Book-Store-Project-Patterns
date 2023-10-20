package oliyandebug.projectpatterns.repository;

import oliyandebug.projectpatterns.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
}
