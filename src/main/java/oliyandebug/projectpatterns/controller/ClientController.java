package oliyandebug.projectpatterns.controller;

import oliyandebug.projectpatterns.model.Client;
import oliyandebug.projectpatterns.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * FACADE Abstraction of complex integrations like database and others apis in one simple class
 * */
@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Optional<Client> client = clientService.findById(id);
        if(client.isPresent()){
            return ResponseEntity.ok().body(client);
        }
        return ResponseEntity.badRequest().body("Client with id not found!");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
        clientService.update(id, client);
        return  ResponseEntity.ok(client);
    }
    @DeleteMapping()
    public ResponseEntity<String> delete(@RequestBody Long id){
        clientService.delete(id);
        return ResponseEntity.accepted().body("Client with id "+ id+ " deleted");
    }
    @PostMapping
    public ResponseEntity<Client> add(@RequestBody Client client){
        clientService.add(client);
        return ResponseEntity.ok(client);
    }


}
