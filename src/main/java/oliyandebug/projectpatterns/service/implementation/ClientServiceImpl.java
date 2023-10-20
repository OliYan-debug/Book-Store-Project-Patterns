package oliyandebug.projectpatterns.service.implementation;

import oliyandebug.projectpatterns.model.Address;
import oliyandebug.projectpatterns.model.BookBorrowed;
import oliyandebug.projectpatterns.model.Client;
import oliyandebug.projectpatterns.repository.AddressRepository;
import oliyandebug.projectpatterns.repository.BookRepository;
import oliyandebug.projectpatterns.repository.ClientRepository;
import oliyandebug.projectpatterns.service.BrasilApiService;
import oliyandebug.projectpatterns.service.ClientService;
import oliyandebug.projectpatterns.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
//    SINGLETON Spring components injection with @Autowired
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Autowired
    private BrasilApiService brasilApiService;

    // STRATEGY Implementation of interface methods
    // FACADE Abstraction of subsystems, providing a simple interface

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void add(Client client) {
        saveClient(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientDB = clientRepository.findById(id);
        if(clientDB.isPresent()) saveClient(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
    private void saveClient(Client client){
        String cep = client.getAddress().getZipCode();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.checkCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        List<BookBorrowed> books = new ArrayList<>();
        for(BookBorrowed book : client.getBooksBorrowed()) {
            String isbn = book.getIsbn();
            BookBorrowed bookDB = bookRepository.findById(isbn).orElseGet(() -> {
                BookBorrowed newBook = brasilApiService.checkISBN(isbn);
                bookRepository.save(newBook);
                return newBook;
            });
            books.add(bookDB);
        }
        client.setBooksBorrowed(books);

        clientRepository.save(client);
    }
}
