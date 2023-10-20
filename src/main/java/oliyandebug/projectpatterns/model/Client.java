package oliyandebug.projectpatterns.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Address address;
    @ManyToMany()
    private List<BookBorrowed> booksBorrowed;
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }

    public List<BookBorrowed> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(List<BookBorrowed> book) {
        this.booksBorrowed = book;
    }
}
