package fr.groupe_3.fil_rouge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

    // Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type_presta")
    private String typePresta;

    private String designation;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients client;

    @Column(name = "nb_days")
    private Integer nbDays;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Enumerated(EnumType.ORDINAL)
    private StateEnum state;

    // Constructeurs
    public Orders() {
    }

    public Orders(String typePresta, String designation, Integer nbDays, Integer unitPrice, StateEnum state) {
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.state = state;
    }

    // Getters Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Integer getNbDays() {
        return nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    // To string

    @Override
    public String toString() {
        return "Orders [id=" + id + ", typePresta=" + typePresta + ", designation=" + designation + ", nbDays=" + nbDays
                + ", unitPrice=" + unitPrice + ", state=" + state + "]";
    }

}
