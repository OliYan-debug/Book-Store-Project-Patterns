package oliyandebug.projectpatterns.service;

import oliyandebug.projectpatterns.model.BookBorrowed;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="brasilapi", url="https://brasilapi.com.br")
public interface BrasilApiService {
    @GetMapping("/api/isbn/v1/{isbn}")
    BookBorrowed checkISBN(@PathVariable("isbn") String string);
}
