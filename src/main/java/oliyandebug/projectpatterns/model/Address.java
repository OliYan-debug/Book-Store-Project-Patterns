package oliyandebug.projectpatterns.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {
    @Id
    @JsonAlias("cep")
    private String zipCode;
    @JsonAlias("logradouro")
    private String street;
    @JsonAlias("bairro")
    private String district;

    @JsonAlias("localidade")
    private String city;
    @JsonAlias("uf")
    private String state;



    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String cep) {
        this.zipCode = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String bairro) {
        this.district = bairro;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String uf) {
        this.state = uf;
    }


}
