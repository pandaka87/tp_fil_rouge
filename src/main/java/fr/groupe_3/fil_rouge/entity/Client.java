package fr.groupe_3.fil_rouge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

  // Attributs
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "company_name")
  private String companyName;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  private String email;

  private String phone;

  private String adress;

  @Column(name = "zip_code")
  private String zipCode;

  private String city;

  private String country;

  @Column(name = "state")
  @Enumerated(EnumType.ORDINAL)
  private EtatClient state;

  // private Integer state;

  // Constructeurs
  public Client() {

  }

  public Client(String companyName, String firstName, String lastName, String email, String phone,
      String adress, String zipCode, String city, String country) {
    this.companyName = companyName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.adress = adress;
    this.zipCode = zipCode;
    this.city = city;
    this.country = country;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public EtatClient getState() {
    return state;
  }

  public void setState(EtatClient state) {
    this.state = state;
  }

  // public Integer getState() {
  // return state;
  // }

  // public void setState(Integer state) {
  // this.state = state;
  // }

  public void updateNotNull(Client clientPatch) {
    // Company name
    if (clientPatch.getCompanyName() != null) {
      this.setCompanyName(clientPatch.getCompanyName());
    }
    // FirstName
    if (clientPatch.getFirstName() != null) {
      this.setFirstName(clientPatch.getFirstName());
    }
    // LastName
    if (clientPatch.getLastName() != null) {
      this.setLastName(clientPatch.getLastName());
    }
    // Email
    if (clientPatch.getEmail() != null) {
      this.setEmail(clientPatch.getEmail());
    }

    // Phone
    if (clientPatch.getPhone() != null) {
      this.setPhone(clientPatch.getPhone());
    }
    // Adress

    if (clientPatch.getAdress() != null) {
      this.setAdress(clientPatch.getAdress());
    }

    // ZipCode
    if (clientPatch.getZipCode() != null) {
      this.setZipCode(clientPatch.getZipCode());
    }

    // City
    if (clientPatch.getCity() != null) {
      this.setCity(clientPatch.getCity());
    }

    // Country
    if (clientPatch.getCountry() != null) {
      this.setCountry(clientPatch.getCountry());
    }

    // State
    if (clientPatch.getState() != null) {
      this.setState(clientPatch.getState());
    }
  }

}