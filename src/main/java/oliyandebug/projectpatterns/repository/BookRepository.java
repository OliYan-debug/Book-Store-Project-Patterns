package oliyandebug.projectpatterns.repository;

import oliyandebug.projectpatterns.model.BookBorrowed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookBorrowed, String> {
}
