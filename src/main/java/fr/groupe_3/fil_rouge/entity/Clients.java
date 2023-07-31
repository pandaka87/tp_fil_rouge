package fr.groupe_3.fil_rouge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Clients {

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

  private String address;

  @Column(name = "zip_code")
  private String zipCode;

  private String city;

  private String country;

  private Integer state;

  public Clients(
      Integer id,
      String companyName,
      String firstName,
      String lastName,
      String email,
      String phone,
      String address,
      String zipCode,
      String city,
      String country,
      Integer state) {
    this.id = id;
    this.companyName = companyName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.zipCode = zipCode;
    this.city = city;
    this.country = country;
    this.state = state;
  }

  public Clients() {
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return ("Clients [id=" +
        id +
        ", companyName=" +
        companyName +
        ", firstName=" +
        firstName +
        ", lastName=" +
        lastName +
        ", email=" +
        email +
        ", phone=" +
        phone +
        ", address=" +
        address +
        ", zipCode=" +
        zipCode +
        ", city=" +
        city +
        ", country=" +
        country +
        ", state=" +
        state +
        "]");
  }
}